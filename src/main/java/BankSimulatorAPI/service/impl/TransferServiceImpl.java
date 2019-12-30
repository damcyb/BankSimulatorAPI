package BankSimulatorAPI.service.impl;

import BankSimulatorAPI.io.entities.TransferEntity;
import BankSimulatorAPI.io.entities.UserEntity;
import BankSimulatorAPI.io.repositories.TransferRepository;
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
    Utils utils;

    @Override
    public TransferDto createTransfer(TransferDto transfer, String accountNumber, double balance, double transferredMoney,
                                        String receiverFirstName, String receiverLastName) {

        TransferEntity transferEntity = new TransferEntity();
        BeanUtils.copyProperties(transfer, transferEntity);
        transferEntity.setId(0); //reset id to auto-generate in database
        transferEntity.setDate(utils.generatePublicDateAsString());
        transferEntity.setTransferredMoney(transferredMoney);
        transferEntity.setReceiverAccountNumber(accountNumber);
        transferEntity.setReceiverFirstName(receiverFirstName);
        transferEntity.setReceiverLastName(receiverLastName);
        transferEntity.setBalanceAfterOperation(balance);
        transferEntity.setBalanceBeforeOperation(balance + transferredMoney);
        TransferEntity storedTransferDetails = transferRepository.save(transferEntity);
        TransferDto returnValue = new TransferDto();
        BeanUtils.copyProperties(storedTransferDetails, returnValue);

        return returnValue;
    }

    @Override
    public List<TransferDto> getListOfTransfers(String userId) {
        List<TransferDto> returnValue = new ArrayList<>();
        //Page<UserEntity> usersPage = userRepository.findAll(pageableRequest);

        List<TransferEntity> transfers = (List<TransferEntity>) transferRepository.findAll();
        //List<TransferEntity> transfers = transfersPage.getContent();
        for (TransferEntity transfer: transfers) {
            if(transfer.getUserId().equals(userId)) {
                TransferDto transferDto = new TransferDto();
                BeanUtils.copyProperties(transfer, transferDto);
                returnValue.add(transferDto);
                //BeanUtils.copyProperties(transfer, returnValue.get(returnValue.size() - 1));
            }
        }
        return returnValue;
    }
}
