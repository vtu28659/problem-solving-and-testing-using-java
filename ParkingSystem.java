class ParkingSystem {
    private int[] count;

    public ParkingSystem(int big, int medium, int small) {
        // Map car types 1, 2, 3 to index 0, 1, 2
        count = new int[]{big, medium, small};
    }
    
    public boolean addCar(int carType) {
        // Check if slots are available for the requested carType (1-indexed)
        if (count[carType - 1] > 0) {
            count[carType - 1]--;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // Initialize with 1 big, 1 medium, and 0 small slots
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);

        System.out.println(parkingSystem.addCar(1)); // Output: true
        System.out.println(parkingSystem.addCar(2)); // Output: true
        System.out.println(parkingSystem.addCar(3)); // Output: false
        System.out.println(parkingSystem.addCar(1)); // Output: false
    }
}