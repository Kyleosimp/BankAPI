package yu.cohort11.BankAPI.services;

import yu.cohort11.BankAPI.exception.ResourceNotFoundException;
import yu.cohort11.BankAPI.models.Account;
import yu.cohort11.BankAPI.repositories.AccountRepository;

import java.util.ArrayList;
import java.util.List;

public class AccountService {
    private AccountRepository accountRepository;
    private CustomerService customerService;

    protected void verifyId(Long id) throws ResourceNotFoundException {
        if (!accountRepository.existsById(id)) {
            throw new ResourceNotFoundException("Account with id " + id + " not found");
        }
    }

    public List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        accountRepository.findAll().forEach(accounts::add);
        return accounts;
    }

    public Account getAccountById(Long id) {
        verifyId(id);
        Account tmpAccount = null;
        for(Account account:getAllAccounts()){
            if(account.getId().equals(id)){
                tmpAccount = account;
            }
        }
        return tmpAccount;
    }

    public List<Account> getAllAccountsByCustomerId(Long id) {
        customerService.verifyId(id);
        List<Account> accounts = new ArrayList<>();
        for(Account account:getAllAccounts()){
            if(account.getCustomer().getId().equals(id)){
                accounts.add(account);
            }
        }
        return accounts;
    }

    public void createAccount(Account account,Long customerId) {
        customerService.verifyId(customerId);
        account.setCustomer(customerService.getCustomerById(customerId));
        accountRepository.save(account);
    }

    public void updateAccount(Account account,Long accountId) {
        verifyId(accountId);
        for(Account a:getAllAccounts()){
            if(a.getId().equals(accountId)){
                accountRepository.save(account);
            }
        }
    }

    public void deleteAccount(Long accountId) {
        verifyId(accountId);
        for(Account account:getAllAccounts()){
            if(account.getId().equals(accountId)){
                accountRepository.delete(account);
            }
        }
    }
}
