package leetcode;

import java.math.MathContext;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//abcabcbb
public class LeetCode {
    public static int LongestSubstringWithoutRepeatingCharacters(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        HashMap<Character, Integer> symbolAndIndex = new HashMap<>();
        int low = 0;
        int high = 0;
        int best = 0;
        while (high < s.length()) {
            Integer previous = symbolAndIndex.get(s.charAt(high));
            // previous >= low for check what we are watching this symbol
            // 0 1 2 3 4   5 6 7 8 9 10
            // b a c b d [ d e r f b a ] in this example high = 10 low = 5 previous = 1
            if (previous != null && previous >= low) {
                low = previous + 1;
            }
            symbolAndIndex.put(s.charAt(high), high);
            best = Math.max(high - low + 1, best);
            high++;
        }
        return best;
    }
}
