package util;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import model.game.Matrix;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PrintingHelperTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private Matrix mockMatrix;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));

        mockMatrix = mock(Matrix.class);
        String[][] board = {{"X", "O"}, {"O", "X"}};
        when(mockMatrix.getMatrix()).thenReturn(board);
    }

    @Test
    public void testPrintBoard() {
        PrintingHelper.printMatrix(mockMatrix);

        String expectedOutput = "X O " + System.lineSeparator() + "O X " + System.lineSeparator();

        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }

    @After
    public void tearDown() {
        System.setOut(System.out);
    }
}
