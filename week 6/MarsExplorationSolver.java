import java.util.Scanner;

public class MarsExplorationSolver {

    public static int countAlteredLetters(String s) {
        int changedCount = 0;

        for (int i = 0; i < s.length(); i++) {
            // Check expected characters for 'S', 'O', 'S' based on position modulo 3
            if (i % 3 == 0 && s.charAt(i) != 'S') {
                changedCount++;
            } else if (i % 3 == 1 && s.charAt(i) != 'O') {
                changedCount++;
            } else if (i % 3 == 2 && s.charAt(i) != 'S') {
                changedCount++;
            }
        }

        return changedCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            String s = scanner.next();
            System.out.println(countAlteredLetters(s));
        }
        scanner.close();
    }
}