public class Fibonacci {
    public static int getNthFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        
        int prev2 = 0; // Represents F(n-2)
        int prev1 = 1; // Represents F(n-1)
        int current = 0;
        
        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        
        return current;
    }

    public static void main(String[] args) {
        int n = 9; 
        System.out.println("Fibonacci number at position " + n + " is: " + getNthFibonacci(n));
        // Output: 34
    }
}
