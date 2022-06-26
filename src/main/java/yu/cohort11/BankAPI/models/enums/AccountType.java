package yu.cohort11.BankAPI.models.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum AccountType {

    @JsonProperty("Checking")
    CHECKING,

    @JsonProperty("Savings")
    SAVINGS,

    @JsonProperty("Credit")
    CREDIT;

    private String accountType;

    AccountType(){

    }

    AccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountType() {
        return accountType;
    }
}
