package service.game;

import static org.junit.Assert.*;

import model.config.Config;
import model.config.fields.Symbol;
import model.config.fields.WinCombination;
import model.enums.ImpactType;
import model.enums.SymbolGroup;
import model.enums.SymbolOccurrence;
import model.enums.SymbolType;
import model.game.Matrix;
import model.matching.MatchingResult;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.mockito.Mockito.*;

public class MatrixAnalysisServiceTest {

    private Config mockConfig;
    private MatrixAnalysisService matrixAnalysisService;

    @Before
    public void setUp() {
        mockConfig = mock(Config.class);

        Map<String, Symbol> symbols = new HashMap<>();
        symbols.put("A", new Symbol(2.0, SymbolType.STANDARD, null, 0));
        symbols.put("MISS", new Symbol(1.0, SymbolType.BONUS, ImpactType.MISS, 0));
        symbols.put("5x", new Symbol(5.0, SymbolType.BONUS, ImpactType.MULTIPLY_REWARD, 0));


        when(mockConfig.getSymbols()).thenReturn(symbols);

        Map<String, WinCombination> winCombinations = new HashMap<>();
        WinCombination winA = new WinCombination();
        winA.setCount(3);
        winA.setGroup(SymbolGroup.SAME_SYMBOLS);
        winA.setRewardMultiplier(1.0);
        winA.setWhen(SymbolOccurrence.SAME_SYMBOLS);
        winCombinations.put("A", winA);

        when(mockConfig.getWinCombinations()).thenReturn(winCombinations);

        matrixAnalysisService = new MatrixAnalysisService(mockConfig);
    }

    @Test
    public void testAnalyzeBoard() {
        String[][] matrixArray = {
                {"A", "C", "D"},
                {"B", "A", "A"},
                {"BONUS", "C", "D"}
        };
        Matrix matrix = new Matrix(3, 3);
        matrix.setMatrix(matrixArray);

        List<MatchingResult> results = matrixAnalysisService.analyzeBoard(matrix);

        assertNotNull(results);
        assertEquals(1, results.size());
        assertEquals("A", results.get(0).getSymbol());
    }

    @Test
    public void testFindBonus() {
        String[][] matrixArray = {
                {"A", "B", "MISS"},
                {"D", "E", "F"},
                {"G", "H", "I"}
        };
        Matrix matrix = new Matrix(3,3);
        matrix.setMatrix(matrixArray);

        String bonus = matrixAnalysisService.findBonus(matrix);

        assertEquals("MISS", bonus);
    }

    @Test
    public void testAddBonus_MultiplyReward() {
        double reward = matrixAnalysisService.addBonus(100, "5x");
        assertEquals(500, reward, 0.01);
    }

    @Test
    public void testAddBonus_NoBonusApplied() {
        double reward = matrixAnalysisService.addBonus(100, "MISS");
        assertEquals(100.0, reward, 0.01);
    }
}
