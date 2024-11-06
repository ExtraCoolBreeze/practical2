import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Dec2HexTest {

    @Test
    public void testNormal() {
        assertEquals("10 should be A", "A", Dec2Hex.decimalToHexadecimal(10));
        assertEquals("255 should be FF", "FF", Dec2Hex.decimalToHexadecimal(255));
        assertEquals("0 should be 0", "0", Dec2Hex.decimalToHexadecimal(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionalNegative() {
        Dec2Hex.decimalToHexadecimal(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionalInvalidInput() {
        Dec2Hex.main(new String[]{});
    }

    @Test
    public void testExtreme() {
        assertEquals("The hexadecimal of 1023 should be 3FF", "3FF", Dec2Hex.decimalToHexadecimal(1023));
        assertEquals("The hexadecimal of 2047 should be 7FF", "7FF", Dec2Hex.decimalToHexadecimal(2047));
        assertEquals("The hexadecimal of 65535 should be FFFF", "FFFF", Dec2Hex.decimalToHexadecimal(65535));
    }
}

