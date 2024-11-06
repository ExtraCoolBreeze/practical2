import java.util.Scanner;
import java.util.logging.Logger;
public class Dec2Hex{

	private static int arg1;
    	public static void main(String[] args)
	{
        	if (args.length == 0)
		{
        	    System.out.println("Error: No input argument provided. Please provide an integer to convert.");
            	    return;
        	}
        	try
		{
	  		setArg1(Integer.parseInt(args[0]));
        	}
		catch (NumberFormatException e)
		{
            		System.out.println("Error: Invalid input. Please provide an integer to convert.");
	    		return;
		}

		char[] ch = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        	int rem;
		int num;
        	num = getArg1();
		StringBuilder hexadecimal = new StringBuilder();
        	System.out.println("Converting the Decimal Value " + num + " to Hex...");
		while (num != 0)
		{
            		rem = num%16;
            		hexadecimal.insert(0, ch[rem]);
            		num = num/16;
        	}
		System.out.println("Hexadecimal representation is: " + hexadecimal);
	}

	public static int getArg1()
	{
        	return arg1;
    	}
    	public static void setArg1(int inputValue)
	{
        	arg1 = inputValue;
    	}
}
