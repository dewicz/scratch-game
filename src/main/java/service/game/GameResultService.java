package service.game;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter.Indenter;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.databind.SerializationFeature;
import model.game.Board;
import model.game.GameResult;
import model.matching.MatchingResult;
import util.CustomPrettyPrinter;
import util.PrintingHelper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameResultService {

    public GameResult createGameResult(Board board, double reward, List<MatchingResult> matchingResults, String bonus) {
        Map<String, List<String>> resultMap = new HashMap<>();
        for(MatchingResult matchingResult : matchingResults) {
            List<String> list = resultMap.getOrDefault(matchingResult.getSymbol(), new ArrayList<>());
            list.add(matchingResult.getWinCombo());
            resultMap.put(matchingResult.getSymbol(), list);
        }
        return new GameResult(PrintingHelper.convertMatrixToList(board.getBoard()), reward, resultMap, bonus);
    }

    public void generateOutput(GameResult gameResult) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.setDefaultPrettyPrinter(new CustomPrettyPrinter());
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("result.json"), gameResult);
            System.out.println("JSON file created successfully!");
        } catch (IOException e) {
            System.err.println("Failure in output generation!");
        }
    }
}
