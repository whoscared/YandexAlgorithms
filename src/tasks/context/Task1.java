package tasks.context;
import java.util.*;
import java.util.Scanner;
//OK
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String j = scanner.nextLine();
        String s = scanner.nextLine();
        System.out.println(Task1.context1(j,s));
    }

    public static int context1(String j, String s) {
        Set<Character> jSet = new HashSet<>();
        for (int i = 0; i< j.length(); i++ ){
            jSet.add(j.charAt(i));
        }
        int sum = 0;
        for (int i = 0; i<s.length(); i++) {
            sum += jSet.contains(s.charAt(i)) ? +1 : +0;
        }
        return sum;
    }
}
