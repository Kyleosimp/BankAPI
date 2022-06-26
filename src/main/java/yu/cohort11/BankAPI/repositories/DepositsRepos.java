package yu.cohort11.BankAPI.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import yu.cohort11.BankAPI.models.Deposits;

import java.util.Set;

@Repository
public interface DepositsRepos extends CrudRepository<Deposits, Long> {

   // Set<Deposits> findDepositsByAccountId(Long accountId);

}
