
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LoginSystem system = new LoginSystem();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String username = sc.next();
            String password = sc.next();

            if (system.login(username, password))
                System.out.println("SUCCESS");
            else
                System.out.println("FAILURE");
        }

        sc.close();
    }
}
