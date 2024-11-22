package matching.matcher;

import model.config.fields.Location;
import model.config.fields.WinCombination;
import model.enums.SymbolGroup;
import model.enums.SymbolOccurrence;
import model.matching.MatchingResult;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class LinearMatcherTest {
    private Map<String, WinCombination> winCombinations;

    @Before
    public void setUp() {
        winCombinations = new HashMap<>();

        winCombinations.put("A", new WinCombination(2.0, SymbolOccurrence.LINEAR_SYMBOLS, 0, SymbolGroup.LTR_DIAGONALLY_LINEAR_SYMBOLS, List.of(List.of(new Location("0:0"), new Location("1:1"), new Location("2:2")))));
        winCombinations.put("B", new WinCombination(1.5, SymbolOccurrence.SAME_SYMBOLS, 3, SymbolGroup.SAME_SYMBOLS, new ArrayList<>()));
        winCombinations.put("C", new WinCombination(1, SymbolOccurrence.SAME_SYMBOLS, 0, SymbolGroup.SAME_SYMBOLS, new ArrayList<>()));
    }

    @Test
    public void testConstructorFiltersCombinationsBySameSymbols() {
        SameSymbolMatcher matcher = new SameSymbolMatcher(winCombinations);
        assertNotNull(matcher);
    }

    @Test
    public void testMatchReturnsMatchingResults() {
        LinearMatcher matcher = new LinearMatcher(winCombinations);

        String[][] board = {
                {"A", "B", "E"},
                {"B", "A", "F"},
                {"D", "D", "A"}
        };

        List<MatchingResult> results = matcher.match(board);

        assertEquals(1, results.size());

        MatchingResult resultA = results.stream().filter(r -> r.getSymbol().equals("A")).findFirst().orElse(null);
        assertNotNull(resultA);
        assertEquals(2.0, resultA.getRewardMultiplier(), 0.01);
        assertEquals(SymbolGroup.LTR_DIAGONALLY_LINEAR_SYMBOLS, resultA.getGroup());
    }

    @Test
    public void testMatchWithEmptyBoard() {
        LinearMatcher matcher = new LinearMatcher(winCombinations);

        String[][] board = {};
        List<MatchingResult> results = matcher.match(board);
        assertTrue(results.isEmpty());
    }
}