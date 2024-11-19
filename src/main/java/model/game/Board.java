package model.game;

public class Board {
    private String[][] board;

    public Board(int rows, int columns) {
        this.board = new String[rows][columns];
    }

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }
}
