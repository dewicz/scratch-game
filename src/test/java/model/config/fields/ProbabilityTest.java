package model.config.fields;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class ProbabilityTest {

    private Probability probability;

    @Before
    public void setUp() {
        CellAllocation standardSymbol1 = new CellAllocation();
        standardSymbol1.setRow(1);
        standardSymbol1.setColumn(1);

        CellAllocation standardSymbol2 = new CellAllocation();
        standardSymbol2.setRow(2);
        standardSymbol2.setColumn(2);

        CellAllocation bonusSymbol = new CellAllocation();
        bonusSymbol.setRow(3);
        bonusSymbol.setColumn(3);

        probability = new Probability();
        probability.setStandardSymbols(Arrays.asList(standardSymbol1, standardSymbol2));
        probability.setBonusSymbols(bonusSymbol);
    }

    @Test
    public void testRetrieveCellAllocationWithValidCoordinates() {
        CellAllocation result = probability.retrieveCellAllocation(1, 1);
        assertEquals(1, result.getRow());
        assertEquals(1, result.getColumn());
    }

    @Test
    public void testRetrieveCellAllocationWithInvalidCoordinates() {
        CellAllocation result = probability.retrieveCellAllocation(10, 10);
        assertEquals(1, result.getRow());  // First symbol's row
        assertEquals(1, result.getColumn());  // First symbol's column
    }

    @Test
    public void testRetrieveCellAllocationWithBonusSymbol() {
        CellAllocation result = probability.getBonusSymbols();
        assertEquals(3, result.getRow());
        assertEquals(3, result.getColumn());
    }

    @Test
    public void testSetStandardSymbols() {
        CellAllocation newStandardSymbol = new CellAllocation();
        newStandardSymbol.setRow(4);
        newStandardSymbol.setColumn(4);

        probability.setStandardSymbols(Arrays.asList(newStandardSymbol));
        CellAllocation result = probability.retrieveCellAllocation(4, 4);
        assertEquals(4, result.getRow());
        assertEquals(4, result.getColumn());
    }

    @Test
    public void testSetBonusSymbols() {
        CellAllocation newBonusSymbol = new CellAllocation();
        newBonusSymbol.setRow(5);
        newBonusSymbol.setColumn(5);

        probability.setBonusSymbols(newBonusSymbol);
        CellAllocation result = probability.getBonusSymbols();
        assertEquals(5, result.getRow());
        assertEquals(5, result.getColumn());
    }
}
