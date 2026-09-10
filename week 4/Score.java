import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {
    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int aliceScore = 0;
        int bobScore = 0;

        for (int i = 0; i < 3; i++) {
            if (a.get(i) > b.get(i)) {
                aliceScore++;
            } else if (a.get(i) < b.get(i)) {
                bobScore++;
            }
        }

        return Arrays.asList(aliceScore, bobScore);
    }
}

public class Score {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter Alice's 3 ratings separated by space:");
        List<Integer> a = Stream.of(bufferedReader.readLine().trim().split("\\s+"))
            .map(Integer::parseInt)
            .collect(toList());

        System.out.println("Enter Bob's 3 ratings separated by space:");
        List<Integer> b = Stream.of(bufferedReader.readLine().trim().split("\\s+"))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.compareTriplets(a, b);

        System.out.println("Result (Alice Score, Bob Score):");
        System.out.println(result.get(0) + " " + result.get(1));

        bufferedReader.close();
    }
}