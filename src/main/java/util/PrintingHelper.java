package util;

import model.game.Matrix;

public class PrintingHelper {

    //can be used for printing matrix in the console
    public static void printMatrix(Matrix matrix) {
        String[][] b = matrix.getMatrix();
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    }
}
