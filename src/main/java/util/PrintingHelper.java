package util;

import model.game.Matrix;

public class PrintingHelper {

    public static void printBoard(Matrix matrix) {
        String[][] b = matrix.getBoard();
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    }
}
