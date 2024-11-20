package matching.matcher;

import model.config.fields.WinCombination;
import model.enums.SymbolOccurrence;
import model.matching.MatchingResult;
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

    public List<MatchingResult> match(String[][] board) {
        for(String[] row : board) {
            for(String symbol : row) {
                symbols.put(symbol, symbols.getOrDefault(symbol, 0) + 1);
            }
        }

        List<MatchingResult> matchingResults = new ArrayList<>();
        for (Map.Entry<String, Integer> e : symbols.entrySet()) {
            WinDetail winDetail = combinations.get(e.getValue());
            if (winDetail != null) {
                MatchingResult res = new MatchingResult(
                        e.getKey(),
                        winDetail.getWinCombination().getRewardMultiplier(),
                        winDetail.getDescription(),
                        winDetail.getWinCombination().getGroup()
                );
                matchingResults.add(res);
            }
        }
        return matchingResults;
    }
}
