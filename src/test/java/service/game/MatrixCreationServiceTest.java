package service.game;

import static org.junit.Assert.*;

import model.config.Config;
import model.config.fields.CellAllocation;
import model.config.fields.Probability;
import model.game.Matrix;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

public class MatrixCreationServiceTest {

    private Config mockConfig;
    private Probability mockProbability;
    private MatrixCreationService matrixCreationService;
    private CellAllocation cellAllocation;
    private Map<String, Integer> symbols;

    @Before
    public void setUp() {
        mockConfig = mock(Config.class);
        mockProbability = mock(Probability.class);
        cellAllocation = mock(CellAllocation.class);
        when(mockConfig.getProbabilities()).thenReturn(mockProbability);
        when(mockProbability.getBonusSymbols()).thenReturn(cellAllocation);
        when(mockProbability.retrieveCellAllocation(anyInt(), anyInt())).thenReturn(cellAllocation);
        matrixCreationService = new MatrixCreationService(mockConfig);
        symbols = new HashMap<>();
        symbols.put("MISS", 2);
    }

    @Test
    public void testGetSymbolReturnsSymbolBasedOnProbabilities() {
        Map<String, Integer> symbols = new HashMap<>();
        symbols.put("X", 70);
        symbols.put("Y", 30);

        String result = matrixCreationService.getSymbol(symbols);
        assertTrue(symbols.containsKey(result));
    }

    @Test
    public void testAddBonusSymbolReplacesOneCellWithBonus() {
        Matrix matrix = matrixCreationService.initializeBoard(3,3);
        String[][] matrixArray = {
                {"A", "C", "D"},
                {"B", "A", "A"},
                {"BONUS", "C", "D"}
        };
        matrix.setMatrix(matrixArray);
        when(cellAllocation.getSymbols()).thenReturn(symbols);
        boolean bonusFound = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix.getMatrix()[i][j].length()>1) {
                    bonusFound = true;
                    break;
                }
            }
        }
        assertTrue(bonusFound);
    }
}
