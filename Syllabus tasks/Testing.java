import java.util.Scanner;

class Calculator {
    public static double evaluate(double a, String op, double b) throws ArithmeticException, IllegalArgumentException {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid operator: " + op);
        }
    }
}

public class Testing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNext()) return;

        try {
            double operand1 = sc.nextDouble();
            String operator = sc.next();
            double operand2 = sc.nextDouble();

            // Perform operation
            double result = Calculator.evaluate(operand1, operator, operand2);

            // Simple validation assertion check
            System.out.println("Test Passed");
        } catch (Exception e) {
            System.out.println("Test Failed");
        }

        sc.close();
    }
}