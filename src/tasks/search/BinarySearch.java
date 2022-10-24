package tasks.search;

public class BinarySearch {

    public static int binarySearch(int[] sequence, int left, int right, int element) {
        if (left > right || right > sequence.length) {
            return -1;
        }
        int middle = left + (right - left) / 2;
        int index = middle;
        if (sequence[middle] > element) {
            index = BinarySearch.binarySearch(sequence, left, middle - 1, element);
        }
        if (sequence[middle] < element) {
            index = BinarySearch.binarySearch(sequence, middle + 1, right, element);
        }
        return index;
    }


    public static int binarySearchMax(int[] sequence, int left, int right, int element) {
        if (left == right) {
            return right;
        }
        if (right > sequence.length) {
            return sequence.length - 1;
        }
        int middle = left + (right - left) / 2;
        int index = middle;
        if (sequence[middle] > element) {
            index = BinarySearch.binarySearchMax(sequence, left, middle, element);
        }
        if (sequence[middle] < element) {
            index = BinarySearch.binarySearchMax(sequence, middle + 1, right, element);
        }
        return index;
    }


    public static int binarySearchRight(int[] sequence, int x) {
        if (sequence.length == 0){
            return 0;
        }
        int left = 0;
        int right = sequence.length - 1;
        while (sequence[right] != x) {
            int middle = (left + right) / 2;
            if (sequence[middle] > x) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return right;
    }

    public static int binarySearchLeft(int[] sequence, int x) {
        if (sequence.length == 0){
            return 0;
        }
        int left = 0;
        int right = sequence.length - 1;
        while (sequence[left] != x) {
            int middle = (left + right) / 2;
            if (sequence[middle] >= x) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    public static int countOfX(int[] sequence, int x) {
        if (sequence.length == 0){
            return 0;
        }
        int right = BinarySearch.binarySearchRight(sequence, x);
        int left = BinarySearch.binarySearchLeft(sequence, x);
        return (right - left) + 1;
    }

    private static int find(int[] sequence, int x) {
        return 0;
    }


    //for parentsCount return (+) count of parents

    //for taskCount return (+) day for tasks
    //yandex, why we can not just return n-k?
    public static int leftBinarySearch(int n, int k) {
        int left = 0;
        int right = n;
        while (left < right) {
            int middle = (left + right) / 2;
            if (BinarySearch.tasksCount(n, k, middle)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    //allPeople = N, parentsCount = K
    private static boolean parentsCount(int allPeople, int parentsCount, int middle) {
        return (3 * (parentsCount + middle) >= allPeople + middle);
    }

    //countTask = N, firstDay = K
    private static boolean tasksCount(int countTask, int firstDay, int middle) {
        return (firstDay + middle) >= countTask;
    }

    public static int rightSearch(int square, int n) {
        int left = 1;
        int right = square;
        while (right != left) {
            int middle = (right + left + 1) / 2;
            if (square / (middle * middle) >= n) {
                left = middle;
            } else {
                right = middle - 1;
            }
        }
        return right;
    }
}
