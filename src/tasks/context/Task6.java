package tasks.context;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// not ready yet
public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfTown = scanner.nextInt();
        int[][] coordinates = new int[countOfTown][2];
        for (int i =0; i < countOfTown; i++){
            coordinates[i][0]= scanner.nextInt();
            coordinates[i][1]= scanner.nextInt();
        }
        int distance = scanner.nextInt();
        int from = scanner.nextInt();
        int to = scanner.nextInt();
        System.out.println(minRoads(coordinates, distance,from,to));
    }
    public static int minRoads (int[][] coordinates, int distance, int from, int to){
        List<Integer> goodTower = new ArrayList<>();

        return 0;
    }
}
