import java.util.Scanner;
public class MigratoryBirds {
    public static int migratoryBirds(int[] arr) {
        int[] count = new int[6];
        for (int bird : arr) {
            count[bird]++;
        }
        int maxCount = 0;
        int result = 0;
        for (int i = 1; i <= 5; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                result = i;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(migratoryBirds(arr));
        sc.close();
    }
}
