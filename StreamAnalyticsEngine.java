import java.util.*;
import java.util.stream.Collectors;

class SensorReading {
    private String sensorId;
    private double temperature;

    public SensorReading(String sensorId, double temperature) {
        this.sensorId = sensorId;
        this.temperature = temperature;
    }

    public String getSensorId() {
        return sensorId;
    }

    public double getTemperature() {
        return temperature;
    }
}

public class StreamAnalyticsEngine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        List<SensorReading> readings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String sensorId = scanner.next();
            double temperature = scanner.nextDouble();
            readings.add(new SensorReading(sensorId, temperature));
        }

        // Apply stream transformations:
        // 1. Filter temperatures > 50
        // 2. Group by sensor ID & compute average temperature per sensor
        // 3. Sort sensors based on average temperature in descending order
        readings.stream()
                .filter(r -> r.getTemperature() > 50)
                .collect(Collectors.groupingBy(
                        SensorReading::getSensorId,
                        Collectors.averagingDouble(SensorReading::getTemperature)
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));

        scanner.close();
    }
}