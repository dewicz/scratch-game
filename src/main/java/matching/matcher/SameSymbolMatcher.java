package matching.matcher;

import model.config.fields.WinCombination;
import model.enums.SymbolOccurrence;
import model.matching.Result;
import model.matching.WinDetail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class SameSymbolMatcher {

    private final Map<Integer, WinDetail> combinations = new HashMap<>();
    private final Map<String, Integer> symbols = new HashMap<>();


    public SameSymbolMatcher(Map<String, WinCombination> winCombinations) {
        winCombinations.entrySet().stream()
                .filter(e -> e.getValue().getWhen() == SymbolOccurrence.SAME_SYMBOLS)
                .forEach(e -> combinations.put(e.getValue().getCount(), new WinDetail(e.getKey(), e.getValue())));
    }

    public List<Result> match(String[][] board) {
        for(String[] row : board) {
            for(String symbol : row) {
                symbols.put(symbol, symbols.getOrDefault(symbol, 0) + 1);
            }
        }

        List<Result> results = new ArrayList<>();
        for (Map.Entry<String, Integer> e : symbols.entrySet()) {
            WinDetail winDetail = combinations.get(e.getValue());
            if (winDetail != null) {
                Result res = new Result(
                        e.getKey(),
                        winDetail.getWinCombination().getRewardMultiplier(),
                        winDetail.getDescription(),
                        winDetail.getWinCombination().getGroup()
                );
                results.add(res);
            }
        }
        return results;
    }
}
