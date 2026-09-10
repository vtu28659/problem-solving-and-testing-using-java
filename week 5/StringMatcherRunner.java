import java.util.ArrayList;
import java.util.List;

public class StringMatcherRunner {
    public static List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i])) {
                    result.add(words[i]);
                    break; // Avoid adding duplicate entries for words[i]
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"mass", "as", "hero", "superhero"};
        List<String> result = stringMatching(words);
        System.out.println(result);
    }
}