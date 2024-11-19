package service.game;

import matching.matcher.SameSymbolMatcher;
import model.config.Config;
import model.config.fields.WinCombination;
import model.game.Board;
import model.matching.Result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardAnalysisService{
    private final Config config;
    Map<String,List<WinCombination>> winCombos; //save winning symbols and win combinations associated with them
    Map<String, Integer> rewardMultipliers;

    public BoardAnalysisService(Config config) {
        this.config = config;
        this.winCombos = new HashMap<>();
    }

    public List<Result> analyzeBoard(Board board) {
        List<Result> results = new ArrayList<>();
        results.addAll(new SameSymbolMatcher(config.getWinCombinations()).match(board.getBoard()));
        for(Result result : results) {
            List<WinCombination> list = winCombos.getOrDefault(result.getSymbol(), new ArrayList<>());
            list.add(config.getWinCombinations().get(result.getWinCombo()));
            winCombos.put(result.getSymbol(), list);
        }
        return results;
    }

    public double computeReward(int bettingAmount) {
        double reward = 0;
        for (Map.Entry<String, List<WinCombination>> entry : winCombos.entrySet()) {
            double res = bettingAmount; //starting with betting amount
            double rewardMultiplier = config.getSymbols().get(entry.getKey()).getRewardMultiplier();
            res = res * rewardMultiplier; //multiply by symbol reward value
            for(WinCombination win : entry.getValue()) {
                res = res * win.getRewardMultiplier(); //multiply by each win combo reward value that applies to this symbol
            }
            reward = reward + res;
        }
        return reward;
    }
}
