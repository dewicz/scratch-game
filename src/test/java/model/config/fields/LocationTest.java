package model.config.fields;

import static org.junit.Assert.*;

import org.junit.Test;

public class LocationTest {

    private Location location;

    @Test
    public void testLocationConstructor() {
        location = new Location("5:10");
        assertEquals(5, location.row);
        assertEquals(10, location.column);
    }

    @Test(expected = NumberFormatException.class)
    public void testInvalidLocationFormat() {
        new Location("invalid:format");
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testMissingLocationValue() {
        new Location("5:");
    }
}

