package leetcode;

import java.util.HashMap;

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

    public static int maximum69Number(int num) {
        if (num == 6) {
            return 9;
        }
        String numS = Integer.toString(num);
        int resultnum = 0;
        int size = numS.length() - 1;
        int current = num;
        boolean six = false;
        while (current > 0) {
            if ((int)(current / (int)Math.pow(10,size)) == 6 && !six) {
                resultnum += 9 * Math.pow(10, size);
                six = true;
            } else {
                resultnum += (int)(current / (int)Math.pow(10,size)) * Math.pow(10, size);
            }
            current -= (int)(current / (int)Math.pow(10,size)) * Math.pow(10, size);
            size--;
        }

/*        StringBuilder result = new StringBuilder();
        //boolean six = false;
        for (int i = 0; i < numS.length(); i++) {
            if (numS.charAt(i) == '6' && !six) {
                result.append("9");
                six = true;
            } else {
                result.append(numS.charAt(i));
            }
        }
        //return Integer.parseInt(result.toString());*/
        return resultnum;
    }
}
