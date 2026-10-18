import java.util.*;
public class webBrowser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> history = new Stack<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            history.push(sc.next());
        }

        if (!history.isEmpty()) {
            System.out.println("Back: " + history.pop());
        }
        System.out.println("Remaining History:");
        while (!history.isEmpty()) {
            System.out.println(history.pop());
        }
        sc.close();
    }
}
