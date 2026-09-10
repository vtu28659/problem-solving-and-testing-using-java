import java.util.*;

public class FindAndReplacePatternSolution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean matches(String word, String pattern) {
        Map<Character, Character> w2p = new HashMap<>();
        Map<Character, Character> p2w = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);

            if (!w2p.containsKey(w)) {
                w2p.put(w, p);
            }
            if (!p2w.containsKey(p)) {
                p2w.put(p, w);
            }

            if (w2p.get(w) != p || p2w.get(p) != w) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        FindAndReplacePatternSolution solver = new FindAndReplacePatternSolution();

        String[] words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern = "abb";

        List<String> result = solver.findAndReplacePattern(words, pattern);
        System.out.println("Output: " + result);
    }
}