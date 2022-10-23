package tasks.homework;

import tasks.sort.NumbersSort;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Homework {
    public static boolean castle(int[] hole, int[] brick) {
        if (hole == null || brick == null
                || hole.length != 2 || brick.length != 3) {
            throw new NoSuchElementException();
        }
        Arrays.sort(hole);
        Arrays.sort(brick);
        return hole[0] >= brick[0] && hole[1] >= brick[1];
    }

    // interval > 1
    public static int[] subway(int intervalA, int intervalB, int countA, int countB) {
        int minTime = Math.max(countA + intervalA * (countA - 1),
                countB + intervalB * (countB - 1));
        int maxTime = Math.min(countA + intervalA * (countA + 1),
                countB + intervalB * (countB + 1));
        if (maxTime < minTime) {
            return null;
        }
        return new int[]{minTime, maxTime};
    }

    //Найти ПОДЪЕЗД, ЭТАЖ квартиры К1
    //К2 - квартира этого дома, которая находится на Р этаже, N подъезд
    // M - количество этажей
    public static int[] searchHome(int k1, int k2, int pod, int eta, int m) {
        //Смотрим сколько этажей в доме до квартиры 2
        int countBlock = m * (pod - 1) + eta;

        while (k2 % countBlock != 0) {
            k2++;
        }

        int countOnBlock = k2 / countBlock;

        int p1 = k1 / (m * countOnBlock);
        p1 += k1 % (m * countOnBlock) != 0 ? 1 : 0;

        int n1 = k1 / countOnBlock;
        n1 += k1 % countOnBlock != 0 ? 1 : 0;

        return new int[]{p1, n1};
    }

    // 1 2 3 2 1
    public static boolean symmetricalSequence(String s) {
        Integer[] arrayOfSequence = Arrays.stream(s.split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        int size = arrayOfSequence.length;
        for (int i = 0, j = size - 1; i <= size / 2 && j >= size / 2; i++, j--) {
            if (!Objects.equals(arrayOfSequence[i], arrayOfSequence[j])) {
                return false;
            }
        }
        return true;
    }

    // 1 2 3 4 5 4 3 => 1 2 3 4 5 4 3 (2 1)
    // 1 2 3 4 5 4 4 2 2 => 1 2 3 4 5 4 4 2 2 ( 4 4 5 4 3 2 1)
    public static String doSymmetricalSequence(String s) {
        Integer[] arrayOfSequence = Arrays.stream(s.split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        int size = arrayOfSequence.length;
        int countStart = 0;
        for (int i = 0, j = size - 1; i <= j; ) {
            if (!Objects.equals(arrayOfSequence[i], arrayOfSequence[j])) {
                i++;
                countStart = i;
                j = size - 1;
            } else {
                i++;
                j--;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s);
        for (int i = countStart - 1; i >= 0; i--) {
            stringBuilder.append(" ").append(arrayOfSequence[i]);
        }
        return stringBuilder.toString();
    }

    public static int maxMultiplication(String s) {
        int[] sequence = Arrays.stream(s.split(" ")).map(Integer::parseInt).mapToInt(x -> x).toArray();

        int size = sequence.length;

        if (size == 3) {
            return Arrays.stream(sequence).reduce((x, y) -> x * y).orElse(-1);
        }
        NumbersSort.quickSort(sequence, 0, size - 1);
        return Math.max((sequence[0] * sequence[1] * sequence[size - 1]),
                sequence[size - 1] * sequence[size - 2] * sequence[size - 3]);
    }

    public static int[][] sapper(int i, int j, int[][] mines) {
        int[][] playingField = new int[i + 2][j + 2];
        int[] neighborI = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
        int[] neighborJ = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
        for (int[] mine : mines) {
            int count = 0;
            while (count < neighborI.length) {
                playingField[mine[0] + 1 + neighborI[count]][mine[1] + 1 + neighborJ[count]] += 1;
                count++;
            }
        }
        int[][] ready = new int[i][j];
        for (int x = 0; x < i; x++) {
            System.arraycopy(playingField[x + 1], 1, ready[x], 0, j);
        }
        for (int[] mine : mines) {
            ready[mine[0]][mine[1]] = 0;
        }
        return ready;
    }

}

