package BankSimulatorAPI;

import javax.persistence.*;

@Entity
@Table(name = "useraccount")
public class UserAccount {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "login")
    private String login;

    @Column(name = "userpassword")
    private String userPassword;

    @Column(name = "accountnumber")
    private String accountNumber;

    @Column(name = "balance")
    private double balance;

    UserAccount() { }

    UserAccount(String firstName, String lastName, String login, String userPassword, String accountNumber, double balance) {
        setFirstName(firstName);
        setLastName(lastName);
        setLogin(login);
        setUserPassword(userPassword);
        setAccountNumber(accountNumber);
        setBalance(balance);
    }

    UserAccount(int id, String firstName, String lastName, String login, String userPassword, String accountNumber, double balance) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setLogin(login);
        setUserPassword(userPassword);
        setAccountNumber(accountNumber);
        setBalance(balance);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + userPassword + '\'' +
                ", userAccountNumber=" + accountNumber +
                ", balance=" + balance +
                '}';
    }
}
