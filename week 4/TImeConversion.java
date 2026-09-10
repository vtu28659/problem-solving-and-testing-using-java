import java.io.*;

class Result {
    public static String timeConversion(String s) {
        String amPm = s.substring(s.length() - 2);
        int hour = Integer.parseInt(s.substring(0, 2));
        String rest = s.substring(2, s.length() - 2);

        if (amPm.equals("AM")) {
            if (hour == 12) {
                hour = 0;
            }
        } else {
            if (hour != 12) {
                hour += 12;
            }
        }

        return String.format("%02d%s", hour, rest);
    }
}

public class TimeConversion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();
        String result = Result.timeConversion(s);

        System.out.println(result);

        bufferedReader.close();
    }
}