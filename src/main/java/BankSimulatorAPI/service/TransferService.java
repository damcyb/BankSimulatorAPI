package BankSimulatorAPI.service;

import BankSimulatorAPI.shared.dto.TransferDto;

public interface TransferService {
    TransferDto createTransfer(TransferDto transferDto, String accountNumber, double balance, double transferredMoney);
}
