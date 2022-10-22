package tasks.sequence;

import java.util.*;
import java.util.stream.Collectors;

public class StringSequence {
    public static List<String> minString(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        List<String> sequence = Arrays.stream(s.split(" ")).toList();
        int minLength = sequence.get(0).length();
        for (String current : sequence) {
            if (current.length() < minLength) {
                minLength = current.length();
            }
        }
        int finalMinLength = minLength;
        return sequence.stream().filter(x -> x.length() == finalMinLength).toList();
    }

    public static Set<String> stringInDirectory(String directory, String s) {
        if ((s == null || s.isEmpty()) || (directory == null || directory.isEmpty())) {
            return null;
        }
        Set<String> ready = new HashSet<>();

        Set<String> directorySet = new HashSet<>();
        for (String current : Arrays.stream(directory.split(" ")).toList()) {
            directorySet.add(current);
            for (int i = 0; i < current.length(); i++) {
                directorySet.add(current.substring(0, i) + current.substring(i + 1));
            }
        }

        for (String current : Arrays.stream(s.split(" ")).toList()) {
            if (directorySet.contains(current)) {
                ready.add(current);
            }
        }
        return ready;
    }


}
