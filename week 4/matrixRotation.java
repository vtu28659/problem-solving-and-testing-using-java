import java.io.*;
import java.util.*;

public class MatrixRotation {

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();
        int numLayers = Math.min(m, n) / 2;

        for (int layer = 0; layer < numLayers; layer++) {
            List<Integer> ring = new ArrayList<>();
            for (int col = layer; col < n - layer; col++) ring.add(matrix.get(layer).get(col));
            for (int row = layer + 1; row < m - layer; row++) ring.add(matrix.get(row).get(n - 1 - layer));
            for (int col = n - 2 - layer; col >= layer; col--) ring.add(matrix.get(m - 1 - layer).get(col));
            for (int row = m - 2 - layer; row > layer; row--) ring.add(matrix.get(row).get(layer));

            int numElements = ring.size();
            int effectiveRotation = r % numElements;
            int idx = effectiveRotation;

            for (int col = layer; col < n - layer; col++) {
                matrix.get(layer).set(col, ring.get(idx));
                idx = (idx + 1) % numElements;
            }
            for (int row = layer + 1; row < m - layer; row++) {
                matrix.get(row).set(n - 1 - layer, ring.get(idx));
                idx = (idx + 1) % numElements;
            }
            for (int col = n - 2 - layer; col >= layer; col--) {
                matrix.get(m - 1 - layer).set(col, ring.get(idx));
                idx = (idx + 1) % numElements;
            }
            for (int row = m - 2 - layer; row > layer; row--) {
                matrix.get(row).set(layer, ring.get(idx));
                idx = (idx + 1) % numElements;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(matrix.get(i).get(j)).append(j == n - 1 ? "" : " ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int m = sc.nextInt();
        int n = sc.nextInt();
        int r = sc.nextInt();

        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(sc.nextInt());
            }
            matrix.add(row);
        }

        matrixRotation(matrix, r);
    }
}