package BankSimulatorAPI.ui.model.request;

public class TransferMoneyRequestModel {

    private String receiverFirstName;
    private String receiverLastName;
    private String receiverAccount;
    private double transferredMoney;

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

    public String getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccount(String receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    public double getTransferredMoney() {
        return transferredMoney;
    }

    public void setTransferredMoney(double transferredMoney) {
        this.transferredMoney = transferredMoney;
    }
}
