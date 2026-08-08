import java.util.Scanner;

public class MaximumProfitAnalyser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N (number of days)
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();

        int[] profits = new int[n];
        for (int i = 0; i < n; i++) {
            profits[i] = scanner.nextInt();
        }

        // Kadane's Algorithm to find maximum subarray sum
        long maxSoFar = profits[0];
        long currentMax = profits[0];

        for (int i = 1; i < n; i++) {
            currentMax = Math.max((long) profits[i], currentMax + profits[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        // Output the result
        System.out.println(maxSoFar);

        scanner.close();
    }
}