import java.util.Arrays;

public class LongestSubstringWithoutRepeatingChars {
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        
        int[] lastSeen = new int[128];
        Arrays.fill(lastSeen, -1);

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            if (lastSeen[currentChar] >= left) {
                left = lastSeen[currentChar] + 1;
            }

            lastSeen[currentChar] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String testInput = args.length > 0 ? args[0] : "abcabcbb";
        
        int result = lengthOfLongestSubstring(testInput);
        System.out.println("Input: " + testInput);
        System.out.println("Longest Substring Length: " + result);
    }
}