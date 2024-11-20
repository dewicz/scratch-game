package service.game;

import matching.matcher.SameSymbolMatcher;
import model.config.Config;
import model.config.fields.Symbol;
import model.config.fields.WinCombination;
import model.enums.SymbolType;
import model.game.Board;
import model.matching.Result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BoardAnalysisService{
    private final Config config;
    Map<String,List<WinCombination>> winCombos; //save winning symbols and win combinations associated with them

    public BoardAnalysisService(Config config) {
        this.config = config;
        this.winCombos = new HashMap<>();
    }

    public void analyzeBoard(Board board) {
        List<Result> results = new ArrayList<>();
        results.addAll(new SameSymbolMatcher(config.getWinCombinations()).match(board.getBoard()));
        for(Result result : results) {
            List<WinCombination> list = winCombos.getOrDefault(result.getSymbol(), new ArrayList<>());
            list.add(config.getWinCombinations().get(result.getWinCombo()));
            winCombos.put(result.getSymbol(), list);
        }
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

    public double addBonus(double reward, Board board) {
        String[][] b = board.getBoard();
        Symbol bonus = null;
        Map<String,Symbol> bonusSymbols = config.getSymbols().entrySet()
                .stream()
                .filter(s -> s.getValue().getType() == SymbolType.BONUS)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        for(int i=0; i<b.length; i++) {
            for(int j=0; j<b[0].length; j++) {
                if(bonusSymbols.containsKey(b[i][j])) {
                    bonus = bonusSymbols.get(b[i][j]);
                }
            }
        }

        if(bonus == null) {
            System.out.println("No bonus applied");
            return reward;
        }
        switch(bonus.getImpact()) {
            case MULTIPLY_REWARD:
                reward = reward * bonus.getRewardMultiplier();
                break;
            case EXTRA_BONUS:
                reward = reward + bonus.getExtra();
            default:
                break;
        }

        return reward;
    }
}
