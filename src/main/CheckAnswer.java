package main;

import tasks.homework.Homework2;
import tasks.search.BinarySearch;

public class CheckAnswer {
    public static void main(String[] args) {
        /*
        int[][] sapper = Homework.sapper(5, 5, new int[][]{{2, 1}, {0, 3}, {3, 2}});
        StringBuilder stringBuilder = new StringBuilder();
        for (int[] ints : sapper) {
            for (int anInt : ints) {
                stringBuilder.append(anInt).append(" ");
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
        */
        //System.out.println(Homework2.turtles(8, new int[][]{{1,6}, {1,8}, {1,6}, {4,3},{7,0}}));
        System.out.println(Homework2.countWinS("abcbdbeeeebbcdbc", "bcbd"));
    }
}
