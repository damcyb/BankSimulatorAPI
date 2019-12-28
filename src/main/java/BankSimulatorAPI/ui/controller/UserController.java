package BankSimulatorAPI.ui.controller;

import BankSimulatorAPI.service.UserService;
import BankSimulatorAPI.shared.dto.UserDto;
import BankSimulatorAPI.ui.model.request.UserDetailsRequestModel;
import BankSimulatorAPI.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getUsers() {
        return "Get users";
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

    @PutMapping
    public String updateUser() {
        return "User updated";
    }

    @DeleteMapping
    public String deleteUser() {
        return "User deleted";
    }
}
