package yu.cohort11.BankAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import yu.cohort11.BankAPI.models.Bill;

@Repository
public interface BillRepository extends CrudRepository<Bill, Long> {
}