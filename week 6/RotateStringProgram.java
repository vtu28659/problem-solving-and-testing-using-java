import java.util.Scanner;

public class RotateStringProgram {

    public static boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string s: ");
        String s = sc.nextLine();

        System.out.print("Enter string goal: ");
        String goal = sc.nextLine();

        boolean result = rotateString(s, goal);

        System.out.println("Result: " + result);

        sc.close();
    }
}