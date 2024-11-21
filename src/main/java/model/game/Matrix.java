package model.game;

public class Matrix {
    private String[][] matrix;

    public Matrix(int rows, int columns) {
        this.matrix = new String[rows][columns];
    }

    public String[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(String[][] matrix) {
        this.matrix = matrix;
    }
}
