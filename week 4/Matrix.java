import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Matrix {

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();
        int numRings = Math.min(m, n) / 2;
        
        int[][] result = new int[m][n];
        
        for (int layer = 0; layer < numRings; layer++) {
            List<Integer> ring = new ArrayList<>();
            
            // 1. Top row (left to right)
            for (int col = layer; col < n - layer; col++) {
                ring.add(matrix.get(layer).get(col));
            }
            // 2. Right column (top to bottom)
            for (int row = layer + 1; row < m - layer - 1; row++) {
                ring.add(matrix.get(row).get(n - layer - 1));
            }
            // 3. Bottom row (right to left)
            for (int col = n - layer - 1; col >= layer; col--) {
                ring.add(matrix.get(m - layer - 1).get(col));
            }
            // 4. Left column (bottom to top)
            for (int row = m - layer - 2; row > layer; row--) {
                ring.add(matrix.get(row).get(layer));
            }
            
            int numElements = ring.size();
            int effectiveRotation = r % numElements;
            int idx = effectiveRotation;
            
            // Re-insert rotated elements back into result matrix
            for (int col = layer; col < n - layer; col++) {
                result[layer][col] = ring.get(idx);
                idx = (idx + 1) % numElements;
            }
            for (int row = layer + 1; row < m - layer - 1; row++) {
                result[row][n - layer - 1] = ring.get(idx);
                idx = (idx + 1) % numElements;
            }
            for (int col = n - layer - 1; col >= layer; col--) {
                result[m - layer - 1][col] = ring.get(idx);
                idx = (idx + 1) % numElements;
            }
            for (int row = m - layer - 2; row > layer; row--) {
                result[row][layer] = ring.get(idx);
                idx = (idx + 1) % numElements;
            }
        }
        
        // Print output matrix
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(result[i][j]).append(j == n - 1 ? "" : " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);
        int n = Integer.parseInt(firstMultipleInput[1]);
        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        matrixRotation(matrix, r);

        bufferedReader.close();
    }
}