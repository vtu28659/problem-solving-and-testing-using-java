import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    public static int birthday(List<Integer> s, int d, int m) {
        int count = 0;
        
        if (s.size() < m) {
            return 0;
        }

        int currentSum = 0;
        for (int i = 0; i < m; i++) {
            currentSum += s.get(i);
        }

        if (currentSum == d) {
            count++;
        }

        for (int i = m; i < s.size(); i++) {
            currentSum += s.get(i) - s.get(i - m);
            if (currentSum == d) {
                count++;
            }
        }

        return count;
    }

}

public class SubarrayDivision {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter number of squares (n): ");
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        System.out.print("Enter " + n + " space-separated integers for s: ");
        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        System.out.print("Enter d and m (space-separated): ");
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(firstMultipleInput[0]);
        int m = Integer.parseInt(firstMultipleInput[1]);

        int result = Result.birthday(s, d, m);

        System.out.println("Result: " + result);

        bufferedReader.close();
    }
}