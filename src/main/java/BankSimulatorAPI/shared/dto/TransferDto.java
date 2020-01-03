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
    private String senderFirstName;
    private String senderLastName;
    private String senderAccountNumber;
    private double balanceBeforeOperation;
    private double balanceAfterOperation;
    private String transferDirection;

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

    public String getSenderFirstName() {
        return senderFirstName;
    }

    public void setSenderFirstName(String senderFirstName) {
        this.senderFirstName = senderFirstName;
    }

    public String getSenderLastName() {
        return senderLastName;
    }

    public void setSenderLastName(String senderLastName) {
        this.senderLastName = senderLastName;
    }

    public String getSenderAccountNumber() {
        return senderAccountNumber;
    }

    public void setSenderAccountNumber(String senderAccountNumber) {
        this.senderAccountNumber = senderAccountNumber;
    }

    public String getTransferDirection() {
        return transferDirection;
    }

    public void setTransferDirection(String transferDirection) {
        this.transferDirection = transferDirection;
    }
}

