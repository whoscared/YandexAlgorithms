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

    public static void quickSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        if (array.length == 0) {
            return;
        }
        int middle = low + (high - low) / 2;
        int flag = array[middle];

        int i = low;
        int j = high;
        while (i <= j) {
            while (array[i] < flag) {
                i++;
            }
            while (array[j] > flag) {
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j) {
            quickSort(array, low, j);
        }
        if (high > i) {
            quickSort(array, i, high);
        }
    }
}
