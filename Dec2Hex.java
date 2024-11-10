public class Dec2Hex { 
	/** list of hex characters*/
    private static final char[] hexCharacters = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
	/***main method if no input retusn error*/
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Error: No input argument provided. Please provide an integer to convert.");
	    return;
        }
	/**try catch for conversion with error handling a non input with try catch block for invalid inputs*/
        try {
            int decimal = Integer.parseInt(args[0]);
            String hex = decimalToHexadecimal(decimal);
		/**validates conversion*/
	    if (!hex.isEmpty()){
            	printResult(decimal, hex);
	    } /**handles and displays error*/
        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid input. Please provide a valid integer. " + e.getMessage());
        }
    }
	/**number to hex fucntion perfoming check for negative int and printing error*/
    public static String decimalToHexadecimal(int decimal) {
        if (decimal < 0) {
            System.err.println("Negative values are not supported.");
	    return "";
        }
	/** initilising builder funciton*/
        StringBuilder hexadecimal = new StringBuilder();
        if (decimal == 0) {
            return "0";
        } /**number to hex conversion with loop and retuning value*/
        while (decimal != 0) {
            int rem = decimal % 16;
            hexadecimal.insert(0, hexCharacters[rem]);
            decimal /= 16;
        }
        return hexadecimal.toString();
    }
	/**prints result of number to hex*/
    private static void printResult(int decimal, String hex) {
        System.out.println("Converting the Decimal Value " + decimal + " to Hex: " + hex);
    }
}
