package tasks.sequence;

import tasks.prefix.Prefix;

import java.util.*;

public class NumericalSequence {

    public static int summa(String s) {
        if (s == null) {
            return -1;
        }
        List<Integer> sequence = Arrays.stream(s.split(" ")).map(Integer::parseInt).toList();
        return sequence.isEmpty() ? 0 : sequence.stream().reduce(Integer::sum).get();
    }

    public static int max(String s) {
        if (s == null) {
            return Integer.MAX_VALUE;
        }
        List<Integer> sequence = Arrays.stream(s.split(" ")).map(Integer::parseInt).toList();
        return sequence.isEmpty() ? Integer.MAX_VALUE : sequence.stream().reduce(Math::max).get();
    }

    public static int positiveFirst(String s) {
        if (s == null) {
            return -1;
        }
        List<Integer> sequence = Arrays.stream(s.split(" ")).map(Integer::parseInt).toList();
        return sequence.isEmpty() ? -1 : sequence.stream().filter(x -> x > 0).findFirst().orElse(-1);
    }

    public static int find(String s, int x) {
        if (s == null) {
            return -1;
        }
        List<Integer> sequence = Arrays.stream(s.split(" ")).map(Integer::parseInt).toList();
        return sequence.isEmpty() ? -1 : sequence.stream().filter(c -> c == x).findFirst().orElse(-1);
    }

    public static int[] twoMax(String s) {
        if (s == null) {
            return null;
        }
        List<Integer> sequence = Arrays.stream(s.split(" ")).map(Integer::parseInt).toList();
        int max1 = Math.max(sequence.get(0), sequence.get(1));
        int max2 = Math.min(sequence.get(0), sequence.get(1));
        if (sequence.size() == 2) {
            return new int[]{max1, max2};
        }
        for (int i = 2; i < sequence.size(); i++) {
            int current = sequence.get(i);
            if (current > max1) {
                max2 = max1;
                max1 = current;
            } else if (current > max2) {
                max2 = current;
            }
        }
        return new int[]{max1, max2};
    }

    public static int minEven(String s) {
        if (s == null) {
            return -1;
        }
        List<Integer> sequence = Arrays.stream(s.split(" ")).map(Integer::parseInt).toList();
        int result = -1;
        for (int current : sequence) {
            if (current % 2 == 0 && (result == -1 || result > current)) {
                result = current;
            }
        }
        return result;
    }

    public static int[] searchSum(String s, int sum) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        List<Integer> sequence = Arrays.stream(s.split(" ")).map(Integer::parseInt).toList();
        Set<Integer> integerSet = new HashSet<>();
        for (int current : sequence) {
            if (integerSet.contains(sum - current)) {
                return new int[]{current, sum - current};
            }
            integerSet.add(current);
        }
        return new int[]{0, 0};
    }

    //Можно ли получить одно число из другого, если переставить цифры?
    public static boolean twoNumbers(int a, int b) {
        HashMap<Integer, Integer> numbers = new HashMap<>();
        int current = a;
        while (current > 0) {
            numbers.put(current % 10, numbers.getOrDefault(current % 10, 0) + 1);
            current /= 10;
        }
        current = b;
        while (current > 0) {
            numbers.put(current % 10, numbers.getOrDefault(current % 10, 0) - 1);
            current /= 10;
        }
        return numbers.values().stream().noneMatch(x -> x != 0);
    }

    public static int countOfPair(String s, int k) {
        int[] sequence = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        int count = 0;
        int last = 1;
        for (int i = 0; last < sequence.length; i++) {
            while (last < sequence.length && sequence[last] - sequence[i] <= k) {
                last++;
            }
            count += sequence.length - last;
        }
        return count;
    }

    public static int maxProfessionalism(String s) {
        int[] sequence = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        int best = 0;
        int last = sequence.length - 1;
        for (int first = 0; first < sequence.length - 1; first++) {
            while (sequence[first] + sequence[first + 1] < sequence[last]) {
                last--;
            }
            int current = Prefix.sumOfRange(s, first + 1, last + 2);
            best = Math.max(current, best);
            last = sequence.length - 1;
        }
        return best;
    }

    public static String merge(String first, String second) {
        int[] firstSequence = Arrays.stream(first.split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] secondSequence = Arrays.stream(second.split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] result = new int[firstSequence.length + secondSequence.length];
        int i = 0, j = 0;
        for (int temp = 0; temp < result.length; temp++) {
            if (j == secondSequence.length || firstSequence[i] <= secondSequence[j]) {
                result[temp] = firstSequence[i];
                i++;
            } else {
                result[temp] = secondSequence[j];
                j++;
            }
        }
        return Arrays.toString(result);
    }
}
