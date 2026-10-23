package lab1.logic;
import java.util.Locale;

public class QuadraticFunction extends Function implements Printable {
    private final double a;
    private final double b;
    private final double c;

    public QuadraticFunction(double a, double b, double c) {
        if (Math.abs(a) < EPSILON) {
            throw new IllegalArgumentException(
                    "Wspolczynik nie moze byc rowny 0");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double calculateValue(double x) {
        return a * x * x + b * x + c;
    }

    public double calculateDelta() {
        return b * b - 4 * a * c;
    }

    public double[] calculateVertex() {
        double p = -b / (2 * a);
        double q = -calculateDelta() / (4 * a);
        return new double[]{p, q};
    }

    @Override
    public double[] calculateZeros() {
        double delta = calculateDelta();
        if (Math.abs(delta) < EPSILON) {
            return new double[]{-b / (2 * a)};
        }
        if (delta < 0) {
            return new double[0];
        }
        double root = Math.sqrt(delta);
        double x1 = (-b - root) / (2 * a);
        double x2 = (-b + root) / (2 * a);
        return new double[]{Math.min(x1, x2), Math.max(x1, x2)};
    }

    @Override
    public void print() {
        System.out.println(String.format(Locale.US,
                "f(x) = %.2fx^2 %s %.2fx %s %.2f",
                a, b < 0 ? "-" : "+", Math.abs(b), c < 0 ? "-" : "+", Math.abs(c)));
        double[] vertex = calculateVertex();
        System.out.println(String.format(Locale.US,
                "Delta: %.2f, wierzcholek: (%.2f, %.2f)", calculateDelta(), vertex[0], vertex[1]));
        System.out.println("Miejsca zerowe: " + zerosToString());
    }
}
