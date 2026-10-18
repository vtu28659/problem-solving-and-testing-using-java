import java.util.Scanner;
public class teacher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] marks = new int[2];
        int count = 0;
        System.out.println("Enter marks (-1 to stop):");

        while (true) {
            int mark = sc.nextInt();

            if (mark == -1) {
                break;
            }

            if (count == marks.length) {
                int[] newMarks = new int[marks.length * 2];

                for (int i = 0; i < marks.length; i++) {
                    newMarks[i] = marks[i];
                }

                marks = newMarks;
            }

            marks[count] = mark;
            count++;
        }
        System.out.println("Student Marks:");
        for (int i = 0; i < count; i++) {
            System.out.println(marks[i]);
        }
        sc.close();
    }
}
