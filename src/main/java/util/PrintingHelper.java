package util;

import model.game.Board;

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
}
