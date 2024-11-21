package model.config.fields;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CellAllocationTest {

    private CellAllocation cellAllocation;

    @Before
    public void setUp() {
        cellAllocation = new CellAllocation();
    }

    @Test
    public void testGetSetColumn() {
        cellAllocation.setColumn(5);
        assertEquals(5, cellAllocation.getColumn());
    }

    @Test
    public void testGetSetRow() {
        cellAllocation.setRow(10);
        assertEquals(10, cellAllocation.getRow());
    }

    @Test
    public void testGetSetSymbols() {
        Map<String, Integer> symbols = new HashMap<>();
        symbols.put("symbol1", 2);
        symbols.put("symbol2", 4);

        cellAllocation.setSymbols(symbols);
        assertEquals(symbols, cellAllocation.getSymbols());
    }
}
