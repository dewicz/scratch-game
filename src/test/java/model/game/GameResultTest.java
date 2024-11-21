package model.game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class GameResultTest {

    private GameResult gameResult;

    @Before
    public void setUp() {
        String[][] matrix = {{"X", "O", "X"}, {"O", "X", "O"}, {"X", "X", "O"}};
        Double reward = 100.50;
        Map<String, List<String>> winningCombinations = new HashMap<>();
        winningCombinations.put("combination1", List.of("0:0", "1:1", "2:2"));
        String bonusSymbol = "Star";

        gameResult = new GameResult(matrix, reward, winningCombinations, bonusSymbol);
    }

    @Test
    public void testGetMatrix() {
        String[][] matrix = gameResult.getMatrix();
        assertNotNull(matrix);
        assertEquals(3, matrix.length);
        assertEquals(3, matrix[0].length);
        assertEquals("X", matrix[0][0]);
    }

    @Test
    public void testSetMatrix() {
        String[][] newMatrix = {{"O", "X", "O"}, {"X", "O", "X"}, {"O", "X", "X"}};
        gameResult.setMatrix(newMatrix);
        assertEquals("O", gameResult.getMatrix()[0][0]);
        assertEquals("X", gameResult.getMatrix()[2][2]);
    }

    @Test
    public void testGetReward() {
        assertEquals(100.50, gameResult.getReward(), 0.01);
    }

    @Test
    public void testSetReward() {
        gameResult.setReward(200.75);
        assertEquals(200.75, gameResult.getReward(), 0.01);
    }

    @Test
    public void testGetWinningCombinations() {
        Map<String, List<String>> winningCombinations = gameResult.getWinningCombinations();
        assertNotNull(winningCombinations);
        assertTrue(winningCombinations.containsKey("combination1"));
        assertEquals(3, winningCombinations.get("combination1").size());
        assertEquals("0:0", winningCombinations.get("combination1").get(0));
    }

    @Test
    public void testSetWinningCombinations() {
        Map<String, List<String>> newWinningCombinations = new HashMap<>();
        newWinningCombinations.put("combination2", List.of("1:0", "1:1", "1:2"));
        gameResult.setWinningCombinations(newWinningCombinations);

        assertTrue(gameResult.getWinningCombinations().containsKey("combination2"));
        assertEquals("1:0", gameResult.getWinningCombinations().get("combination2").get(0));
    }

    @Test
    public void testGetBonusSymbol() {
        assertEquals("Star", gameResult.getBonusSymbol());
    }

    @Test
    public void testSetBonusSymbol() {
        gameResult.setBonusSymbol("Diamond");
        assertEquals("Diamond", gameResult.getBonusSymbol());
    }

    @Test
    public void testGameResultEquality() {
        String[][] matrix = {{"X", "X", "X"}, {"O", "O", "O"}, {"X", "O", "X"}};
        Map<String, List<String>> winningCombinations = new HashMap<>();
        winningCombinations.put("combination1", List.of("0:0", "1:1", "2:2"));
        GameResult anotherGameResult = new GameResult(matrix, 150.75, winningCombinations, "Diamond");

        assertEquals(150.75, anotherGameResult.getReward(), 0.01);
        assertEquals("Diamond", anotherGameResult.getBonusSymbol());
        assertEquals("X", anotherGameResult.getMatrix()[0][0]);
    }
}
