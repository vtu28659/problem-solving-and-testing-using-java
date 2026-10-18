import java.util.*;
public class TopKFrequent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer> elements = new ArrayList<>(frequency.keySet());
        Collections.sort(elements, (a, b) -> {
            if (frequency.get(a).equals(frequency.get(b))) {
                return Integer.compare(a, b);
            }
            return Integer.compare(frequency.get(b), frequency.get(a));
        });
        for (int i = 0; i < k && i < elements.size(); i++) {
            System.out.print(elements.get(i) + " ");
        }
        sc.close();
    }
}
