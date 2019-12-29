package BankSimulatorAPI.service.impl;

import BankSimulatorAPI.constants.Constants;
import BankSimulatorAPI.io.entities.UserEntity;
import BankSimulatorAPI.io.repositories.UserRepository;
import BankSimulatorAPI.service.UserService;
import BankSimulatorAPI.shared.Utils;
import BankSimulatorAPI.shared.dto.UserDto;
import javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Override
    public UserDto createUser(UserDto user) {

        if(userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("User already exists");
        }

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        String publicUserId = utils.generatePublicUserId(30);
        userEntity.setUserId(publicUserId);
        String encryptedPassword = user.getPassword();
        userEntity.setEncryptedPassword(encryptedPassword);

        UserEntity storedUserDetails = userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetails, returnValue);
        return returnValue;
    }

    @Override
    public UserDto getUserById(String id) {
        UserDto returnValue = new UserDto();
        return returnValue;
    }

    @Override
    public UserDto getUserByEmailAndPassword(UserDto user) {
        UserEntity userEntity = userRepository.findByEmail(user.getEmail());
        if(userEntity == null) {
            throw new RuntimeException("User not found");
        }

        if(!userEntity.getEmail().equals(user.getEmail()) || !userEntity.getEncryptedPassword().equals(user.getPassword())) {
            throw new RuntimeException("Bad input data, check written email and password");
        }
        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(userEntity, returnValue);
        return returnValue;
    }

    @Override
    public UserDto updateUser(UserDto user, String userId) {
        UserEntity userEntity = userRepository.findByUserId(userId);
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        userEntity.setEmail(userDto.getEmail());
        userEntity.setEncryptedPassword(userDto.getPassword());
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        UserEntity storedUserDetails = userRepository.save(userEntity);
        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetails, returnValue);
        return returnValue;
    }
}
