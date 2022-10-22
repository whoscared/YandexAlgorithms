package tasks.chess;

import java.util.HashMap;
import java.util.List;

public class Chess {

    //Сколько пар ладьей бьют друг друга? Ладья задается парой чисел [x,y]
    // 1,2 x-horizontal , y - vertical
    // 2,3
    // 10,10
    public static int rook(int[][] rooks) {
        HashMap<Integer, Integer> horizontal = new HashMap<>();
        HashMap<Integer, Integer> vertical = new HashMap<>();
        for (int[] rook : rooks) {
            horizontal.put(rook[0], horizontal.getOrDefault(rook[0], 0) + 1);
            vertical.put(rook[1], vertical.getOrDefault(rook[1], 0) + 1);
        }
        int result = 0;
        result += horizontal.values().stream()
                .filter(x -> x > 1)
                .map(x -> x - 1)
                .reduce(Integer::sum).orElse(0);

        result += vertical.values().stream().
                filter(x -> x > 1).
                map(x -> x - 1).
                reduce(Integer::sum).orElse(0);

        return result;
    }
}
