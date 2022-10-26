package tasks.homework;

import java.util.*;

public class Homework2 {

    public static int turtles(int countTurtles, int[][] count) {
        if (count.length > countTurtles) {
            return -1;
        }
        Set<Integer> ahead = new HashSet<>();
        int sum = 0;
        for (int[] x : count) {
            if (x[0] < 0 || x[1] < 0) {
                continue;
            }
            if (x[0] + x[1] == countTurtles - 1) {
                sum += ahead.contains(x[0]) ? 0 : 1;
                ahead.add(x[0]);
            }
        }
        return sum;
    }

    // d - погрешность
    // всего бегал t * n минут
    public static String manhattan(int minutes, int d, int n) {
        Scanner scanner = new Scanner(System.in);
        // MAX (x+y), MIN (x+y), MAX (x-y), MIN (x-y)
        int[] position = new int[4];
        while (n > 0) {
            //1 min = +1 distance
            Homework2.extend(position, minutes);
            int nX = scanner.nextInt();
            int nY = scanner.nextInt();
            int[] navigator = new int[]{nX + nY, nX + nY, nX - nY, nX - nY};
            Homework2.extend(navigator, d);
            Homework2.intersection(position, navigator);
            n--;
        }
        int x = 0;
        int y = 2;
        StringBuilder stringBuilder = new StringBuilder();
        while (x < 2) {
            while (y < 3) {
                if (position[x] + position[y] % 2 == 0) {
                    int i = (position[x] + position[y]) / 2;
                    int j = position[x] - i;
                    stringBuilder.append("[ ").append(i).append(",").append("j").append("]");
                }
                y++;
            }
            x++;
            y--;
        }
        return stringBuilder.toString();
    }

    //only for manhattan
    private static void extend(int[] position, int x) {
        position[0] += x;
        position[1] -= x;
        position[2] += x;
        position[3] -= x;
    }

    //only for manhattan
    private static void intersection(int[] pos, int[] nav) {
        pos[0] = Math.max(pos[0], nav[0]);
        pos[1] = Math.min(pos[1], nav[1]);
        pos[2] = Math.max(pos[2], nav[2]);
        pos[3] = Math.min(pos[3], nav[3]);
    }

    //
    //"abcbdbeeeebbcdbc"
    //"bcbd")
    public static int countWinS(String s, String w) {
        int[] arrayS = new int[26];
        int[] arrayW = new int[26];
        Homework2.setArray(s, arrayS, w.length());
        Homework2.setArray(w, arrayW, w.length());
        HashMap<Character, Integer> mapW = new HashMap<>();
        //HashMap<Character, Integer> mapW = new HashMap<>();

        Homework2.setHashMap(mapW, w);

        int countMatch = Homework2.haveMatchArray(arrayS, mapW);
        int sizeW = mapW.size();
        int count = countMatch == sizeW ? 1 : 0;

        for (int i = 1; i < s.length() - w.length(); i++) {

            char current = s.charAt(w.length() + i - 1);
            char previous = s.charAt(i - 1);

            countMatch += modificationArray(arrayS, mapW, current, 1);
            countMatch += modificationArray(arrayS, mapW, previous, -1);
            countMatch = Math.max(countMatch, 0);
            if (countMatch == sizeW) {
                count++;
            }
        }
        return count;
    }

    private static void setHashMap(HashMap<Character, Integer> wHash, String w) {
        for (int i = 0; i < w.length(); i++) {
            wHash.put(w.charAt(i), wHash.getOrDefault(w.charAt(i), 0) + 1);
        }
    }

    private static int haveMatchArray(int[] s, HashMap<Character, Integer> wHash) {
        int countMatch = 0;
        for (char c : wHash.keySet()) {
            countMatch += wHash.get(c) == s[c - 97] ? 1 : 0;
        }
        return countMatch;
    }

    private static void setArray(String s, int[] array, int count) {
        for (int i = 0; i < count; i++) {
            array[s.charAt(i) - 97] += 1;
        }
    }

    private static int modificationArray(int[] arrayS,
                                         HashMap<Character, Integer> wHash,
                                         char c,
                                         int operation) {
        int modif = 0;
        arrayS[c - 97] += operation;
        if (!(wHash.containsKey(c))) {
            return 0;
        }
        if (arrayS[c - 97] == wHash.get(c)) {
            modif += 1;
        } else {
            modif -= 1;
        }

        return modif;
    }

}
