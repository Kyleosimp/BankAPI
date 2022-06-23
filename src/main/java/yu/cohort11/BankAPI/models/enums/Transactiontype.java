package yu.cohort11.BankAPI.models.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Transactiontype {


    @JsonProperty("P2p")
    P2P,

    @JsonProperty("Deposit")
    DEPOSIT,

    @JsonProperty("Withdrawal")
    WITHDRAWAL;

    Transactiontype() {
    }

    private String transactionType;

    Transactiontype(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
}
