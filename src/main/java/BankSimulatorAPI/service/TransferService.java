package BankSimulatorAPI.service;

import BankSimulatorAPI.shared.dto.TransferDto;

import java.util.List;

public interface TransferService {
    TransferDto createTransfer(TransferDto transferDto, String accountNumber, double balance, double transferredMoney,
                                String receiverFirstName, String receiverLastName);
    List<TransferDto> getListOfTransfers(String userId);
}
