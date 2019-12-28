package BankSimulatorAPI.service;

import BankSimulatorAPI.shared.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
}
