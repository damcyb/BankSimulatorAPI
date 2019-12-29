package BankSimulatorAPI.service;

import BankSimulatorAPI.shared.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(String id);
    UserDto getUserByEmailAndPassword(UserDto userDto);
    UserDto updateUser(UserDto userDto, String userId);
    void deleteUser(String userId);
    UserDto depositMoney(double depositedMoney, String userId);
}
