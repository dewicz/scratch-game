import model.config.Config;
import model.config.fields.Symbol;
import model.game.Board;
import model.game.GameResult;
import model.matching.MatchingResult;
import model.params.RunParams;
import service.config.ConfigService;
import service.game.BoardAnalysisService;
import service.game.BoardCreationService;
import service.game.GameResultService;
import util.PrintingHelper;

import java.io.IOException;
import java.util.List;

public class ScratchGame {
    public static void main(String[] args) {
        System.out.println("Welcome to Scratch Game");
        RunParams runParams = new RunParams(args);
        System.out.printf("Betting amount %d%n", runParams.getBettingAmount());
        System.out.printf("Config path %s%n", runParams.getConfigPath());
        ConfigService configService = new ConfigService();
        Config config = null;
        try {
            config = configService.populateConfig(runParams.getConfigPath());
        }
        catch(IOException e) {
            System.err.println(e.getMessage());
        }
        System.out.println(config);
        BoardCreationService boardCreationService = new BoardCreationService(config);
        Board board = boardCreationService.initializeBoard(3,3);
        PrintingHelper.printBoard(board);
        BoardAnalysisService boardAnalysisService = new BoardAnalysisService(config);
        List<MatchingResult> matchingResultList = boardAnalysisService.analyzeBoard(board);
        double reward = boardAnalysisService.computeReward(runParams.getBettingAmount());
        String bonusName = reward == 0 ? "" : boardAnalysisService.findBonus(board);
        reward = boardAnalysisService.addBonus(reward, bonusName);
        System.out.println((int) reward);
        GameResultService gameResultService = new GameResultService();
        GameResult gameResult = gameResultService.createGameResult(board, reward, matchingResultList, bonusName);
        gameResultService.generateOutput(gameResult);
    }
}
