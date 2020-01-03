package BankSimulatorAPI.service.impl;

import BankSimulatorAPI.io.entities.TransferEntity;
import BankSimulatorAPI.io.entities.UserEntity;
import BankSimulatorAPI.io.repositories.TransferRepository;
import BankSimulatorAPI.io.repositories.UserRepository;
import BankSimulatorAPI.service.TransferService;
import BankSimulatorAPI.shared.Utils;
import BankSimulatorAPI.shared.dto.TransferDto;
import BankSimulatorAPI.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    TransferRepository transferRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Override
    public TransferDto createTransfer(TransferDto transfer, String accountNumber, double balance, double transferredMoney,
                                        String receiverFirstName, String receiverLastName) {

        TransferEntity transferEntity = new TransferEntity();
        BeanUtils.copyProperties(transfer, transferEntity);
        transferEntity.setId(0); //reset id to auto-generate in database
        transferEntity.setDate(utils.generatePublicDateAsString());
        transferEntity.setTransferredMoney(Math.abs(transferredMoney));
        transferEntity.setSenderFirstName(transfer.getSenderFirstName());
        transferEntity.setSenderLastName(transfer.getSenderLastName());
        transferEntity.setSenderAccountNumber(transfer.getSenderAccountNumber());
        transferEntity.setReceiverAccountNumber(accountNumber);
        transferEntity.setReceiverFirstName(receiverFirstName);
        transferEntity.setReceiverLastName(receiverLastName);
        transferEntity.setBalanceAfterOperation(balance + transferredMoney);
        transferEntity.setBalanceBeforeOperation(balance);
        TransferEntity storedTransferDetails = transferRepository.save(transferEntity);
        TransferDto returnValue = new TransferDto();
        BeanUtils.copyProperties(storedTransferDetails, returnValue);

        return returnValue;
    }

    @Override
    public List<TransferDto> getListOfTransfers(String userId) {
        UserEntity userEntity = userRepository.findByUserId(userId);
        List<TransferDto> returnValue = new ArrayList<>();
        List<TransferEntity> transfers = (List<TransferEntity>) transferRepository.findAll();
        for (TransferEntity transfer: transfers) {
            if(transfer.getUserId().equals(userId) &&
                    !transfer.getSenderAccountNumber().equals(transfer.getReceiverAccountNumber())) {
                TransferDto transferDto = new TransferDto();
                BeanUtils.copyProperties(transfer, transferDto);
                transferDto.setTransferDirection("SENT");
                returnValue.add(transferDto);
            }
            if(transfer.getReceiverAccountNumber().equals(userEntity.getAccountNumber()) &&
                    !transfer.getSenderAccountNumber().equals(transfer.getReceiverAccountNumber())) {
                TransferDto transferDto = new TransferDto();
                BeanUtils.copyProperties(transfer, transferDto);
                transferDto.setTransferDirection("RECEIVED");
                returnValue.add(transferDto);
            }
            if(transfer.getUserId().equals(userId) &&
                    transfer.getSenderAccountNumber().equals(transfer.getReceiverAccountNumber())) {
                TransferDto transferDto = new TransferDto();
                BeanUtils.copyProperties(transfer, transferDto);
                if(transfer.getBalanceAfterOperation() > transfer.getBalanceBeforeOperation()) {
                    transferDto.setTransferDirection("DEPOSIT");
                }
                if(transfer.getBalanceAfterOperation() < transfer.getBalanceBeforeOperation()) {
                    transferDto.setTransferDirection("WITHDRAW");
                }
                returnValue.add(transferDto);
            }
        }
        return returnValue;
    }
}
