public class RepeatedSubstringPatternTest {

    public static boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;
        // Check if s is present in doubled (excluding first and last characters)
        return doubled.substring(1, doubled.length() - 1).contains(s);
    }

    public static void main(String[] args) {
        // Test examples
        String[] testCases = {"abab", "aba", "abcabcabcabc"};

        for (String test : testCases) {
            System.out.println("Input: \"" + test + "\" -> Output: " + repeatedSubstringPattern(test));
        }
    }
}