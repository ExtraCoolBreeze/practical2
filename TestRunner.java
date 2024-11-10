import java.util.logging.Logger;
import java.util.logging.Level;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.lang.Exception;

public class TestRunner {
    private static final Logger logger = Logger.getLogger(TestRunner.class.getName());

/**test runner class to run the unit test file*/
public class TestRunner {
    public static void main(String[] args) {
        try {/**runs the class*/
            Result result = JUnitCore.runClasses(Dec2HexTest.class);
		/**checks for errors*/
            if (result.getFailureCount() > 0) {
                logger.warning(result.getFailureCount() + " tests failed:");
                /**for each loop that prints the details of errors*/
		for (Failure failure : result.getFailures()) {
                    logger.warning(failure.toString());
                }
                System.exit(1);
            } else { /**prints when all tests pass*/
                logger.info("All tests passed successfully.");
                System.exit(0);
            } /**error handling for exceptions during running*/
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An exception occurred during test execution: " + e.getMessage());
            System.exit(2);
        }
    }
  }
}
