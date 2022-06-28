package yu.cohort11.BankAPI.models.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum LoanStatus {
    @JsonProperty("Approved")
    APPROVED,
    @JsonProperty("Denied")
    DENIED;

    private String LoanStatus;

    LoanStatus(){
    }

    LoanStatus(String loanStatus) {
        LoanStatus = loanStatus;
    }

    public String getLoanStatus() {
        return LoanStatus;
    }

    public void setLoanStatus(String loanStatus) {
        LoanStatus = loanStatus;
    }
}
