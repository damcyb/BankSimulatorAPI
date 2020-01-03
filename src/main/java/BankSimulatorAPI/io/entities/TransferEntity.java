package BankSimulatorAPI.io.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "transfers")
public class TransferEntity implements Serializable {

    private static final long serialVersionUID = 8953144341380334959L;

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "userId", nullable = false)
    private String userId;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "transferredMoney", nullable = false)
    private double transferredMoney;

    @Column(name = "receiverAccountNumber", nullable = false)
    private String receiverAccountNumber;

    @Column(name = "balanceBeforeOperation")
    private double balanceBeforeOperation;

    @Column(name = "balanceAfterOperation")
    private double balanceAfterOperation;

    @Column(name = "receiverFirstName", nullable = false, length = 50)
    private String receiverFirstName;

    @Column(name = "receiverLastName", nullable = false, length = 50)
    private String receiverLastName;

    @Column(name = "senderFirstName", nullable = false, length = 50)
    private String senderFirstName;

    @Column(name = "senderLastName", nullable = false, length = 50)
    private String senderLastName;

    @Column(name = "senderAccountNumber", nullable = false)
    private String senderAccountNumber;

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
}
