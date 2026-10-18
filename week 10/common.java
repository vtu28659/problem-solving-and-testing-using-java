import java.util.*;
public class common {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> student1 = new ArrayList<>();
        ArrayList<String> student2 = new ArrayList<>();
        System.out.print("Enter number of subjects for Student 1: ");
        int n1 = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Student 1 subjects:");
        for (int i = 0; i < n1; i++) {
            student1.add(sc.nextLine());
        }
        System.out.print("Enter number of subjects for Student 2: ");
        int n2 = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Student 2 subjects:");
        for (int i = 0; i < n2; i++) {
            student2.add(sc.nextLine());
        }
        student1.retainAll(student2);
        System.out.println("Common Subjects: " + student1);
        sc.close();
    }
}
