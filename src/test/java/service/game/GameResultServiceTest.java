package service.game;

import model.enums.SymbolGroup;
import model.game.Matrix;
import model.game.GameResult;
import model.matching.MatchingResult;
import org.junit.*;

import java.util.*;

public class GameResultServiceTest {

    private GameResultService gameResultService;

    @Before
    public void setUp() {
        gameResultService = new GameResultService();
    }

    @Test
    public void testCreateGameResult() {
        Matrix matrix = new Matrix(3,3);
        matrix.setMatrix(new String[][]{
                {"A", "A", "A"},
                {"D", "E", "MISS"},
                {"G", "H", "I"}
        });
        Double reward = 1000.0;
        List<MatchingResult> matchingResults = Arrays.asList(
                new MatchingResult("A", 1.0, "A win", SymbolGroup.SAME_SYMBOLS)
        );
        String bonus = "MISS";

        GameResult result = gameResultService.createGameResult(matrix, reward, matchingResults, bonus);

        Assert.assertEquals(bonus, result.getBonusSymbol());
        Assert.assertEquals(reward, result.getReward());
    }
}
