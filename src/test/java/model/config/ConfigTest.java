package model.config;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import model.config.fields.Probability;
import model.config.fields.Symbol;
import model.config.fields.WinCombination;

import java.util.HashMap;
import java.util.Map;

public class ConfigTest {

    private Config config;

    @Before
    public void setUp() {
        config = new Config();
    }

    @Test
    public void testGetSetColumns() {
        config.setColumns(5);
        assertEquals((Integer) 5, config.getColumns());
    }

    @Test
    public void testGetSetRows() {
        config.setRows(10);
        assertEquals((Integer) 10, config.getRows());
    }

    @Test
    public void testGetSetWinCombinations() {
        Map<String, WinCombination> winCombinations = new HashMap<>();
        WinCombination winCombo = new WinCombination();
        winCombinations.put("combo1", winCombo);

        config.setWinCombinations(winCombinations);
        assertEquals(winCombinations, config.getWinCombinations());
    }

    @Test
    public void testGetSetSymbols() {
        Map<String, Symbol> symbols = new HashMap<>();
        Symbol symbol = new Symbol();
        symbols.put("symbol1", symbol);

        config.setSymbols(symbols);
        assertEquals(symbols, config.getSymbols());
    }

    @Test
    public void testGetSetProbabilities() {
        Probability probability = new Probability();
        config.setProbabilities(probability);
        assertEquals(probability, config.getProbabilities());
    }

    @Test
    public void testJsonPropertyAnnotation() {
        Map<String, WinCombination> expectedWinCombinations = new HashMap<>();
        WinCombination winCombo = new WinCombination();
        expectedWinCombinations.put("combo1", winCombo);

        config.setWinCombinations(expectedWinCombinations);
        assertEquals(expectedWinCombinations, config.getWinCombinations());
    }

}
