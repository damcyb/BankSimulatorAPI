package BankSimulatorAPI.ui.controller;

import BankSimulatorAPI.service.TransferService;
import BankSimulatorAPI.service.UserService;
import BankSimulatorAPI.shared.dto.TransferDto;
import BankSimulatorAPI.shared.dto.UserDto;
import BankSimulatorAPI.ui.model.request.*;
import BankSimulatorAPI.ui.model.response.OperationStatusModel;
import BankSimulatorAPI.ui.model.response.RequestOperationStatus;
import BankSimulatorAPI.ui.model.response.TransferRest;
import BankSimulatorAPI.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    TransferService transferService;

    @GetMapping("/transfer/{userId}")
    public List<TransferRest> getListOfTransfers(@PathVariable String userId) {
        List<TransferRest> returnValue = new ArrayList<>();
        List<TransferDto> listOfTransferDto = transferService.getListOfTransfers(userId);
        for (TransferDto transfer: listOfTransferDto) {
            TransferRest transferRest = new TransferRest();
            BeanUtils.copyProperties(transfer, transferRest);
            if(transfer.getTransferDirection().equals("SENT")) {
                transferRest.setFirstName(transfer.getReceiverFirstName());
                transferRest.setLastName(transfer.getReceiverLastName());
                transferRest.setAccountNumber(transfer.getReceiverAccountNumber());
            }
            if(transfer.getTransferDirection().equals("RECEIVED")) {
                transferRest.setFirstName(transfer.getSenderFirstName());
                transferRest.setLastName(transfer.getSenderLastName());
                transferRest.setAccountNumber(transfer.getSenderAccountNumber());
            }
            if(transfer.getTransferDirection().equals("DEPOSIT") || transfer.getTransferDirection().equals("WITHDRAW")) {
                transferRest.setFirstName(transfer.getReceiverFirstName());
                transferRest.setLastName(transfer.getReceiverLastName());
                transferRest.setAccountNumber(transfer.getReceiverAccountNumber());
            }
            returnValue.add(transferRest);
        }
        return returnValue;
    }

    @GetMapping(path = "/{userId}")
    public UserRest getUser(@PathVariable String userId) {
        UserRest returnValue = new UserRest();
        UserDto userDto = userService.getUserById(userId);
        BeanUtils.copyProperties(userDto, returnValue);
        return returnValue;
    }

    @PostMapping(path = "/login")
    public UserRest loginUser(@RequestBody UserLoginRequestModel userDetails) {
        UserRest returnValue = new UserRest();
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);
        UserDto gotUser = userService.getUserByEmailAndPassword(userDto);
        BeanUtils.copyProperties(gotUser, returnValue);
        return returnValue;
    }

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {
        UserRest returnValue = new UserRest();
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);
        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, returnValue);
        return returnValue;
    }

    @DeleteMapping(path = "/{userId}")
    public OperationStatusModel deleteUser(@PathVariable String userId) {
        OperationStatusModel returnValue = new OperationStatusModel();
        returnValue.setOperationName(RequestOperationName.DELETE.name());
        userService.deleteUser(userId);
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
        return returnValue;
    }

    @PutMapping(path = "/{userId}")
    public UserRest updateUser(@RequestBody UserDetailsRequestModel userDetails, @PathVariable String userId) {
        UserRest returnValue = new UserRest();
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);
        UserDto updatedUser = userService.updateUser(userDto, userId);
        BeanUtils.copyProperties(updatedUser, returnValue);
        return returnValue;
    }

    @PutMapping(path = "/deposit/{userId}")
    public UserRest depositMoney(@RequestBody DepositMoneyRequestModel userDetails, @PathVariable String userId) {
        if(userDetails.getDepositedMoney() <= 0.0) {
            throw new RuntimeException("Incorrect amount of deposited money");
        }
        UserRest returnValue = new UserRest();
        double depositedMoney = userDetails.getDepositedMoney();
        UserDto updatedUser = userService.depositMoney(depositedMoney, userId);

        TransferDto transferDto = new TransferDto();
        BeanUtils.copyProperties(updatedUser, transferDto);
        transferDto.setSenderAccountNumber(updatedUser.getAccountNumber());
        transferDto.setSenderFirstName(updatedUser.getFirstName());
        transferDto.setSenderLastName(updatedUser.getLastName());
        double balance = updatedUser.getBalance();
        String accountNumber = updatedUser.getAccountNumber();
        double transferredMoney = userDetails.getDepositedMoney();
        String receiverFirstName = updatedUser.getFirstName();
        String receiverLastName = updatedUser.getLastName();
        transferService.createTransfer(transferDto, accountNumber, balance, transferredMoney, receiverFirstName, receiverLastName);

        BeanUtils.copyProperties(updatedUser, returnValue);
        return returnValue;
    }

    @PutMapping(path = "/withdraw/{userId}")
    public UserRest withdrawMoney(@RequestBody WithdrawMoneyRequestModel userDetails, @PathVariable String userId) {
        if(userDetails.getWithdrawMoney() <= 0) {
            throw new RuntimeException("Wrong amount of withdraw money");
        }
        UserRest returnValue = new UserRest();
        double withdrawMoney = userDetails.getWithdrawMoney();
        UserDto updatedUser = userService.withdrawMoney(withdrawMoney, userId);

        TransferDto transferDto = new TransferDto();
        BeanUtils.copyProperties(updatedUser, transferDto);
        transferDto.setSenderAccountNumber(updatedUser.getAccountNumber());
        transferDto.setSenderFirstName(updatedUser.getFirstName());
        transferDto.setSenderLastName(updatedUser.getLastName());
        double balance = updatedUser.getBalance();
        String accountNumber = updatedUser.getAccountNumber();
        double transferredMoney = userDetails.getWithdrawMoney();
        String receiverFirstName = updatedUser.getFirstName();
        String receiverLastName = updatedUser.getLastName();
        transferService.createTransfer(transferDto, accountNumber, balance, -transferredMoney, receiverFirstName, receiverLastName);

        BeanUtils.copyProperties(updatedUser, returnValue);
        return returnValue;
    }

    @PutMapping(path = "/transfer/{userId}")
    public UserRest transferMoney(@RequestBody TransferMoneyRequestModel transferDetails, @PathVariable String userId) {
        if(transferDetails.getTransferredMoney() <= 0) {
            throw new RuntimeException("Wrong amount of transferred money");
        }
        UserRest returnValue = new UserRest();
        double transferredMoney = transferDetails.getTransferredMoney();
        String accountNumber = transferDetails.getReceiverAccount();
        String receiverFirstName = transferDetails.getReceiverFirstName();
        String receiverLastName = transferDetails.getReceiverLastName();
        UserDto updatedUser = userService.transferMoney(transferredMoney, userId, accountNumber);

        TransferDto transferDto = new TransferDto();
        BeanUtils.copyProperties(updatedUser, transferDto);
        transferDto.setSenderAccountNumber(updatedUser.getAccountNumber());
        transferDto.setSenderFirstName(updatedUser.getFirstName());
        transferDto.setSenderLastName(updatedUser.getLastName());
        double balance = updatedUser.getBalance();
        transferService.createTransfer(transferDto, accountNumber, balance, -transferredMoney, receiverFirstName, receiverLastName);

        BeanUtils.copyProperties(updatedUser, returnValue);
        return returnValue;
    }
}
