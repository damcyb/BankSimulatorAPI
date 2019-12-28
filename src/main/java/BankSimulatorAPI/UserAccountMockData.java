package BankSimulatorAPI;

import java.util.ArrayList;
import java.util.List;

public class UserAccountMockData {

//    private List<UserAccount> listUserAccount;
//
//    private static UserAccountMockData instance = null;
//
//    public static UserAccountMockData getInstance() {
//        if(instance == null) {
//            instance = new UserAccountMockData();
//        }
//        return instance;
//    }
//
//    UserAccountMockData() {
//
//        listUserAccount = new ArrayList<UserAccount>();
//
//        listUserAccount.add(
//                new UserAccount(1, "Damian", "Cybulski", "111111", "qwerty", 1234, 1000)
//        );
//        listUserAccount.add(
//                new UserAccount(2, "Kamil", "Wójcik", "222222", "qwerty", 2345, 1000)
//        );
//        listUserAccount.add(
//                new UserAccount(3, "Gosia", "Nowicka", "333333", "qwerty", 3456, 1000)
//        );
//        listUserAccount.add(
//                new UserAccount(4, "Szymon", "Sendłak", "444444", "qwerty", 4567, 1000)
//        );
//    }
//
//    public List<UserAccount> fetchAccounts() {
//        return listUserAccount;
//    }
//
//    public UserAccount getUserAccountById(int id) {
//        for (UserAccount userAccount: listUserAccount
//             ) {
//            if(userAccount.getId() == id) {
//                return userAccount;
//            }
//        }
//        return null;
//    }
//
//    public UserAccount postNewUserAccount(int id, String firstName, String lastName, String login,
//                                          String password, long userAccountNumber, double balance) {
//
//        UserAccount newUserAccount = new UserAccount(id, firstName, lastName, login,
//                password, userAccountNumber, balance);
//
//        listUserAccount.add(newUserAccount);
//        return newUserAccount;
//    }
//
//    public boolean deleteUserAccountById(int id) {
//        int indexOf = -1;
//        for (UserAccount userAccount: listUserAccount
//             ) {
//            if(userAccount.getId() == id) {
//                indexOf = listUserAccount.indexOf(userAccount);
//                continue;
//            }
//        }
//        if(indexOf > -1) {
//            listUserAccount.remove(indexOf);
//        }
//        return true;
//    }
}
