package model.game;

public class Matrix {
    private String[][] board;

    public Matrix(int rows, int columns) {
        this.board = new String[rows][columns];
    }

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }
}
