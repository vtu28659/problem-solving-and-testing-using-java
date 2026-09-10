import java.util.Arrays;
import java.util.Scanner;

public class PalindromeInCodeChef {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int n = s.length();
            int half = n / 2;
            
            // Extract the first and second halves (ignoring the middle character if n is odd)
            String firstHalfStr = s.substring(0, half);
            String secondHalfStr = s.substring(n - half);
            
            // Convert to char arrays to sort and compare
            char[] firstHalf = firstHalfStr.toCharArray();
            char[] secondHalf = secondHalfStr.toCharArray();
            
            Arrays.sort(firstHalf);
            Arrays.sort(secondHalf);
            
            if (Arrays.equals(firstHalf, secondHalf)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}