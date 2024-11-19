package model.game;

import com.fasterxml.jackson.annotation.JsonProperty;
import model.enums.SymbolGroup;
import model.enums.SymbolOccurence;

import java.util.List;

public class WinCombination {
    @JsonProperty("reward_multiplier")
    private int rewardMultiplier;
    private SymbolOccurence when;
    private int count;
    private SymbolGroup group;
    @JsonProperty("covered_areas")
    List<List<Location>> coveredAreas;


    public int getRewardMultiplier() {
        return rewardMultiplier;
    }

    public void setRewardMultiplier(int rewardMultiplier) {
        this.rewardMultiplier = rewardMultiplier;
    }

    public SymbolOccurence getWhen() {
        return when;
    }

    public void setWhen(SymbolOccurence when) {
        this.when = when;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public SymbolGroup getGroup() {
        return group;
    }

    public void setGroup(SymbolGroup group) {
        this.group = group;
    }

    public List<List<Location>> getCoveredAreas() {
        return coveredAreas;
    }

    public void setCoveredAreas(List<List<Location>> coveredAreas) {
        this.coveredAreas = coveredAreas;
    }
}
