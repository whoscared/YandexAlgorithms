package tasks.myrealization;

import java.util.ArrayList;
import java.util.List;

public class MyHashSet {
    private int size = 10;
    List<Integer>[] mySet = new ArrayList[size];

    public MyHashSet() {
        for (int i = 0; i < size; i++) {
            mySet[i] = new ArrayList<>();
        }
    }

    public void add(int x) {
        mySet[Math.abs(x % size)].add(x);
    }

    public boolean find(int x) {
        for (int current : mySet[Math.abs(x % size)]) {
            if (current == x) {
                return true;
            }
        }
        return false;
    }

    public void delete(int x) {
        mySet[Math.abs(x % size)].remove(Integer.valueOf(x));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            List<Integer> list = mySet[i];
            stringBuilder.append(i).append(" : ");
            stringBuilder.append(list.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

}
