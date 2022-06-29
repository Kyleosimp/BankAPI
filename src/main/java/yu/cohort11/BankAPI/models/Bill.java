package yu.cohort11.BankAPI.models;

import javax.persistence.*;

@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String status;
    private String payee;
    private String nickname;
    private String creation_date;
    private String payment_date;
    private Integer recurring_date;
    private String upcoming_payment_date;
    private Double payment_amount;
    private Double tmp_account_balance;

    @ManyToOne(cascade = CascadeType.ALL)
    private Account account;

    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;


    public Bill() {
    }

//    public Bill(Long id, String status, String payee, String nickname, String creation_date, String payment_date, Integer recurring_date, String upcoming_payment_date, Double payment_amount, String account_id) {
//        this.id = id;
//        this.status = status;
//        this.payee = payee;
//        this.nickname = nickname;
//        this.creation_date = creation_date;
//        this.payment_date = payment_date;
//        this.recurring_date = recurring_date;
//        this.upcoming_payment_date = upcoming_payment_date;
//        this.payment_amount = payment_amount;
//        this.account_id = account_id;
//    }


    public Bill(Long id, String status, String payee, String nickname, String creation_date, String payment_date, Integer recurring_date, String upcoming_payment_date, Double payment_amount, Double tmp_account_balance, Account account, Customer customer) {
        this.id = id;
        this.status = status;
        this.payee = payee;
        this.nickname = nickname;
        this.creation_date = creation_date;
        this.payment_date = payment_date;
        this.recurring_date = recurring_date;
        this.upcoming_payment_date = upcoming_payment_date;
        this.payment_amount = payment_amount;
        this.tmp_account_balance = tmp_account_balance;
        this.account = account;
        this.customer = customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }

    public Integer getRecurring_date() {
        return recurring_date;
    }

    public void setRecurring_date(Integer recurring_date) {
        this.recurring_date = recurring_date;
    }

    public String getUpcoming_payment_date() {
        return upcoming_payment_date;
    }

    public void setUpcoming_payment_date(String upcoming_payment_date) {
        this.upcoming_payment_date = upcoming_payment_date;
    }

    public Double getPayment_amount() {
        return payment_amount;
    }

    public void setPayment_amount(Double payment_amount) {
        this.payment_amount = payment_amount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    //    public String getAccount_id() {
//        return account_id;
//    }
//
//    public void setAccount_id(String account_id) {
//        this.account_id = account_id;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Double getTmp_account_balance() {
        return tmp_account_balance;
    }

    public void setTmp_account_balance(Double tmp_account_balance) {
        this.tmp_account_balance = tmp_account_balance;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", payee='" + payee + '\'' +
                ", nickname='" + nickname + '\'' +
                ", creation_date='" + creation_date + '\'' +
                ", payment_date='" + payment_date + '\'' +
                ", recurring_date=" + recurring_date +
                ", upcoming_payment_date='" + upcoming_payment_date + '\'' +
                ", payment_amount=" + payment_amount +
                ", account=" + account +
                ", customer=" + customer +
                '}';
    }
}