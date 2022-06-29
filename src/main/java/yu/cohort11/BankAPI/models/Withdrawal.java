package yu.cohort11.BankAPI.models;

import yu.cohort11.BankAPI.models.enums.Medium;
import yu.cohort11.BankAPI.models.enums.Status;
import yu.cohort11.BankAPI.models.enums.Transactiontype;

import javax.persistence.*;

@Entity
public class Withdrawal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private Transactiontype type;
    private String transactionDate;
    private Status status;
    private Medium medium;
    private Double amount;
    private String description;
    private Double tmp_account_balance;


    @ManyToOne(cascade = CascadeType.ALL)
    private Account account;

    public Withdrawal(){

    }


    public Withdrawal(Long id, Transactiontype type, String transactionDate, Status status, Medium medium, Double amount, String description, Double tmp_account_balance, Account account) {
        this.id = id;
        this.type = type;
        this.transactionDate = transactionDate;
        this.status = status;
        this.medium = medium;
        this.amount = amount;
        this.description = description;
        this.tmp_account_balance = tmp_account_balance;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Transactiontype getType() {
        return type;
    }

    public void setType(Transactiontype type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public Medium getMedium() {
        return medium;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Double getTmp_account_balance() {
        return tmp_account_balance;
    }

    public void setTmp_account_balance(Double tmp_account_balance) {
        this.tmp_account_balance = tmp_account_balance;
    }

    @Override
    public String toString() {
        return "Withdrawal{" +
                "id=" + id +
                ", type=" + type +
                ", transactionDate='" + transactionDate + '\'' +
                ", status=" + status +
                ", medium=" + medium +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", account=" + account +
                '}';
    }
}
