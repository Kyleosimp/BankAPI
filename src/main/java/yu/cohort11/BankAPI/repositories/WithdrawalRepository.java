package yu.cohort11.BankAPI.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import yu.cohort11.BankAPI.models.Withdrawal;

@Repository
public interface WithdrawalRepository extends CrudRepository<Withdrawal, Long> {
}
