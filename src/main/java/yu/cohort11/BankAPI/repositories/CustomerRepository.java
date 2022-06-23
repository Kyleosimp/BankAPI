package yu.cohort11.BankAPI.repositories;

import org.springframework.data.repository.CrudRepository;
import yu.cohort11.BankAPI.models.Customer;

import java.util.List;

public interface CustomerRepository extends CrudRepository <Customer, Long> {

    List<Customer> findCustomerById(Long id);

}
