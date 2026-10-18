import java.util.Scanner;
import java.util.HashMap;
public class TwoSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                System.out.println("[" + map.get(complement) + ", " + i + "]");
                sc.close();
                return;
            }
            map.put(nums[i], i);
        }
        System.out.println("No solution found");
        sc.close();
    }
}
