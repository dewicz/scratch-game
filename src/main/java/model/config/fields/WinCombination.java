package model.config.fields;

import com.fasterxml.jackson.annotation.JsonProperty;
import model.enums.SymbolGroup;
import model.enums.SymbolOccurrence;

import java.util.List;

public class WinCombination {
    @JsonProperty("reward_multiplier")
    private double rewardMultiplier;
    private SymbolOccurrence when;
    private int count;
    private SymbolGroup group;
    @JsonProperty("covered_areas")
    List<List<Location>> coveredAreas;


    public double getRewardMultiplier() {
        return rewardMultiplier;
    }

    public void setRewardMultiplier(double rewardMultiplier) {
        this.rewardMultiplier = rewardMultiplier;
    }

    public SymbolOccurrence getWhen() {
        return when;
    }

    public void setWhen(SymbolOccurrence when) {
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
