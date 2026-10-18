import java.util.*;
public class students {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> marks = new ArrayList<>();
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        System.out.println("Enter student marks:");

        for (int i = 0; i < n; i++) {
            marks.add(sc.nextInt());
        }

        System.out.println("Student Marks: " + marks);

        int highest = Collections.max(marks);
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        double average = (double) sum / n;
        System.out.println("Highest Mark = " + highest);
        System.out.printf("Average = %.2f%n", average);
        sc.close();
    }
}
