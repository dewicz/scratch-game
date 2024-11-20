package model.game;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class GameResult {
    private String[][] matrix;
    //i decided to use double despite the output file example using integer - since we have decimal multipliers, it's possible that the result will be decimal
    private Double reward;
    @JsonProperty("applied_winning_combinations")
    private Map<String, List<String>> winningCombinations;
    @JsonProperty("applied_bonus_symbol")
    private String bonusSymbol;


    public GameResult(String[][] matrix, Double reward, Map<String, List<String>> winningCombinations, String bonusSymbol) {
        this.matrix = matrix;
        this.reward = reward;
        this.winningCombinations = winningCombinations;
        this.bonusSymbol = bonusSymbol;
    }

    public String[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(String[][] board) {
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
