package lab1.logic;
import java.util.Locale;

public class LinearFunction extends Function implements Printable {
    private final double a;
    private final double b;

    public LinearFunction(double a, double b){
        if (Math.abs(a) < EPSILON){
            throw new IllegalArgumentException(
                    "Wspolczynik ne moze byc = 0 "
            );
        }
        this.a =a;
        this.b =b;
    }

    @Override
    public double calculateValue(double x) {
        return a * x + b;
    }

    @Override
    public double[] calculateZeros() {
        return new double[] {-b / a};
    }

    @Override
    public void print() {
        System.out.println(String.format(Locale.US,
            "f(x) = %.2fx %s %.2f", a, b < 0 ? "-" : "+", Math.abs(b)));
        double[] zeros = calculateZeros();
        System.out.println(String.format(Locale.US,
                "Miejsca zerowe: %.2f", zeros[0]));

    }
}
