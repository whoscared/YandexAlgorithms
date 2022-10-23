package tasks.prefix;

import java.util.Arrays;
import java.util.HashMap;

public class Prefix {

    public static int[] prefixSumArray(String s) {
        int[] array = Arrays.stream(s.split(" ")).map(Integer::parseInt).mapToInt(x -> x).toArray();
        int[] prefixSum = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + array[i];
        }
        return prefixSum;
    }

    public static int[] prefixSumArray(int[] array) {
        int[] prefixSum = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + array[i];
        }
        return prefixSum;
    }

    public static int sumOfRange(String s, int start, int end) {
        int[] prefixSum = prefixSumArray(s);
        return prefixSum[end - 1] - prefixSum[start - 1];
    }

    private static int[] prefixZeroArray(String s) {
        int[] array = Arrays.stream(s.split(" ")).map(Integer::parseInt).mapToInt(x -> x).toArray();
        int[] prefixZero = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            prefixZero[i + 1] = array[i] == 0 ? prefixZero[i] + 1 : prefixZero[i];
        }
        return prefixZero;
    }

    public static int countOfZero(String s, int start, int end) {
        int[] prefixZero = prefixZeroArray(s);
        return prefixZero[end - 1] - prefixZero[start - 1];
    }

    public static int countSumZero(String s) {
        int[] prefixSum = prefixSumArray(s);
        HashMap<Integer, Integer> countOfSum = new HashMap<>();
        for (int j : prefixSum) {
            countOfSum.put(j, countOfSum.getOrDefault(j, 0) + 1);
        }
        return countOfSum.values().stream().filter(x -> x>1).mapToInt(x -> x-1).sum();

    }
}
