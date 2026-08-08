import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IntelligentDNAPatternSearch {

    // Function to compute the Longest Prefix Suffix (LPS) array
    private static int[] computeLPSArray(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0; // Length of previous longest prefix suffix
        int i = 1;

        lps[0] = 0; // lps[0] is always 0

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    // Function to perform KMP pattern searching
    public static void kmpSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        if (m > n || m == 0) return;

        int[] lps = computeLPSArray(pattern);
        List<Integer> resultIndices = new ArrayList<>();

        int i = 0; // Index for text T
        int j = 0; // Index for pattern P

        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == m) {
                // Pattern found at index (i - j)
                resultIndices.add(i - j);
                j = lps[j - 1];
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        // Output all starting indices space-separated
        for (int k = 0; k < resultIndices.size(); k++) {
            System.out.print(resultIndices.get(k) + (k == resultIndices.size() - 1 ? "" : " "));
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Read DNA text T and pattern P
        String text = reader.readLine();
        String pattern = reader.readLine();

        if (text != null && pattern != null) {
            kmpSearch(text.trim(), pattern.trim());
        }
    }
}