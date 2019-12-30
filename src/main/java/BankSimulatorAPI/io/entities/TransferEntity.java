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
}
