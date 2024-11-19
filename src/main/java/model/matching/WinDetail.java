package model.matching;

import model.config.fields.WinCombination;

public class WinDetail {
    private String description;
    private WinCombination winCombination;

    public WinDetail(String description, WinCombination winCombination) {
        this.description = description;
        this.winCombination = winCombination;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public WinCombination getWinCombination() {
        return winCombination;
    }

    public void setWinCombination(WinCombination winCombination) {
        this.winCombination = winCombination;
    }
}
