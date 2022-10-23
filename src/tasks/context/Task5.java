package tasks.context;

import java.util.HashMap;
import java.util.Scanner;
//OK
public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        String second = scanner.nextLine();
        System.out.println(Task5.anagrams(first, second));
    }

    public static int anagrams(String f, String s) {
        if (f.length() != s.length()){
            return 0;
        }
        int[] symbols = new int[26];
        for (int i = 0; i < f.length(); i++) {
            symbols[f.charAt(i) - 97] += 1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (symbols[s.charAt(i) - 97] < 0){
                return 0;
            }
            symbols[s.charAt(i) - 97] -= 1;
        }
        for (int symbol : symbols) {
            if (symbol != 0) {
                return 0;
            }
        }
        return 1;
    }
}
