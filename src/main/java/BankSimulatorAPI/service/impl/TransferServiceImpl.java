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
import org.springframework.stereotype.Service;

@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    TransferRepository transferRepository;

    @Autowired
    Utils utils;

    @Override
    public TransferDto createTransfer(TransferDto transfer, String accountNumber, double balance, double transferredMoney) {

        TransferEntity transferEntity = new TransferEntity();
        BeanUtils.copyProperties(transfer, transferEntity);
        transferEntity.setId(0); //reset id to auto-generate in database
        transferEntity.setDate(utils.generatePublicDateAsString());
        transferEntity.setTransferredMoney(transferredMoney);
        transferEntity.setReceiverAccountNumber(accountNumber);
        transferEntity.setBalanceAfterOperation(balance);
        transferEntity.setBalanceBeforeOperation(balance + transferredMoney);
        TransferEntity storedTransferDetails = transferRepository.save(transferEntity);
        TransferDto returnValue = new TransferDto();
        BeanUtils.copyProperties(storedTransferDetails, returnValue);

        return returnValue;
    }
}
