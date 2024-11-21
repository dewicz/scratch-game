package model.config.fields;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import model.enums.ImpactType;
import model.enums.SymbolType;

public class SymbolTest {

    private Symbol symbol;

    @Before
    public void setUp() {
        symbol = new Symbol();
        symbol.setRewardMultiplier(2.5);
        symbol.setType(SymbolType.BONUS);
        symbol.setImpact(ImpactType.EXTRA_BONUS);
        symbol.setExtra(10);
    }

    @Test
    public void testGetRewardMultiplier() {
        assertEquals(2.5, symbol.getRewardMultiplier(), 0.01);
    }

    @Test
    public void testSetRewardMultiplier() {
        symbol.setRewardMultiplier(3.0);
        assertEquals(3.0, symbol.getRewardMultiplier(), 0.01);
    }

    @Test
    public void testGetImpact() {
        assertEquals(ImpactType.EXTRA_BONUS, symbol.getImpact());
    }

    @Test
    public void testSetImpact() {
        symbol.setImpact(ImpactType.MULTIPLY_REWARD);
        assertEquals(ImpactType.MULTIPLY_REWARD, symbol.getImpact());
    }

    @Test
    public void testGetType() {
        assertEquals(SymbolType.BONUS, symbol.getType());
    }

    @Test
    public void testSetType() {
        symbol.setType(SymbolType.STANDARD);
        assertEquals(SymbolType.STANDARD, symbol.getType());
    }

    @Test
    public void testGetExtra() {
        assertEquals(10, symbol.getExtra());
    }

    @Test
    public void testSetExtra() {
        symbol.setExtra(20);
        assertEquals(20, symbol.getExtra());
    }

    @Test
    public void testSymbolEquality() {
        Symbol anotherSymbol = new Symbol();
        anotherSymbol.setRewardMultiplier(2.5);
        anotherSymbol.setType(SymbolType.BONUS);
        anotherSymbol.setImpact(ImpactType.EXTRA_BONUS);
        anotherSymbol.setExtra(10);

        assertEquals(symbol.getRewardMultiplier(), anotherSymbol.getRewardMultiplier(), 0.01);
        assertEquals(symbol.getType(), anotherSymbol.getType());
        assertEquals(symbol.getImpact(), anotherSymbol.getImpact());
        assertEquals(symbol.getExtra(), anotherSymbol.getExtra());
    }
}
