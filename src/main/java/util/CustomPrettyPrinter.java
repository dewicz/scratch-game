package util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;

import java.io.IOException;

public class CustomPrettyPrinter extends DefaultPrettyPrinter {

    private int depth = 0;

    @Override
    public void writeEndArray(JsonGenerator g, int nrOfValues) throws IOException {
        g.writeRaw(" ]");
        depth--;
    }

    @Override
    public void writeStartArray(JsonGenerator g) throws IOException {
        depth++;
        if(depth > 1)
            g.writeRaw("\n      [");
        else
            g.writeRaw("[ ");
    }

        @Override
    public DefaultPrettyPrinter createInstance() {
        return new CustomPrettyPrinter();
    }
}
