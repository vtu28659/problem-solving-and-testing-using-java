import java.util.*;
public class SecondLowestGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] names = new String[n];
        double[] grades = new double[n];
        TreeSet<Double> uniqueGrades = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
            grades[i] = sc.nextDouble();
            uniqueGrades.add(grades[i]);
        }
        double secondLowest = uniqueGrades.toArray(new Double[0])[1];
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (grades[i] == secondLowest) {
                result.add(names[i]);
            }
        }
        Collections.sort(result);
        for (String name : result) {
            System.out.println(name);
        }
        sc.close();
    }
}
