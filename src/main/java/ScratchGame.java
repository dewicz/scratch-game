import model.config.Config;
import model.game.Matrix;
import model.game.GameResult;
import model.matching.MatchingResult;
import model.params.RunParams;
import service.config.ConfigService;
import service.game.MatrixAnalysisService;
import service.game.MatrixCreationService;
import service.game.GameResultService;
import util.PrintingHelper;

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
        catch(Exception e) {
            System.err.println("Parameters invalid, cannot create matrix");
            System.exit(0);
        }
        MatrixCreationService matrixCreationService = new MatrixCreationService(config);
        Matrix matrix = matrixCreationService.initializeBoard(config.getRows(),config.getColumns());
        PrintingHelper.printMatrix(matrix);
        MatrixAnalysisService matrixAnalysisService = new MatrixAnalysisService(config);
        List<MatchingResult> matchingResultList = matrixAnalysisService.analyzeBoard(matrix);
        double reward = matrixAnalysisService.computeReward(runParams.getBettingAmount());
        String bonusName = reward == 0 ? "" : matrixAnalysisService.findBonus(matrix);
        reward = matrixAnalysisService.addBonus(reward, bonusName);
        System.out.println((int) reward);
        GameResultService gameResultService = new GameResultService();
        GameResult gameResult = gameResultService.createGameResult(matrix, reward, matchingResultList, bonusName);
        gameResultService.generateOutput(gameResult);
    }
}
