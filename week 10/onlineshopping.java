import java.util.*;
class Product {
    int id;
    String name;
    double price;
    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public String toString() {
        return id + " " + name + " Rs." + price;
    }
}

class Order {
    int orderId;
    int priority;

    Order(int orderId, int priority) {
        this.orderId = orderId;
        this.priority = priority;
    }
}

public class onlineshopping {
    public static void main(String[] args) {

        ArrayList<Product> products = new ArrayList<>();
        HashMap<Integer, Product> productMap = new HashMap<>();

        products.add(new Product(101, "Laptop", 50000));
        products.add(new Product(102, "Mobile", 20000));
        products.add(new Product(103, "Headphones", 1500));

        for (Product p : products) {
            productMap.put(p.id, p);
        }

        System.out.println("Product List:");
        for (Product p : products) {
            System.out.println(p);
        }
        int searchId = 102;
        System.out.println("\nSearch Product ID: " + searchId);

        if (productMap.containsKey(searchId)) {
            System.out.println(productMap.get(searchId));
        } else {
            System.out.println("Product not found");
        }
        PriorityQueue<Order> orders =
            new PriorityQueue<>(
                (a, b) -> Integer.compare(a.priority, b.priority)
            );
        orders.add(new Order(1, 3));
        orders.add(new Order(2, 1));
        orders.add(new Order(3, 2));
        System.out.println("\nOrders by Priority:");
        while (!orders.isEmpty()) {
            Order o = orders.poll();
            System.out.println(
                "Order ID: " + o.orderId +
                ", Priority: " + o.priority
            );
        }
    }
}
