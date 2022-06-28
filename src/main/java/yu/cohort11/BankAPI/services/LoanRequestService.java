package yu.cohort11.BankAPI.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yu.cohort11.BankAPI.models.Account;
import yu.cohort11.BankAPI.models.LoanRequest;
import yu.cohort11.BankAPI.repositories.LoanRequestRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanRequestService {

        @Autowired
        private LoanRequestRepository loanRequestRepository;
        @Autowired
        private AccountService accountService;

        public void createLoanRequest(LoanRequest loanRequest, Long accountId) {
            loanRequest.setAccount(accountService.getAccountById(accountId));
            loanRequestRepository.save(loanRequest);

        }

        public List<LoanRequest> getAllLoanRequest() {
            List<LoanRequest> loanRequests = new ArrayList<>();
            loanRequestRepository.findAll().forEach(loanRequests::add);
            return loanRequests;
        }

//        public LoanRequest findLoanRequestById(Long id) {
//            return loanRequestRepository.findById(id).get();
//        }
    }
