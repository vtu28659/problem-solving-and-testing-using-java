import java.util.*;

public class RemoveDuplicates {


    public static int removeDuplicates(int[] nums) {


        if(nums.length == 0)

            return 0;



        int index = 1;



        for(int i=1;i<nums.length;i++) {


            if(nums[i] != nums[i-1]) {


                nums[index] = nums[i];

                index++;

            }

        }


        return index;

    }



    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);



        System.out.print("Enter array size: ");

        int n=sc.nextInt();



        int[] nums=new int[n];


        System.out.println("Enter sorted array elements:");

        for(int i=0;i<n;i++) {

            nums[i]=sc.nextInt();

        }



        int length = removeDuplicates(nums);



        System.out.println("Number of unique elements: "+length);



        System.out.println("Array after removing duplicates:");

        for(int i=0;i<length;i++) {

            System.out.print(nums[i]+" ");

        }



        sc.close();

    }
}