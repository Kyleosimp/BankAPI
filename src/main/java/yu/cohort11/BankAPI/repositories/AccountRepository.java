package yu.cohort11.BankAPI.repositories;

import org.springframework.data.repository.CrudRepository;
import yu.cohort11.BankAPI.models.Account;

public interface AccountRepository extends CrudRepository<Account,Long> {
}
