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

public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(BankApiApplication.class);

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;


    @PostMapping("/Customers")
    public ResponseEntity<?> addCustomer(@Validated @RequestBody Customer customer){
        logger.info("Successfully ADDED an order with name :" + customer);
        customerService.saveCustomer(customer);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPollUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(customer.getId()).toUri();
        responseHeaders.setLocation(newPollUri);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }


    @PutMapping("/customer/{id}")
    public ResponseEntity<Optional<Customer>> updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        logger.info("updating customer order with id :" + id);
        return new ResponseEntity (this.customerService.updateCustomer(id,customer), HttpStatus.ACCEPTED);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        logger.info("successfully retrieved order with id :" + id);
        return new ResponseEntity<>(this.customerService.getCustomerById(id), HttpStatus.OK);
    }

    @DeleteMapping("/customers/{id}")
    public  ResponseEntity<?> deleteCustomerById(@PathVariable Long id){
        logger.info("successfully DELETED an order from list with id: " +id);
        customerService.deleteCustomerById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomer(@RequestParam(required = false) Long id){
        if(id != null){
            return new ResponseEntity<>(customerRepository.findCustomerById(id),HttpStatus.OK);
        }
        logger.info("Successfully retrieved all customer order " );

        return new ResponseEntity<>( customerService.getAllCustomer(),HttpStatus.OK);
    }
}
