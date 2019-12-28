package BankSimulatorAPI.service;

import BankSimulatorAPI.shared.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(String id);
    UserDto getUserByEmailAndPassword(UserDto userDto);
}
