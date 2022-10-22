package tasks.sort;

import java.util.Arrays;
import java.util.List;

public class NumbersSort {

    public static String countSort(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        List<Integer> sequence = Arrays.stream(s.split(" ")).map(Integer::parseInt).toList();
        int max = sequence.stream().max(Integer::compareTo).get();
        int[] array = new int[max + 1];
        for (int current : sequence) {
            array[current]++;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= max; i++) {
            while (array[i] > 0) {
                result.append(i).append(" ");
                array[i]--;
            }
        }
        return result.toString();
    }
}
