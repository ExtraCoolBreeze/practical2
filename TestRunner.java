import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner
{
    	public static void main(String[] args)
	{
        	try
		{
            		Result result = JUnitCore.runClasses(Dec2HexTest.class);
            		if (result.getFailureCount() > 0)
			{
                		System.out.println(result.getFailureCount() + " tests failed:");
                		for (Failure failure : result.getFailures())
				{
                    			System.out.println(failure.toString());
                		}
                			System.exit(1);
            		}
			else
			{
                		System.out.println("All tests passed successfully.");
                		System.exit(0);
            		}
		}
		catch (Exception e)
		{
            		System.err.println("An exception occurred during test execution: " + e.getMessage());
            		e.printStackTrace();
            		System.exit(2);
        	}
    	}
}

