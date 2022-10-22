package tasks.homework;

import java.util.Arrays;
import java.util.NoSuchElementException;

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
}

