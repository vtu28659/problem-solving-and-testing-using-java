import java.util.*;
public class Sorted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashSet<String> items = new LinkedHashSet<>();
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter purchased items:");
        for (int i = 0; i < n; i++) {
            items.add(sc.nextLine());
        }
        System.out.println("Unique Items:");
        for (String item : items) {
            System.out.println(item);
        }
        sc.close();
    }
}
