package model.game;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class GameResult {
    private List<List<String>> matrix;
    private Double reward;
    @JsonProperty("applied_winning_combinations")
    private Map<String, List<String>> winningCombinations;
    @JsonProperty("applied_bonus_symbol")
    private String bonusSymbol;


    public GameResult(List<List<String>> board, Double reward, Map<String, List<String>> winningCombinations, String bonusSymbol) {
        this.matrix = board;
        this.reward = reward;
        this.winningCombinations = winningCombinations;
        this.bonusSymbol = bonusSymbol;
    }

    public List<List<String>> getMatrix() {
        return matrix;
    }

    public void setMatrix(List<List<String>> board) {
        this.matrix = board;
    }

    public Double getReward() {
        return reward;
    }

    public void setReward(Double reward) {
        this.reward = reward;
    }

    public Map<String, List<String>> getWinningCombinations() {
        return winningCombinations;
    }

    public void setWinningCombinations(Map<String, List<String>> winningCombinations) {
        this.winningCombinations = winningCombinations;
    }

    public String getBonusSymbol() {
        return bonusSymbol;
    }

    public void setBonusSymbol(String bonusSymbol) {
        this.bonusSymbol = bonusSymbol;
    }
}
