package tasks.lecture1;

public class QuadraticEquation {
    public static double[] quadraticEquation(double a, double b, double c) {
        if (a == 0) {
            if (b != 0 && c != 0) {
                return new double[]{-b / c};
            }
            return null;
        } else {
            double d = Math.pow(b, 2) - 4 * a * c;
            if (d == 0) {
                return new double[]{-b / 2 * a};
            } else {
                return new double[]{((-b - Math.sqrt(d)) / (2 * a)), ((-b + Math.sqrt(d)) / (2 * a))};
            }
        }
    }
}
