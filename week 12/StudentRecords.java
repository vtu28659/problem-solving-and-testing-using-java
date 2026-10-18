import java.util.*;
public class StudentRecords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, String> names = new HashMap<>();
        HashMap<Integer, Integer> marks = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String name = sc.next();
            int mark = sc.nextInt();
            names.put(id, name);
            marks.put(id, mark);
        }
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int id = sc.nextInt();
            if (names.containsKey(id)) {
                System.out.println(names.get(id) + " " + marks.get(id));
            } else {
                System.out.println("Student not found");
            }
        }
        sc.close();
    }
}
