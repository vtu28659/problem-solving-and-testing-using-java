import java.util.Scanner;

public class LastDigitSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input two numbers
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();

        // Extract last digits using absolute values to handle negative numbers
        int lastDigit1 = Math.abs(num1) % 10;
        int lastDigit2 = Math.abs(num2) % 10;

        // Calculate sum
        int sum = lastDigit1 + lastDigit2;

        // Output result
        System.out.println("The sum of the last digits is: " + sum);
        
        scanner.close();
    }
}
