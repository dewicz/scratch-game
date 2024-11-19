package model.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import model.game.Probability;
import model.game.Symbol;
import model.game.WinCombination;

import java.util.Map;

public class Config {
    Integer columns;
    Integer rows;
    @JsonProperty("win_combinations")
    Map<String, WinCombination> winCombinations;
    Map<String, Symbol> symbols;
    Probability probabilities;

    public Integer getColumns() {
        return columns;
    }

    public void setColumns(Integer columns) {
        this.columns = columns;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Map<String, WinCombination> getWinCombinations() {
        return winCombinations;
    }

    public void setWinCombinations(Map<String, WinCombination> winCombinations) {
        this.winCombinations = winCombinations;
    }

    public Map<String, Symbol> getSymbols() {
        return symbols;
    }

    public void setSymbols(Map<String, Symbol> symbols) {
        this.symbols = symbols;
    }

    public Probability getProbabilities() {
        return probabilities;
    }

    public void setProbabilities(Probability probabilities) {
        this.probabilities = probabilities;
    }
}
