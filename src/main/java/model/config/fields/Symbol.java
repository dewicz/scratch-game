package model.config.fields;

import com.fasterxml.jackson.annotation.JsonProperty;
import model.enums.ImpactType;
import model.enums.SymbolType;

public class Symbol {

    @JsonProperty("reward_multiplier")
    private double rewardMultiplier;
    private SymbolType type;
    private ImpactType impact;
    private int extra;

    public Symbol(double rewardMultiplier, SymbolType type, ImpactType impact, int extra) {
        this.rewardMultiplier = rewardMultiplier;
        this.type = type;
        this.impact = impact;
        this.extra = extra;
    }

    public Symbol() {

    }

    public double getRewardMultiplier() {
        return rewardMultiplier;
    }

    public void setRewardMultiplier(double rewardMultiplier) {
        this.rewardMultiplier = rewardMultiplier;
    }

    public ImpactType getImpact() {
        return impact;
    }

    public void setImpact(ImpactType impact) {
        this.impact = impact;
    }

    public SymbolType getType() {
        return type;
    }

    public void setType(SymbolType type) {
        this.type = type;
    }

    public int getExtra() {
        return extra;
    }

    public void setExtra(int extra) {
        this.extra = extra;
    }
}
