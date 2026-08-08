import java.util.*;

public class RemoveElement {


    public static int removeElement(int[] nums, int val) {


        int index = 0;


        for(int i = 0; i < nums.length; i++) {


            if(nums[i] != val) {

                nums[index] = nums[i];

                index++;

            }

        }


        return index;

    }



    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);


        System.out.print("Enter array size: ");

        int n = sc.nextInt();


        int[] nums = new int[n];


        System.out.println("Enter array elements:");

        for(int i=0;i<n;i++) {

            nums[i]=sc.nextInt();

        }


        System.out.print("Enter value to remove: ");

        int val=sc.nextInt();



        int length = removeElement(nums,val);



        System.out.println("New length: " + length);


        System.out.println("Updated Array:");

        for(int i=0;i<length;i++) {

            System.out.print(nums[i]+" ");

        }


        sc.close();

    }
}