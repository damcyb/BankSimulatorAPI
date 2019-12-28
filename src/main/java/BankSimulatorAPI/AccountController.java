package BankSimulatorAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class AccountController {

    @Autowired
    UserAccountRepository userAccountRepository;

    @GetMapping("/")
    public List<UserAccount> showAccounts() {
        return userAccountRepository.findAll();
    }

    @GetMapping("/{id}")
    public UserAccount showUserAccountById(@PathVariable String id) {
        return userAccountRepository.findOne(Integer.parseInt(id));
    }

    @PostMapping("/")
    public UserAccount createUserAccount(@RequestBody Map<String, String> body) {

        String firstName = body.get("firstName");
        String lastName = body.get("lastName");
        String login = body.get("login");
        String password = body.get("userPassword");
        String userAccountNumber = body.get("accountNumber");
        double balance = Double.parseDouble(body.get("balance"));

        return userAccountRepository.save(
                new UserAccount(firstName, lastName, login, password, userAccountNumber, balance));
    }

    @DeleteMapping("/{id}")
    public boolean deleteUserAccount(@PathVariable String id) {
        int userAccountId = Integer.parseInt(id);
        userAccountRepository.delete(userAccountId);
        return true;
    }
}
