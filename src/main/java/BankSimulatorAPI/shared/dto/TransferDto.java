package BankSimulatorAPI.shared.dto;

import java.io.Serializable;

public class TransferDto implements Serializable {

    private static final long serialVersionUID = 5904391901508630223L;
    private long id;
    private String userId;
    private String date;
    private double transferredMoney;
    private String receiverAccountNumber;
    private String receiverFirstName;
    private String receiverLastName;
    private double balanceBeforeOperation;
    private double balanceAfterOperation;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTransferredMoney() {
        return transferredMoney;
    }

    public void setTransferredMoney(double transferredMoney) {
        this.transferredMoney = transferredMoney;
    }

    public String getReceiverAccountNumber() {
        return receiverAccountNumber;
    }

    public void setReceiverAccountNumber(String receiverAccountNumber) {
        this.receiverAccountNumber = receiverAccountNumber;
    }

    public double getBalanceBeforeOperation() {
        return balanceBeforeOperation;
    }

    public void setBalanceBeforeOperation(double balanceBeforeOperation) {
        this.balanceBeforeOperation = balanceBeforeOperation;
    }

    public double getBalanceAfterOperation() {
        return balanceAfterOperation;
    }

    public void setBalanceAfterOperation(double balanceAfterOperation) {
        this.balanceAfterOperation = balanceAfterOperation;
    }

    public String getReceiverFirstName() {
        return receiverFirstName;
    }

    public void setReceiverFirstName(String receiverFirstName) {
        this.receiverFirstName = receiverFirstName;
    }

    public String getReceiverLastName() {
        return receiverLastName;
    }

    public void setReceiverLastName(String receiverLastName) {
        this.receiverLastName = receiverLastName;
    }
}

