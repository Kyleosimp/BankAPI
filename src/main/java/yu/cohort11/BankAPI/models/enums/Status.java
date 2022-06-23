package yu.cohort11.BankAPI.models.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Status {
    @JsonProperty("Pending")
    PENDING,

    @JsonProperty("Cancelled")
    CANCELLED,

    @JsonProperty("Completed")
    COMPLETED;

  private String status;

    Status() {
    }

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
