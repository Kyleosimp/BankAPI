package yu.cohort11.BankAPI.repositories;

import org.springframework.data.repository.CrudRepository;
import yu.cohort11.BankAPI.models.LoanRequest;

public interface LoanRequestRepository extends CrudRepository<LoanRequest,Long> {
}
