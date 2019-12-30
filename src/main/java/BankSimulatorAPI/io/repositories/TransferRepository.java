package BankSimulatorAPI.io.repositories;

import BankSimulatorAPI.io.entities.TransferEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends CrudRepository<TransferEntity, Long> {
    TransferEntity findByUserId(String userId);

}
