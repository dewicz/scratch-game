package model.game;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Probability {
    @JsonProperty("standard_symbols")
    List<CellAllocation> standardSymbols;
    @JsonProperty("bonus_symbols")
    CellAllocation bonusSymbols;

    public List<CellAllocation> getStandardSymbols() {
        return standardSymbols;
    }

    public void setStandardSymbols(List<CellAllocation> standardSymbols) {
        this.standardSymbols = standardSymbols;
    }

    public CellAllocation getBonusSymbols() {
        return bonusSymbols;
    }

    public void setBonusSymbols(CellAllocation bonusSymbols) {
        this.bonusSymbols = bonusSymbols;
    }
}
