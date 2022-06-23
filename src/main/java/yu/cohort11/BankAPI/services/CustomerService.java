package yu.cohort11.BankAPI.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yu.cohort11.BankAPI.exception.ResourceNotFoundException;
import yu.cohort11.BankAPI.models.Customer;
import yu.cohort11.BankAPI.repositories.CustomerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    protected void verifyId(Long id) throws ResourceNotFoundException {
        if (customerRepository.existsById(id) == false) {
            throw new ResourceNotFoundException("Customer with id " + id + " not found");
        }
    }

    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public List<Customer> getAllCustomer() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }

    public Customer updateCustomer(Long customerId, Customer customer) {
        verifyId(customerId);
        for (Customer c : getAllCustomer()) {
            if (c.getId() == customerId) {
                customerRepository.save(customer);
            }
        }
        return customer;
    }

    public Optional<Customer> getCustomerById(Long id){
        verifyId(id);
        return customerRepository.findById(id);
    }

    public  void  deleteCustomerById(Long id){
        verifyId(id);
        customerRepository.deleteById(id);
    }


}
