package model.game;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MatrixTest {

    private Matrix matrix;

    @Before
    public void setUp() {
        matrix = new Matrix(3, 3);
    }

    @Test
    public void testMatrixInitialization() {
        String[][] matrixData = matrix.getMatrix();
        assertNotNull(matrixData);
        assertEquals(3, matrixData.length);
        assertEquals(3, matrixData[0].length);
    }

    @Test
    public void testSetMatrix() {
        String[][] newMatrix = {{"A", "B", "C"}, {"D", "E", "F"}, {"G", "H", "I"}};
        matrix.setMatrix(newMatrix);
        String[][] matrixData = matrix.getMatrix();
        assertEquals("A", matrixData[0][0]);
        assertEquals("I", matrixData[2][2]);
    }

    @Test
    public void testSetMatrixWithDifferentSize() {
        String[][] newMatrix = {{"1", "2"}, {"3", "4"}};
        matrix.setMatrix(newMatrix);
        String[][] matrixData = matrix.getMatrix();
        assertEquals(2, matrixData.length);
        assertEquals(2, matrixData[0].length);
        assertEquals("1", matrixData[0][0]);
        assertEquals("4", matrixData[1][1]);
    }

    @Test
    public void testGetMatrixAfterSet() {
        String[][] newMatrix = {{"X", "Y", "Z"}, {"A", "B", "C"}, {"D", "E", "F"}};
        matrix.setMatrix(newMatrix);
        String[][] matrixData = matrix.getMatrix();
        assertNotNull(matrixData);
        assertEquals("X", matrixData[0][0]);
        assertEquals("F", matrixData[2][2]);
    }
}
