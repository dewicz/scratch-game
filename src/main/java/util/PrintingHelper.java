package util;

import model.game.Board;

import java.util.List;

public class PrintingHelper {

    public static void printBoard(Board board) {
        String[][] b = board.getBoard();
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static List<List<String>> convertMatrixToList(String[][] matrix) {
        return java.util.Arrays.stream(matrix)
                .map(java.util.Arrays::asList)
                .toList();
    }
}
