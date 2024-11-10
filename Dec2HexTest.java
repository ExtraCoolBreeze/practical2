import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.After;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.logging.Logger;
import java.util.logging.Level;
import static org.junit.Assert.*;

public class Dec2HexTest {
	private static final Logger logger = Logger.getLogger(Dec2HexTest.class.getName());
	private ByteArrayOutputStream errContent;
	
	
    @Before
    public void setUp() {
        errContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errContent));
    }
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
	logger.info("Testing exceptional negative input");
        assertEquals("Negative input should return an empty string", "", Dec2Hex.decimalToHexadecimal(-1));
    }
	/** extreme unit test*/
    @Test
    public void testExtreme() {
        logger.info("Testing extreme input values");
	assertEquals("The hexadecimal of 1023 should be 3FF", "3FF", Dec2Hex.decimalToHexadecimal(1023));
        assertEquals("The hexadecimal of 2047 should be 7FF", "7FF", Dec2Hex.decimalToHexadecimal(2047));
        assertEquals("The hexadecimal of 65535 should be FFFF", "FFFF", Dec2Hex.decimalToHexadecimal(65535));
    }
	/** No input test*/
	@Test
    public void testMainNoInputArgument() {
        /**testingoutput*/
        System.setErr(new PrintStream(errContent));

        /** call main method*/
        Dec2Hex.main(new String[0]);
	
	String expectedError = "Error: No input argument provided. Please provide an integer to convert.\n";
        logger.warning("Testing no input");
        assertEquals(expectedError, errContent.toString());

        /**reset error */
        System.setErr(System.err);
   }
	/**Non int test */
    @Test
    public void testMainNonIntegerInput() {
        /**testing output*/
        System.setErr(new PrintStream(errContent));

        /**testing main*/
        Dec2Hex.main(new String[]{"abc"});

        /** print error message*/
	String expectedError = "Error: Invalid input. Please provide a valid integer. For input string: \"abc\"\n";
        logger.warning("Testing non-integer input");
        assertEquals(expectedError, errContent.toString());

        /**reset error*/
        System.setErr(System.err);
    }
	/**Testing negative input*/
    @Test
    public void testNegativeInput() {
	errContent.reset();
    	System.setErr(new PrintStream(errContent));
   	Dec2Hex.main(new String[]{"-1"});

   	String expectedError = "Negative values are not supported.\n";
        logger.warning("Testing negative input: Expected error message logged");
        assertEquals(expectedError, errContent.toString());

    	System.setErr(System.err);
    }
    
    @After
    public void tearDown() {
	logger.info("Resetting the System.err")
        System.setErr(System.err);
    }
}
