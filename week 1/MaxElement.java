public class MaxElement {
    public static int findMax(int[] arr) {
        // Assume the first element is the largest
        int max = arr[0]; 
        
        // Loop through the rest of the array
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] numbers = {4, 12, 7, 21, 5, 1};
        System.out.println("Maximum element: " + findMax(numbers)); // Outputs 21
    }
}
