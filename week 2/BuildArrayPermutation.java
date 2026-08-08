import java.util.*;

public class BuildArrayPermutation {

    public static int[] buildArray(int[] nums) {

        int[] ans = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }

        return ans;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");

        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }


        int[] result = buildArray(nums);


        System.out.println("Output Array:");

        for(int x : result) {
            System.out.print(x + " ");
        }


        sc.close();
    }
}