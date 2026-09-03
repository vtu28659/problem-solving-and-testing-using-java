import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FrequencyCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        // LinkedHashMap preserves the insertion order of unique hashtags
        Map<String, Integer> counts = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String hashtag = sc.next();
            counts.put(hashtag, counts.getOrDefault(hashtag, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        sc.close();
    }
}