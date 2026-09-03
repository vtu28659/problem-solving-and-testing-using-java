import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class SecureAuthStressTest {

    public static void main(String[] args) throws IOException {
        FastScanner scanner = new FastScanner();
        
        Integer N = scanner.nextInt();
        if (N == null) {
            return;
        }

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String username = scanner.next();
            String password = scanner.next();

            if (isValidAuth(username, password)) {
                output.append("SUCCESS\n");
            } else {
                output.append("FAILURE\n");
            }
        }

        System.out.print(output);
    }

    private static boolean isValidAuth(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        int uLength = username.length();
        int pLength = password.length();

        // Validate boundary values: Username (3-20), Password (6-20)
        boolean validUsername = (uLength >= 3 && uLength <= 20);
        boolean validPassword = (pLength >= 6 && pLength <= 20);

        return validUsername && validPassword;
    }

    // Fast I/O to handle thousands of login attempts efficiently
    static class FastScanner {
        private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer tokenizer;

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    String line = reader.readLine();
                    if (line == null) return null;
                    tokenizer = new StringTokenizer(line);
                } catch (IOException e) {
                    return null;
                }
            }
            return tokenizer.nextToken();
        }

        public Integer nextInt() {
            String str = next();
            return str == null ? null : Integer.parseInt(str);
        }
    }
}