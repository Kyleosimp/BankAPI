package yu.cohort11.BankAPI.models.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Medium {

    @JsonProperty("Balance")
    BALANCE,

    @JsonProperty("Rewards")
    REWARDS;

  private String Medium;

    Medium() {
    }

    Medium(String medium) {
        Medium = medium;
    }

    public String getMedium() {
        return Medium;
    }

    public void setMedium(String medium) {
        Medium = medium;
    }
}
