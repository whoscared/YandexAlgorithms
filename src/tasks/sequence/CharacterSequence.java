package tasks.lecture1;

import java.util.HashMap;

public class CharacterSequence {
    public static int frequentSymbolCount(String s) {
        if (s == null) {
            return -1;
        }
        HashMap<Character, Integer> symbols = new HashMap<>();
        int maxCount = 0;
        for (int i = 0; i < s.length(); i++) {
            symbols.put(s.charAt(i), symbols.getOrDefault(s.charAt(i), 0) + 1);
            if (symbols.get(s.charAt(i)) > maxCount) {
                maxCount = symbols.get(s.charAt(i));
            }
        }
        return maxCount;
    }

    public static Character frequentSymbol(String s) {
        if (s == null) {
            return null;
        }
        HashMap<Character, Integer> symbols = new HashMap<>();
        int maxCount = 0;
        Character maxChar = null;
        for (int i = 0; i < s.length(); i++) {
            symbols.put(s.charAt(i), symbols.getOrDefault(s.charAt(i), 0) + 1);
            if (symbols.get(s.charAt(i)) > maxCount) {
                maxCount = symbols.get(s.charAt(i));
                maxChar = s.charAt(i);
            }
        }
        return maxChar;
    }

    public static String countCharacter(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        char previous = s.charAt(0);
        int count = 1;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(previous);
        for (int i = 1; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == previous) {
                count++;
            } else {
                stringBuilder.append(count).append(current);
                previous = current;
                count = 1;
            }
        }
        stringBuilder.append(count);
        return stringBuilder.toString();
    }
}
