import java.util.*;
public class TopKFrequentWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] words = new String[n];
        HashMap<String, Integer> frequency = new HashMap<>();
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
            frequency.put(words[i],
                frequency.getOrDefault(words[i], 0) + 1);
        }
        int k = sc.nextInt();
        ArrayList<String> list = new ArrayList<>(frequency.keySet());
        Collections.sort(list, (a, b) -> {
            if (!frequency.get(a).equals(frequency.get(b))) {
                return Integer.compare(frequency.get(b), frequency.get(a));
            }
            return a.compareTo(b);
        });
        for (int i = 0; i < k && i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        sc.close();
    }
}
