import java.util.Scanner;

public class DigitSumCalculator {

    // Reducer function to sum digits until a single digit remains
    public static int getSingleDigitSum(int number) {
        while (number >= 10) {
            int currentSum = 0;
            while (number > 0) {
                currentSum += number % 10;
                number /= 10;
            }
            number = currentSum;
        }
        return number;
    }

    // Main logic to filter and sum digits based on parity
    public static int calculateParityDigitSum(long number, boolean checkEven) {
        // Handle negative numbers
        number = Math.abs(number);
        
        // Handle edge case where number is 0
        if (number == 0) {
            return 0;
        }

        int initialSum = 0;

        // Process each digit of the number
        while (number > 0) {
            int digit = (int) (number % 10);
            
            if (checkEven && digit % 2 == 0) {
                initialSum += digit; // Add if even
            } else if (!checkEven && digit % 2 != 0) {
                initialSum += digit; // Add if odd
            }
            
            number /= 10;
        }

        // Return the final single-digit sum
        return getSingleDigitSum(initialSum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        long inputNumber = scanner.nextLong();

        // Calculate both results
        int evenResult = calculateParityDigitSum(inputNumber, true);
        int oddResult = calculateParityDigitSum(inputNumber, false);

        // Display results
        System.out.println("Digit sum of EVEN digits: " + evenResult);
        System.out.println("Digit sum of ODD digits: " + oddResult);

        scanner.close();
    }
}
