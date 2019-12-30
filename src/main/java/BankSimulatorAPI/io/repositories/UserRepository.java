package BankSimulatorAPI.io.repositories;

import BankSimulatorAPI.io.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
    UserEntity findByUserId(String id);
    UserEntity findByAccountNumber(String accountNumber);
}
