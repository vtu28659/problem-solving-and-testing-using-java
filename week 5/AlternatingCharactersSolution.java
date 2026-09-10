import java.util.Scanner;

public class AlternatingCharactersSolution {

    public static int alternatingCharacters(String s) {
        int deletions = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                deletions++;
            }
        }
        return deletions;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNextInt()) {
            int q = scanner.nextInt();
            for (int i = 0; i < q; i++) {
                String s = scanner.next();
                System.out.println(alternatingCharacters(s));
            }
        }
        
        scanner.close();
    }
}