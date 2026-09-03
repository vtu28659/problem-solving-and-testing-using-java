import java.util.*;

class Product {
    private String id;
    private String name;
    private double price;
    private int stockQuantity;
    private int totalSold; 

    public Product(String id, String name, double price, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.totalSold = 0;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStockQuantity() { return stockQuantity; }
    public int getTotalSold() { return totalSold; }

    public void reduceStock(int quantity) {
        this.stockQuantity -= quantity;
        this.totalSold += quantity;
    }

    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    @Override
    public String toString() {
        return String.format("[%s] %-15s | Price: $%.2f | Stock: %d | Total Sold: %d", 
                             id, name, price, stockQuantity, totalSold);
    }
}

class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public double getTotalPrice() { return product.getPrice() * quantity; }
}

public class SupermarketBillingSystem {
    private Map<String, Product> inventory = new HashMap<>();
    private Map<String, Double> validCoupons = new HashMap<>(); // Coupon Code -> Discount Percentage
    public SupermarketBillingSystem() {
        // Initialize Coupons (e.g., "SAVE10" -> 10% off, "WELCOME20" -> 20% off)
        validCoupons.put("SAVE10", 10.0);
        validCoupons.put("WELCOME20", 20.0);
    }


    public void addOrUpdateProduct(String id, String name, double price, int stock) {
        if (inventory.containsKey(id)) {
            Product p = inventory.get(id);
            p.addStock(stock);
            System.out.println("✅ Updated stock for product: " + name);
        } else {
            inventory.put(id, new Product(id, name, price, stock));
            System.out.println("✅ Added new product: " + name);
        }
    }

    public void removeProduct(String id) {
        if (inventory.remove(id) != null) {
            System.out.println("🗑️ Product removed successfully.");
        } else {
            System.out.println("❌ Product ID not found.");
        }
    }

    public void displayLowStockProducts(int threshold) {
        System.out.println("\n⚠️ --- LOW STOCK ALERT (Threshold: " + threshold + ") ---");
        boolean found = false;
        for (Product p : inventory.values()) {
            if (p.getStockQuantity() <= threshold) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) System.out.println("All items are sufficiently stocked.");
        System.out.println("-----------------------------------------------\n");
    }

    public void processCheckout(List<CartItem> cart, String couponCode) {
        System.out.println("\n================= INVOICE =================");
        
        for (CartItem item : cart) {
            if (item.getQuantity() > item.getProduct().getStockQuantity()) {
                System.out.println("❌ Cannot process checkout! Insufficient stock for: " 
                                   + item.getProduct().getName());
                return;
            }
        }

        double subtotal = 0.0;

        for (CartItem item : cart) {
            double itemTotal = item.getTotalPrice();
            subtotal += itemTotal;
            
            // Deduct from stock
            item.getProduct().reduceStock(item.getQuantity());

            System.out.printf("%-15s x%d @ $%.2f = $%.2f\n", 
                              item.getProduct().getName(), 
                              item.getQuantity(), 
                              item.getProduct().getPrice(), 
                              itemTotal);
        }

        // 3. Apply Discount/Coupon
        double discountPercent = 0.0;
        if (couponCode != null && validCoupons.containsKey(couponCode.toUpperCase())) {
            discountPercent = validCoupons.get(couponCode.toUpperCase());
        }

        double discountAmount = subtotal * (discountPercent / 100.0);
        double finalTotal = subtotal - discountAmount;

        System.out.println("-------------------------------------------");
        System.out.printf("Subtotal:       $%.2f\n", subtotal);
        if (discountPercent > 0) {
            System.out.printf("Discount (%d%%): -$%.2f\n", (int) discountPercent, discountAmount);
        }
        System.out.printf("TOTAL AMOUNT:   $%.2f\n", finalTotal);
        System.out.println("===========================================\n");
    }

    // --- 3. Analytics ---

    public void displayAnalytics() {
        System.out.println("\n📊 --- SALES ANALYTICS ---");
        
        // Sort products by units sold (descending)
        List<Product> sortedProducts = new ArrayList<>(inventory.values());
        sortedProducts.sort((a, b) -> Integer.compare(b.getTotalSold(), a.getTotalSold()));

        System.out.println("Top Selling Products:");
        for (Product p : sortedProducts) {
            System.out.println(" - " + p.getName() + " | Units Sold: " + p.getTotalSold());
        }
        System.out.println("----------------------------\n");
    }

    // Main Test Execution
    public static void main(String[] args) {
        SupermarketBillingSystem system = new SupermarketBillingSystem();

        // 1. Add Products to Inventory
        system.addOrUpdateProduct("P001", "Milk (1L)", 2.50, 50);
        system.addOrUpdateProduct("P002", "Bread", 1.80, 20);
        system.addOrUpdateProduct("P003", "Eggs (12pk)", 3.20, 5); // Low stock item
        system.addOrUpdateProduct("P004", "Rice (5kg)", 12.00, 15);

        // 2. Customer Cart
        Product milk = system.inventory.get("P001");
        Product bread = system.inventory.get("P002");
        Product eggs = system.inventory.get("P003");

        List<CartItem> customerCart = new ArrayList<>();
        customerCart.add(new CartItem(milk, 2));
        customerCart.add(new CartItem(bread, 1));
        customerCart.add(new CartItem(eggs, 3));

        // 3. Process Billing with Coupon Code
        system.processCheckout(customerCart, "SAVE10");

        // 4. Low Stock Check
        system.displayLowStockProducts(5);

        // 5. Sales Analytics
        system.displayAnalytics();
    }
}