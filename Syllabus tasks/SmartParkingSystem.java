import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
class Vehicle {
    private String licensePlate;
    private String type; // e.g., Car, Bike, Priority
    private LocalDateTime entryTime;

    public Vehicle(String licensePlate, String type) {
        this.licensePlate = licensePlate;
        this.type = type;
        this.entryTime = LocalDateTime.now();
    }

    public String getLicensePlate() { return licensePlate; }
    public String getType() { return type; }
    public LocalDateTime getEntryTime() { return entryTime; }
}
class ParkingSlot {
    private int level;
    private int slotNumber;
    private boolean isPriority;
    private Vehicle parkedVehicle;

    public ParkingSlot(int level, int slotNumber, boolean isPriority) {
        this.level = level;
        this.slotNumber = slotNumber;
        this.isPriority = isPriority;
        this.parkedVehicle = null;
    }

    public boolean isAvailable() { return parkedVehicle == null; }
    public void park(Vehicle v) { this.parkedVehicle = v; }
    public void unpark() { this.parkedVehicle = null; }

    public int getLevel() { return level; }
    public int getSlotNumber() { return slotNumber; }
    public boolean isPriority() { return isPriority; }
    public Vehicle getParkedVehicle() { return parkedVehicle; }

    @Override
    public String toString() {
        return "Level " + level + " - Slot " + slotNumber + (isPriority ? " [Priority]" : " [Standard]");
    }
}
public class SmartParkingSystem {
    private static final double HOURLY_RATE = 10.0; // $10 per hour
    private List<ParkingSlot> slots = new ArrayList<>();

    public SmartParkingSystem(int levels, int slotsPerLevel) {
        // Initialize multi-level parking lot
        for (int l = 1; l <= levels; l++) {
            for (int s = 1; s <= slotsPerLevel; s++) {
                // Designate slot 1 on each level as Priority
                boolean priority = (s == 1);
                slots.add(new ParkingSlot(l, s, priority));
            }
        }
    }
    public synchronized boolean parkVehicle(String licensePlate, String type, boolean isPriorityRequest) {
        for (ParkingSlot slot : slots) {
            if (slot.isAvailable()) {
                if (isPriorityRequest && slot.isPriority()) {
                    slot.park(new Vehicle(licensePlate, type));
                    System.out.println("✅ Vehicle " + licensePlate + " parked at Priority Slot: " + slot);
                    return true;
                } else if (!isPriorityRequest && !slot.isPriority()) {
                    slot.park(new Vehicle(licensePlate, type));
                    System.out.println("✅ Vehicle " + licensePlate + " parked at Standard Slot: " + slot);
                    return true;
                }
            }
        }
        for (ParkingSlot slot : slots) {
            if (slot.isAvailable()) {
                slot.park(new Vehicle(licensePlate, type));
                System.out.println("✅ Vehicle " + licensePlate + " parked at: " + slot);
                return true;
            }
        }

        System.out.println("❌ Parking Full! No available slots for vehicle: " + licensePlate);
        return false;
    }
    public synchronized void exitVehicle(String licensePlate) {
        for (ParkingSlot slot : slots) {
            if (!slot.isAvailable() && slot.getParkedVehicle().getLicensePlate().equalsIgnoreCase(licensePlate)) {
                Vehicle v = slot.getParkedVehicle();
                LocalDateTime exitTime = LocalDateTime.now();
                
                // Calculate fee (minimum 1 hour charge)
                long hours = Math.max(1, Duration.between(v.getEntryTime(), exitTime).toHours());
                double totalFee = hours * HOURLY_RATE;

                slot.unpark();
                System.out.println("\n--- Vehicle Exit Receipt ---");
                System.out.println("License Plate : " + v.getLicensePlate());
                System.out.println("Freed Slot    : Level " + slot.getLevel() + ", Slot " + slot.getSlotNumber());
                System.out.println("Duration      : " + hours + " hour(s)");
                System.out.println("Total Fee     : $" + totalFee);
                System.out.println("----------------------------\n");
                return;
            }
        }
        System.out.println("❌ Vehicle with license plate " + licensePlate + " not found.");
    }
    public void generateReport() {
        System.out.println("\n========== PARKING STATUS REPORT ==========");
        int occupied = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        for (ParkingSlot slot : slots) {
            if (!slot.isAvailable()) {
                occupied++;
                Vehicle v = slot.getParkedVehicle();
                System.out.println(slot + " -> Occupied by: " + v.getLicensePlate() + 
                                   " (" + v.getType() + ") | Entry: " + v.getEntryTime().format(formatter));
            } else {
                System.out.println(slot + " -> [VACANT]");
            }
        }
        System.out.println("\nTotal Occupied: " + occupied + " / " + slots.size());
        System.out.println("===========================================\n");
    }

    public static void main(String[] args) {
        SmartParkingSystem parkingLot = new SmartParkingSystem(2, 3);

        parkingLot.parkVehicle("KA-01-AB-1234", "Car", false);
        parkingLot.parkVehicle("VIP-001", "SUV", true); // Priority entry
        parkingLot.parkVehicle("KA-02-CD-5678", "Bike", false);

        parkingLot.generateReport();

        parkingLot.exitVehicle("KA-01-AB-1234");

        parkingLot.generateReport();
    }
}