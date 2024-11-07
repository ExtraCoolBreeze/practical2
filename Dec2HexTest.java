import org.junit.Test;
import static org.junit.Assert.*;

public class Dec2HexTest {
	/**normal unit test*/
    @Test
    public void testNormal() {
        assertEquals("10 should be A", "A", Dec2Hex.decimalToHexadecimal(10));
        assertEquals("255 should be FF", "FF", Dec2Hex.decimalToHexadecimal(255));
        assertEquals("0 should be 0", "0", Dec2Hex.decimalToHexadecimal(0));
    }
	/** exceptional unit test*/
    @Test
    public void testExceptionalNegative() {
        assertEquals("Negative input should return an empty string", "", Dec2Hex.decimalToHexadecimal(-1));
    }
	/** extreme unit test*/
    @Test
    public void testExtreme() {
        assertEquals("The hexadecimal of 1023 should be 3FF", "3FF", Dec2Hex.decimalToHexadecimal(1023));
        assertEquals("The hexadecimal of 2047 should be 7FF", "7FF", Dec2Hex.decimalToHexadecimal(2047));
        assertEquals("The hexadecimal of 65535 should be FFFF", "FFFF", Dec2Hex.decimalToHexadecimal(65535));
    }
	/** No input test*/
	@Test
    public void testMainNoInputArgument() {
        /**testingoutput*/
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errContent));

        /** call main method*/
        Dec2Hex.main(new String[]{});

        /** print message*/
        assertEquals("Error: No input argument provided. Please provide an integer to convert.\n", errContent.toString());

        /**reset error */
        System.setErr(System.err);
   }
	/**Non int test */
    @Test
    public void testMainNonIntegerInput() {
        /**testing output*/
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errContent));

        /**testing main*/
        Dec2Hex.main(new String[]{"abc"});

        /** print error message
	*/
        assertEquals("Error: Invalid input. Please provide a valid integer.\n", errContent.toString());

        /**reset error
	*/
        System.setErr(System.err);
    }
}
