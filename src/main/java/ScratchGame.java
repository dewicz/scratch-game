import model.config.Config;
import model.game.Board;
import model.params.RunParams;
import service.config.ConfigService;
import service.game.BoardService;
import util.PrintingHelper;

import java.io.IOException;

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
        BoardService boardService = new BoardService(config);
        Board board = boardService.initializeBoard(3,3);
        PrintingHelper.printBoard(board);
    }
}
