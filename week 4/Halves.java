public class Halves {
    public static void main(String[] args) {
        Halves sol = new Halves();

      
        String[] testCases = {"book", "textbook", "MerryChristmas", "AbCdEfGh"};

        for (String s : testCases) {
            boolean result = sol.halvesAreAlike(s);
            System.out.println("Input: \"" + s + "\" -> Halves Are Alike: " + result);
        }
    }

    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int leftVowels = 0;
        int rightVowels = 0;

        for (int i = 0; i < n / 2; i++) {
            if (isVowel(s.charAt(i))) {
                leftVowels++;
            }
            if (isVowel(s.charAt(i + n / 2))) {
                rightVowels++;
            }
        }

        return leftVowels == rightVowels;
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}