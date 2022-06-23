package yu.cohort11.BankAPI.enums;

public enum AccountType {
    SAVINGS("savings"),CHECKING("checking"),CREDIT("credit");

    private String accountType;

    AccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountType() {
        return accountType;
    }
}
