import java.util.*;
public class HashtagFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<String, Integer> frequency = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String hashtag = sc.next();
            frequency.put(hashtag, frequency.getOrDefault(hashtag, 0) + 1);
        }
        ArrayList<String> hashtags = new ArrayList<>(frequency.keySet());
        Collections.sort(hashtags, (a, b) -> {
            int freqCompare = frequency.get(b) - frequency.get(a);
            if (freqCompare == 0) {
                return a.compareTo(b);
            }
            return freqCompare;
        });
        for (String hashtag : hashtags) {
            System.out.println(hashtag + " " + frequency.get(hashtag));
        }
        sc.close();
    }
}
