package model.config.fields;

public class Location {
    int row;
    int column;

    public Location(String location) {
        String[] locations = location.split(":");
        row = Integer.parseInt(locations[0]);
        column = Integer.parseInt(locations[1]);
    }
}
