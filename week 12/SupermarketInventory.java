import java.util.*;
class Product {
    int id;
    String name;
    int stock;
    double price;
    Product(int id, String name, int stock, double price) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price = price;
    }
}
public class SupermarketInventory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Product> products = new HashMap<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String name = sc.next();
            int stock = sc.nextInt();
            double price = sc.nextDouble();
            products.put(id, new Product(id, name, stock, price));
        }
        int sales = sc.nextInt();
        for (int i = 0; i < sales; i++) {
            int id = sc.nextInt();
            int sold = sc.nextInt();
            Product p = products.get(id);
            if (p != null && sold >= 0 && sold <= p.stock) {
                p.stock -= sold;
            } else {
                System.out.println("Invalid sale for product ID " + id);
            }
        }
        int threshold = sc.nextInt();
        System.out.println("Products below threshold:");
        for (Product p : products.values()) {
            if (p.stock < threshold) {
                System.out.println(p.id + " " + p.name + " " + p.stock);
            }
        }
        ArrayList<Product> list = new ArrayList<>(products.values());
        list.sort(Comparator.comparingInt(p -> p.stock));
        System.out.println("Products sorted by stock:");
        for (Product p : list) {
            System.out.println(p.id + " " + p.name + " " +
                               p.stock + " " + p.price);
        }
        int searchId = sc.nextInt();
        Product found = products.get(searchId);
        System.out.println("Product details:");
        if (found != null) {
            System.out.println(found.id + " " + found.name + " " +
                               found.stock + " " + found.price);
        } else {
            System.out.println("Product not found");
        }
        sc.close();
    }
}
