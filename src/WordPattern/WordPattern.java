package WordPattern;



import java.util.HashMap;
import java.util.Map;

/**
 * Created by namrataojha on 5/13/16.
 * Problem
 Given a pattern and a string str, find if str follows the same pattern.

 Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

 Examples:
 pattern = "abba", str = "dog cat cat dog" should return true.
 pattern = "abba", str = "dog cat cat fish" should return false.
 pattern = "aaaa", str = "dog cat cat dog" should return false.
 pattern = "abba", str = "dog dog dog dog" should return false.
 Notes: You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */
public class WordPattern {

        public boolean wordPattern(String pattern, String str) {
            if (pattern == null || pattern.length() == 0 || str == null || str.length() == 0) {
                return false;
            }

            String[] tokens = str.split(" ");

            if (pattern.length() != tokens.length) {
                return false;
            }

            Map<String, Character> inverseMap = new HashMap<>();
            Map<Character, String> map = new HashMap();

            int i = 0;
            for (i = 0; i < pattern.length(); i++) {
                char digit = pattern.charAt(i);

                String token = tokens[i];

                // Check the one-one mapping
                if (!map.containsKey(digit) && !inverseMap.containsKey(token)) {
                    map.put(digit, token);
                    inverseMap.put(token, digit);
                } else if (map.containsKey(digit) && inverseMap.containsKey(token)) {
                    String token1 = map.get(digit);
                    char digit1 = inverseMap.get(token);

                    if (!token1.equals(token) || digit != digit1) {
                        return false;
                    }
                } else {
                    return false;
                }
            }

            return true;
        }


    public static void main(String[] args) {
        WordPattern w = new WordPattern();
        System.out.println(w.wordPattern("abba","dog cat cat dog"));

    }
}
