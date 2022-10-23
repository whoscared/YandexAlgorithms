package tasks.context;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
// WA 185 test
public class Task3 {public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    long size = scanner.nextLong();
    Set<Long> newSet = new HashSet<>();
    for ( long i = 0; i < size; i++){
        newSet.add(scanner.nextLong());
    }
    for (long l : newSet){
        System.out.println(l);
    }
}
}
