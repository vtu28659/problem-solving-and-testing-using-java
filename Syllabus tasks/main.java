import java.util.Scanner;

// Base Vehicle Class
abstract class Vehicle {
    protected String type;
    
    public Vehicle(String type) {
        this.type = type;
    }

    public abstract double calculateFare(double distance);
}

// Derived Bike Class
class Bike extends Vehicle {
    private static final double RATE_PER_KM = 5.0;

    public Bike() {
        super("Bike");
    }

    @Override
    public double calculateFare(double distance) {
        return distance * RATE_PER_KM;
    }
}

// Derived Cab Class
class Cab extends Vehicle {
    private static final double RATE_PER_KM = 12.0;

    public Cab() {
        super("Cab");
    }

    @Override
    public double calculateFare(double distance) {
        return distance * RATE_PER_KM;
    }
}

// Derived Auto Class
class Auto extends Vehicle {
    private static final double RATE_PER_KM = 12.0;

    public Auto() {
        super("Auto");
    }

    @Override
    public double calculateFare(double distance) {
        return distance * RATE_PER_KM;
    }
}

// Factory Class to handle polymorphic instantiation & validation
class RideFactory {
    public static Vehicle createRide(String rideType) throws IllegalArgumentException {
        if (rideType.equalsIgnoreCase("Bike")) {
            return new Bike();
        } else if (rideType.equalsIgnoreCase("Cab")) {
            return new Cab();
        } else if (rideType.equalsIgnoreCase("Auto")) {
            return new Auto();
        } else {
            throw new IllegalArgumentException("Invalid ride type: " + rideType);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();

            try {
                if (distance < 0) {
                    throw new IllegalArgumentException("Distance cannot be negative");
                }
                
                Vehicle vehicle = RideFactory.createRide(type);
                long fare = (long) vehicle.calculateFare(distance);
                System.out.println(fare);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        sc.close();
    }
}