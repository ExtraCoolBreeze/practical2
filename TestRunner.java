import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.lang.Exception;

/**test runner class to run the unit test file*/
public class TestRunner {
    public static void main(String[] args) {
        try {/**runs the class*/
            Result result = JUnitCore.runClasses(Dec2HexTest.class);
		/**checks for errors*/
            if (result.getFailureCount() > 0) {
                System.out.println(result.getFailureCount() + " tests failed:");
                /**for each loop that prints the details of errors*/
		for (Failure failure : result.getFailures()) {
                    System.out.println(failure.toString());
                }
                System.exit(1);
            } else { /**prints when all tests pass*/
                System.out.println("All tests passed successfully.");
                System.exit(0);
            } /**error handling for exceptions during running*/
        } catch (Exception e) {
            System.err.println("An exception occurred during test execution: " + e.getMessage());
            e.printStackTrace();
            System.exit(2);
        }
    }
}
