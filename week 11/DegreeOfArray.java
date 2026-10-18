import java.util.Scanner;
import java.util.HashMap;
public class DegreeOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        HashMap<Integer, Integer> count = new HashMap<>();
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> last = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            if (!first.containsKey(nums[i])) {
                first.put(nums[i], i);
            }
            last.put(nums[i], i);
        }
        int degree = 0;
        for (int value : count.values()) {
            degree = Math.max(degree, value);
        }
        int result = n;
        for (int num : count.keySet()) {
            if (count.get(num) == degree) {
                int length = last.get(num) - first.get(num) + 1;
                result = Math.min(result, length);
            }
        }
        System.out.println(result);
        sc.close();
    }
}
