package matching.matcher;

import model.config.fields.Location;
import model.config.fields.WinCombination;
import model.enums.SymbolOccurrence;
import model.matching.MatchingResult;
import model.matching.WinDetail;
import util.Constants;

import java.util.*;

public class LinearMatcher {

    private final Map<String, WinDetail> combinations = new HashMap<>();

    public LinearMatcher(Map<String, WinCombination> winCombinations) {
        winCombinations.entrySet().stream()
                .filter(e -> e.getValue().getWhen() == SymbolOccurrence.LINEAR_SYMBOLS)
                .forEach(e -> combinations.put(e.getKey(), new WinDetail(e.getKey(), e.getValue())));
    }

    public List<MatchingResult> match(String[][] matrix) {
        List<MatchingResult> results = new ArrayList<>();
        if(matrix.length == 0) return results;
        combinations.entrySet().stream()
                .forEach(e -> {
                List<String> matches = matchCoveredArea(matrix, e.getValue().getWinCombination().getCoveredAreas());
                if(!matches.isEmpty()) {
                    for(String match : matches) {
                        WinCombination win = e.getValue().getWinCombination();
                        results.add(new MatchingResult(match, win.getRewardMultiplier(), e.getKey(), win.getGroup()));
                    }
                }
        });
        return results;
    }

    private List<String> matchCoveredArea(String[][] matrix, List<List<Location>> coveredArea) {
        List<String> matchedValues = new ArrayList<>();
        String first = Constants.NO_LINEAR_MATCH;
        for(List<Location> list : coveredArea) {
            Location locFirst = list.get(0);
            for(int i=1; i<list.size(); i++) {
                first = matrix[locFirst.getRow()][locFirst.getColumn()];
                Location locNext = list.get(i);
                if(!(matrix[locNext.getRow()][locNext.getColumn()].equals(first))) {
                    first = Constants.NO_LINEAR_MATCH;
                    break;
                }
            }
            if(!(first.equals(Constants.NO_LINEAR_MATCH))) {
                matchedValues.add(first);
            }
        }
        return matchedValues;
    }
}
