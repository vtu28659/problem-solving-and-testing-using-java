import java.util.*;

public class ShuffleArray {


    public static int[] shuffle(int[] nums, int n) {


        int[] ans = new int[2*n];

        int index = 0;


        for(int i = 0; i < n; i++) {

            ans[index++] = nums[i];

            ans[index++] = nums[i+n];

        }


        return ans;

    }



    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);


        System.out.print("Enter n: ");

        int n = sc.nextInt();


        int[] nums = new int[2*n];


        System.out.println("Enter array elements:");

        for(int i=0;i<2*n;i++) {

            nums[i]=sc.nextInt();

        }


        int[] result = shuffle(nums,n);



        System.out.println("Shuffled Array:");

        for(int x:result) {

            System.out.print(x+" ");

        }


        sc.close();

    }

}