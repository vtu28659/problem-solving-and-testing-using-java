public class StringToIntConverter {
    public static int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int i = 0;
        int n = s.length();

        // 1. Skip leading whitespace
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        if (i == n) {
            return 0;
        }

        // 2. Check sign
        int sign = 1;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // 3. Convert digits and check for overflow
        int total = 0;
        while (i < n) {
            char ch = s.charAt(i);
            if (ch < '0' || ch > '9') {
                break;
            }

            int digit = ch - '0';

            // Check overflow/underflow before multiplying by 10
            if (total > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            total = total * 10 + digit;
            i++;
        }

        return total * sign;
    }

    public static void main(String[] args) {
        String[] testCases = {
            "42",
            "   -042",
            "1337c0d3",
            "0-1",
            "words and 987",
            "-91283472332"
        };

        for (String test : testCases) {
            System.out.printf("Input: \"%s\" -> Output: %d%n", test, myAtoi(test));
        }
    }
}