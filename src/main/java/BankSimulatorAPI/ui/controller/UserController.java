package BankSimulatorAPI.ui.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping
    public String getUsers() {
        return "Get users";
    }

    @PostMapping
    public String createUser() {
        return "User was created";
    }

    @PutMapping
    public String updateUser() {
        return "User updated";
    }

    @DeleteMapping
    public String deleteUser() {
        return "User deleted";
    }
}
