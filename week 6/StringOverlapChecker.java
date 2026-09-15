import java.util.*;

public class StringOverlapChecker {

    // Unique method name to check for common characters
    public static String hasSharedSubstring(String firstStr, String secondStr) {
        Set<Character> uniqueChars = new HashSet<>();
        
        for (char ch : firstStr.toCharArray()) {
            uniqueChars.add(ch);
        }
        
        for (char ch : secondStr.toCharArray()) {
            if (uniqueChars.contains(ch)) {
                return "YES";
            }
        }
        
        return "NO";
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        
        if (!inputScanner.hasNextInt()) {
            inputScanner.close();
            return;
        }
        
        int totalCases = inputScanner.nextInt();
        
        for (int i = 0; i < totalCases; i++) {
            String strA = inputScanner.next();
            String strB = inputScanner.next();
            System.out.println(hasSharedSubstring(strA, strB));
        }
        
        inputScanner.close();
    }
}
}