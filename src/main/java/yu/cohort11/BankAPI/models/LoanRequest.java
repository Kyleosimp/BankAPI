package yu.cohort11.BankAPI.models;

import yu.cohort11.BankAPI.models.enums.LoanStatus;

import javax.persistence.*;

@Entity
public class LoanRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    private LoanStatus loanStatus;

    public LoanRequest() {
    }

    public LoanRequest(Long id, Account account, LoanStatus loanStatus) {
        this.id = id;
        this.account = account;
        this.loanStatus = loanStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public LoanStatus getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(LoanStatus loanStatus) {
        this.loanStatus = loanStatus;
    }
}
