package tasks.context;

import java.util.Scanner;
//OK
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] sequence =new int[size];
        for ( int i = 0; i< size; i++){
            sequence[i] = scanner.nextInt();
        }
        System.out.println(Task2.findMax(sequence));
    }

    public static int[] prefixVector(int[] sequence) {
        int[] prefix = new int[sequence.length + 1];
        for (int i = 0; i < sequence.length; i++) {
            prefix[i + 1] = sequence[i] == 1 ? prefix[i] + 1 : 0;
        }
        return prefix;
    }

    public static int findMax(int[] sequence) {
        int[] prefix = prefixVector(sequence);
        int max = prefix[0];
        for (int x : prefix) {
            max = Math.max(x, max);
        }
        return max;
    }
}
