package model.config.fields;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import model.enums.SymbolGroup;
import model.enums.SymbolOccurrence;
import java.util.ArrayList;
import java.util.List;

public class WinCombinationTest {

    private WinCombination winCombination;

    @Before
    public void setUp() {
        winCombination = new WinCombination();
        winCombination.setRewardMultiplier(3.5);
        winCombination.setWhen(SymbolOccurrence.SAME_SYMBOLS);
        winCombination.setCount(5);
        winCombination.setGroup(SymbolGroup.SAME_SYMBOLS);

        // Create some sample covered areas with Location
        List<Location> row1 = new ArrayList<>();
        row1.add(new Location("0:0"));
        row1.add(new Location("0:1"));

        List<Location> row2 = new ArrayList<>();
        row2.add(new Location("1:0"));
        row2.add(new Location("1:1"));

        List<List<Location>> coveredAreas = new ArrayList<>();
        coveredAreas.add(row1);
        coveredAreas.add(row2);

        winCombination.setCoveredAreas(coveredAreas);
    }

    @Test
    public void testGetRewardMultiplier() {
        assertEquals(3.5, winCombination.getRewardMultiplier(), 0.01);
    }

    @Test
    public void testSetRewardMultiplier() {
        winCombination.setRewardMultiplier(4.0);
        assertEquals(4.0, winCombination.getRewardMultiplier(), 0.01);
    }

    @Test
    public void testGetWhen() {
        assertEquals(SymbolOccurrence.SAME_SYMBOLS, winCombination.getWhen());
    }

    @Test
    public void testSetWhen() {
        winCombination.setWhen(SymbolOccurrence.LINEAR_SYMBOLS);
        assertEquals(SymbolOccurrence.LINEAR_SYMBOLS, winCombination.getWhen());
    }

    @Test
    public void testGetCount() {
        assertEquals(5, winCombination.getCount());
    }

    @Test
    public void testSetCount() {
        winCombination.setCount(6);
        assertEquals(6, winCombination.getCount());
    }

    @Test
    public void testGetGroup() {
        assertEquals(SymbolGroup.SAME_SYMBOLS, winCombination.getGroup());
    }

    @Test
    public void testSetGroup() {
        winCombination.setGroup(SymbolGroup.HORIZONTALLY_LINEAR_SYMBOLS);
        assertEquals(SymbolGroup.HORIZONTALLY_LINEAR_SYMBOLS, winCombination.getGroup());
    }

    @Test
    public void testGetCoveredAreas() {
        List<List<Location>> coveredAreas = winCombination.getCoveredAreas();
        assertNotNull(coveredAreas);
        assertEquals(2, coveredAreas.size());
        assertEquals(2, coveredAreas.get(0).size());
    }

    @Test
    public void testSetCoveredAreas() {
        List<List<Location>> newCoveredAreas = new ArrayList<>();
        List<Location> newRow = new ArrayList<>();
        newRow.add(new Location("2:2"));
        newCoveredAreas.add(newRow);

        winCombination.setCoveredAreas(newCoveredAreas);
        assertEquals(newCoveredAreas, winCombination.getCoveredAreas());
    }

    @Test
    public void testWinCombinationEquality() {
        WinCombination anotherWinCombination = new WinCombination();
        anotherWinCombination.setRewardMultiplier(3.5);
        anotherWinCombination.setWhen(SymbolOccurrence.SAME_SYMBOLS);
        anotherWinCombination.setCount(5);
        anotherWinCombination.setGroup(SymbolGroup.SAME_SYMBOLS);

        List<Location> row1 = new ArrayList<>();
        row1.add(new Location("0:0"));
        row1.add(new Location("0:1"));

        List<Location> row2 = new ArrayList<>();
        row2.add(new Location("1:0"));
        row2.add(new Location("1:1"));

        List<List<Location>> coveredAreas = new ArrayList<>();
        coveredAreas.add(row1);
        coveredAreas.add(row2);

        anotherWinCombination.setCoveredAreas(coveredAreas);

        assertEquals(winCombination.getRewardMultiplier(), anotherWinCombination.getRewardMultiplier(), 0.01);
        assertEquals(winCombination.getWhen(), anotherWinCombination.getWhen());
        assertEquals(winCombination.getCount(), anotherWinCombination.getCount());
        assertEquals(winCombination.getGroup(), anotherWinCombination.getGroup());
    }
}
