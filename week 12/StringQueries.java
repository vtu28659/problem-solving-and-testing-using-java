import java.util.*;
public class StringQueries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<String, Integer> frequency = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            frequency.put(s, frequency.getOrDefault(s, 0) + 1);
        }
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            String query = sc.next();
            System.out.println(frequency.getOrDefault(query, 0));
        }
        sc.close();
    }
}
