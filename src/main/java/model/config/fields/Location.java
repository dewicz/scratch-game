package model.config.fields;

public class Location {
    int row;
    int column;

    public Location(String location) {
        String[] locations = location.split(":");
        row = Integer.parseInt(locations[0]);
        column = Integer.parseInt(locations[1]);
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
