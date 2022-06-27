package yu.cohort11.BankAPI.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import yu.cohort11.BankAPI.models.enums.Medium;
import yu.cohort11.BankAPI.models.enums.Status;
import yu.cohort11.BankAPI.models.enums.Transactiontype;


import javax.persistence.*;

@Entity
public class Deposits {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private Transactiontype type;

private String transaction_date;

private Status status;

private Long payee_id;

private Medium medium;

private Double amount;

private String description;

@ManyToOne(cascade = CascadeType.ALL)
private Account account;

    public Deposits() {
    }

    public Deposits(Long id, Transactiontype type, String transaction_date, Status status, Long payee_id, Medium medium, Double amount, String description, Account account) {
        this.id = id;
        this.type = type;
        this.transaction_date = transaction_date;
        this.status = status;
        this.payee_id = payee_id;
        this.medium = medium;
        this.amount = amount;
        this.description = description;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Transactiontype getType() {
        return type;
    }

    public void setType(Transactiontype type) {
        this.type = type;
    }

    public String getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getPayee_id() {
        return payee_id;
    }

    public void setPayee_id(Long payee_id) {
        this.payee_id = payee_id;
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

    @Override
    public String toString() {
        return "Deposits{" +
                "id=" + id +
                ", type=" + type +
                ", transaction_date='" + transaction_date + '\'' +
                ", status=" + status +
                ", payee_id=" + payee_id +
                ", medium=" + medium +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", account=" + account +
                '}';
    }
}
