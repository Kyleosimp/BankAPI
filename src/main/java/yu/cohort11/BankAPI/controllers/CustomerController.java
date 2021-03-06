package yu.cohort11.BankAPI.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import yu.cohort11.BankAPI.BankApiApplication;
import yu.cohort11.BankAPI.models.Customer;
import yu.cohort11.BankAPI.repositories.CustomerRepository;
import yu.cohort11.BankAPI.services.CustomerService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(BankApiApplication.class);

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;


    @PostMapping("/customers")
    public ResponseEntity<?> addCustomer(@Validated @RequestBody Customer customer){
        logger.info("Successfully ADDED a customer :" + customer.toString());
        customerService.saveCustomer(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping("/customers/{id}")
    public ResponseEntity<Optional<Customer>> updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        logger.info("updating customerer with id :" + id + "to " + customer.toString());
        return new ResponseEntity (this.customerService.updateCustomer(id,customer), HttpStatus.ACCEPTED);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        logger.info("successfully retrieved customer with id :" + id);
        return new ResponseEntity<>(this.customerService.getCustomerById(id), HttpStatus.OK);
    }

    @DeleteMapping("/customers/{id}")
    public  ResponseEntity<?> deleteCustomerById(@PathVariable Long id){
        logger.info("successfully DELETED a customer from list with id: " +id);
        customerService.deleteCustomerById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomer(@RequestParam(required = false) Long id){
        if(id != null){
            return new ResponseEntity<>(customerRepository.findCustomerById(id),HttpStatus.OK);
        }
        logger.info("Successfully retrieved all customers  " );

        return new ResponseEntity<>( customerService.getAllCustomer(),HttpStatus.OK);
    }
}
