package model.matching;

import model.enums.SymbolGroup;

public class Result {
    private String symbol;
    private Double rewardMultiplier;
    private String winCombo;
    private SymbolGroup group;

    public Result(String symbol, Double rewardMultiplier, String winCombo, SymbolGroup group) {
        this.symbol = symbol;
        this.rewardMultiplier = rewardMultiplier;
        this.winCombo = winCombo;
        this.group = group;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getWinCombo() {
        return winCombo;
    }

    public void setWinCombo(String winCombo) {
        this.winCombo = winCombo;
    }

    public SymbolGroup getGroup() {
        return group;
    }

    public void setGroup(SymbolGroup group) {
        this.group = group;
    }

    public Double getRewardMultiplier() {
        return rewardMultiplier;
    }

    public void setRewardMultiplier(Double rewardMultiplier) {
        this.rewardMultiplier = rewardMultiplier;
    }
}
