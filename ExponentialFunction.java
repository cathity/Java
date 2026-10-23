package lab1.logic;
import java.util.Locale;

public class ExponentialFunction extends Function implements Printable{
    private final double a;
    private final double b;

    public ExponentialFunction(double a, double b) {
        if( a <= 0 || Math.abs(a - 1) < EPSILON){
            throw new IllegalArgumentException(
                    "Podstawa musi być dodatnia i rozna od 1");
        }
        this.a =a;
        this.b =b;
    }

    @Override
    public double calculateValue(double x) {
        return Math.pow(a, x) + b;
    }

    @Override
    public double[] calculateZeros() {
        if (-b <= 0) {
            return new double[0];
        }
        return new double[] {Math.log(-b) / Math.log(a)};
    }

    public boolean isIncreasing(){
        return a > 1;
    }

    @Override
    public void print() {
        System.out.println(String.format(Locale.US,
                "f(x) = %.2f^x %s %.2f", a, b < 0 ? "-" : "+", Math.abs(b)));
        System.out.println(String.format(Locale.US,
                "a = %.2f, b = %.2f, funkcja %s", a, b, isIncreasing() ? "rosnaca" : "malejaca"));
        System.out.println("Miejsca zerowe: " + zerosToString());
    }
    }



