import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {
    private Map<Integer, CheckInInfo> checkIns;
    private Map<String, RouteInfo> routeStats;

    private static class CheckInInfo {
        String stationName;
        int time;

        CheckInInfo(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }

    private static class RouteInfo {
        double totalTime;
        int count;

        RouteInfo(double totalTime, int count) {
            this.totalTime = totalTime;
            this.count = count;
        }
    }

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        routeStats = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInInfo(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckInInfo info = checkIns.remove(id);
        String routeKey = info.stationName + "->" + stationName;
        int duration = t - info.time;

        RouteInfo stats = routeStats.getOrDefault(routeKey, new RouteInfo(0, 0));
        stats.totalTime += duration;
        stats.count += 1;
        routeStats.put(routeKey, stats);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        RouteInfo stats = routeStats.get(routeKey);
        return stats.totalTime / stats.count;
    }

    // Main method added to execute in CMD
    public static void main(String[] args) {
        UndergroundSystem system = new UndergroundSystem();
        
        system.checkIn(45, "Leyton", 3);
        system.checkIn(32, "Paradise", 8);
        system.checkIn(27, "Leyton", 10);
        system.checkOut(45, "Waterloo", 15);
        system.checkOut(27, "Waterloo", 20);
        system.checkOut(32, "Cambridge", 22);
        
        System.out.println("Average Leyton to Waterloo: " + system.getAverageTime("Leyton", "Waterloo"));
    }
}