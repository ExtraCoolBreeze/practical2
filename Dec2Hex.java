public class Dec2Hex {
    private static final char[] hexCharacters = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Error: No input argument provided. Please provide an integer to convert.");
        }

        try {
            int decimal = Integer.parseInt(args[0]);
            String hex = decimalToHexadecimal(decimal);
            printResult(decimal, hex);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Error: Invalid input. Please provide a valid integer.", e);
        }
    }

    public static String decimalToHexadecimal(int decimal) {
        if (decimal < 0) {
            throw new IllegalArgumentException("Negative values are not supported.");
        }

        StringBuilder hexadecimal = new StringBuilder();
        if (decimal == 0) {
            return "0";
        }
        while (decimal != 0) {
            int rem = decimal % 16;
            hexadecimal.insert(0, hexCharacters[rem]);
            decimal /= 16;
        }
        return hexadecimal.toString();
    }

    private static void printResult(int decimal, String hex) {
        System.out.println("Converting the Decimal Value " + decimal + " to Hex: " + hex);
    }
}
