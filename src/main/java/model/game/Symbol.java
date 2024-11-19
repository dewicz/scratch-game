package model.game;

import com.fasterxml.jackson.annotation.JsonProperty;
import model.enums.ImpactType;
import model.enums.SymbolType;

public class Symbol {

    @JsonProperty("reward_multiplier")
    private int rewardMultiplier;
    private SymbolType type;
    private ImpactType impact;
    private int extra;

    public int getRewardMultiplier() {
        return rewardMultiplier;
    }

    public void setRewardMultiplier(int rewardMultiplier) {
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
