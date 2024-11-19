package service.game;

import model.config.Config;
import model.config.fields.Probability;
import model.game.Board;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BoardCreationService {

    private final Config config;
    private final Random random;

    public BoardCreationService(Config config) {
        this.config = config;
        random = new Random();
    }

    public Board initializeBoard(int rows, int columns) {
        Board board = new Board(rows, columns);
        Probability probabilities = config.getProbabilities();
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                board.getBoard()[i][j] = getSymbol(probabilities.retrieveCellAllocation(i,j).getSymbols());
            }
        }
        addBonusSymbol(board);
        return board;
    }

    public String getSymbol(Map<String, Integer> symbols) {
        Map<String, Double> normalizedProbabilities = calculateNormalizedProbabilities(symbols);
        return findSymbol(normalizedProbabilities);
    }

    /**
     * Assumption: adding one bonus symbol per board, generated based on probabilities provided
     * and added by replacing one of the existing cells
     */
    private void addBonusSymbol(Board board) {
        int row = random.nextInt(board.getBoard().length);
        int col = random.nextInt(board.getBoard()[0].length);
        board.getBoard()[row][col] = generateBonusSymbol();
    }

    private String generateBonusSymbol() {
        Map<String, Integer> bonusSymbols = config.getProbabilities().getBonusSymbols().getSymbols();
        Map<String, Double> normalizedProbabilities = calculateNormalizedProbabilities(bonusSymbols);
        return findSymbol(normalizedProbabilities);
    }

    private Map<String, Double> calculateNormalizedProbabilities(Map<String, Integer> symbols) {
        int totalProbability = symbols.values().stream().mapToInt(Integer::intValue).sum();

        Map<String, Double> normalizedProbabilities = new HashMap<>();
        for (Map.Entry<String, Integer> entry : symbols.entrySet()) {
            normalizedProbabilities.put(entry.getKey(), (double) entry.getValue() / totalProbability);
        }
        return normalizedProbabilities;
    }

    private String findSymbol(Map<String, Double> normalizedProbabilities) {
        String symbol = "";
        double randomValue = random.nextDouble(); //val between 0 and 1
        double cumulativeProbability = 0.0;
        for (Map.Entry<String, Double> entry : normalizedProbabilities.entrySet()) {
            cumulativeProbability += entry.getValue();
            if (randomValue <= cumulativeProbability) {
                symbol = entry.getKey();  // Return the selected letter
                break;
            }
        }
        return symbol;
    }
}
