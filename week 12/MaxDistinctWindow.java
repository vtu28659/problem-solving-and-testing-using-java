import java.util.*;
public class MaxDistinctWindow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        if (k <= 0 || k > n) {
            System.out.println(0);
            sc.close();
            return;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxDistinct = 0;
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if (i >= k - 1) {
                maxDistinct = Math.max(maxDistinct, map.size());
                int outgoing = arr[i - k + 1];
                map.put(outgoing, map.get(outgoing) - 1);
                if (map.get(outgoing) == 0) {
                    map.remove(outgoing);
                }
            }
        }
        System.out.println(maxDistinct);
        sc.close();
    }
}
