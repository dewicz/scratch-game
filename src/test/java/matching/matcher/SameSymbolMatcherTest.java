package matching.matcher;

import static org.junit.Assert.*;
import model.config.fields.WinCombination;
import model.enums.SymbolGroup;
import model.enums.SymbolOccurrence;
import model.matching.MatchingResult;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class SameSymbolMatcherTest {

    private Map<String, WinCombination> winCombinations;

    @Before
    public void setUp() {
        winCombinations = new HashMap<>();

        winCombinations.put("A", new WinCombination(2.0, SymbolOccurrence.SAME_SYMBOLS, 3, SymbolGroup.SAME_SYMBOLS, new ArrayList<>()));
        winCombinations.put("B", new WinCombination(1.5, SymbolOccurrence.SAME_SYMBOLS, 3, SymbolGroup.SAME_SYMBOLS, new ArrayList<>()));
        winCombinations.put("C", new WinCombination(1, SymbolOccurrence.LINEAR_SYMBOLS, 0, SymbolGroup.HORIZONTALLY_LINEAR_SYMBOLS, new ArrayList<>()));
    }

    @Test
    public void testConstructorFiltersCombinationsBySameSymbols() {
        SameSymbolMatcher matcher = new SameSymbolMatcher(winCombinations);
        assertNotNull(matcher);
    }

    @Test
    public void testMatchReturnsMatchingResults() {
        SameSymbolMatcher matcher = new SameSymbolMatcher(winCombinations);

        String[][] board = {
                {"A", "A", "A"},
                {"B", "B", "F"},
                {"D", "D", "F"}
        };

        List<MatchingResult> results = matcher.match(board);

        assertEquals(1, results.size());

        MatchingResult resultA = results.stream().filter(r -> r.getSymbol().equals("A")).findFirst().orElse(null);
        assertNotNull(resultA);
        assertEquals(1.5, resultA.getRewardMultiplier(), 0.01);
        assertEquals(SymbolGroup.SAME_SYMBOLS, resultA.getGroup());
    }

    @Test
    public void testMatchWithEmptyBoard() {
        SameSymbolMatcher matcher = new SameSymbolMatcher(winCombinations);

        String[][] board = {};
        List<MatchingResult> results = matcher.match(board);
        assertTrue(results.isEmpty());
    }
}
