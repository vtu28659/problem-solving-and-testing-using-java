public class MoveZeroesCmd {
    public static void moveZeroes(int[] nums) {
        int insertPos = 0;
        
        // Step 1: Shift all non-zero elements to the beginning
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[insertPos] = nums[i];
                insertPos++;
            }
        }
        
        // Step 2: Fill the remaining array elements with 0
        while (insertPos < nums.length) {
            nums[insertPos] = 0;
            insertPos++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        
        System.out.println("Original array: " + java.util.Arrays.toString(nums));
        moveZeroes(nums);
        System.out.println("Modified array: " + java.util.Arrays.toString(nums));
    }
}