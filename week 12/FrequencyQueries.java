import java.util.*;
public class FrequencyQueries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        HashMap<Integer, Integer> frequency = new HashMap<>();
        HashMap<Integer, Integer> frequencyCount = new HashMap<>();
        for (int i = 0; i < q; i++) {
            int operation = sc.nextInt();
            int x = sc.nextInt();
            if (operation == 1) {
                int oldFreq = frequency.getOrDefault(x, 0);
                int newFreq = oldFreq + 1;
                frequency.put(x, newFreq);
                if (oldFreq > 0) {
                    frequencyCount.put(oldFreq,
                        frequencyCount.get(oldFreq) - 1);
                }
                frequencyCount.put(newFreq,
                    frequencyCount.getOrDefault(newFreq, 0) + 1);
            } else if (operation == 2) {
                int oldFreq = frequency.getOrDefault(x, 0);
                if (oldFreq > 0) {
                    frequency.put(x, oldFreq - 1);
                    frequencyCount.put(oldFreq,
                        frequencyCount.get(oldFreq) - 1);
                    if (oldFreq > 1) {
                        frequencyCount.put(oldFreq - 1,
                            frequencyCount.getOrDefault(oldFreq - 1, 0) + 1);
                    }
                }
            } else if (operation == 3) {
                System.out.println(
                    frequencyCount.getOrDefault(x, 0) > 0 ? 1 : 0
                );
            }
        }
        sc.close();
    }
}
