package main;

import tasks.homework.Homework;

import java.util.Arrays;

public class CheckAnswer {
    public static void main(String[] args) {
        System.out.println(Homework.maxMultiplication("3 1 5"));
        int[][] sapper = Homework.sapper(5, 5, new int[][]{{2, 1}, {0, 3}, {3, 2}});
        StringBuilder stringBuilder = new StringBuilder();
        for (int[] ints : sapper) {
            for (int anInt : ints) {
                stringBuilder.append(anInt).append(" ");
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
        //System.out.println(Arrays.toString(Homework.sapper(5,5,new int[][]{{1,2}, {3,0}})));


    }
}
