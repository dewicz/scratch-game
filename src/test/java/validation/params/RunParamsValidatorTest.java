package validation.params;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class RunParamsValidatorTest {

    private RunParamsValidator validator = new RunParamsValidator();

    @Test
    public void testValidatePath_NullPath() {
        assertFalse("Should return false for null path", validator.validatePath(null));
    }

    @Test
    public void testValidatePath_NonExistentPath() {
        String nonExistentPath = "non_existent_file.txt";
        assertFalse("Should return false for a non-existent file", validator.validatePath(nonExistentPath));
    }

    @Test
    public void testValidatePath_ValidPath() throws IOException {
        // Create a temporary file to test
        File tempFile = File.createTempFile("testFile", ".txt");
        tempFile.deleteOnExit();

        assertTrue("Should return true for a valid file path", validator.validatePath(tempFile.getAbsolutePath()));
    }

    @Test
    public void testValidateBettingAmount_NullAmount() {
        assertFalse("Should return false for null amount", validator.validateBettingAmount(null));
    }

    @Test
    public void testValidateBettingAmount_NonNumericAmount() {
        String nonNumeric = "abc";
        assertFalse("Should return false for non-numeric amount", validator.validateBettingAmount(nonNumeric));
    }

    @Test
    public void testValidateBettingAmount_ZeroAmount() {
        String zeroAmount = "0";
        assertFalse("Should return false for zero amount", validator.validateBettingAmount(zeroAmount));
    }

    @Test
    public void testValidateBettingAmount_NegativeAmount() {
        String negativeAmount = "-10";
        assertFalse("Should return false for negative amount", validator.validateBettingAmount(negativeAmount));
    }

    @Test
    public void testValidateBettingAmount_ValidAmount() {
        String validAmount = "100";
        assertTrue("Should return true for valid amount", validator.validateBettingAmount(validAmount));
    }
}
