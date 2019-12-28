package BankSimulatorAPI.ui.controller;

import BankSimulatorAPI.service.UserService;
import BankSimulatorAPI.shared.dto.UserDto;
import BankSimulatorAPI.ui.model.request.UserDetailsRequestModel;
import BankSimulatorAPI.ui.model.request.UserLoginRequestModel;
import BankSimulatorAPI.ui.model.response.UserRest;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

//    @GetMapping(value = "{id}")
//    public UserRest getUser(@PathVariable String id) {
//        UserRest returnValue = new UserRest();
//        UserDto userDto = userService.getUserById(id);
//        BeanUtils.copyProperties(userDto, returnValue);
//        return returnValue;
//    }
    @GetMapping
    public UserRest loginUser(@RequestBody UserLoginRequestModel userDetails) {
        UserRest returnValue = new UserRest();
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);
        UserDto gotUser = userService.getUserByEmailAndPassword(userDto);
        BeanUtils.copyProperties(gotUser, returnValue);
        return returnValue;
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
