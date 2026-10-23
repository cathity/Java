package lab1.logic;
import java.util.Locale;

public class FunctionOnInterval implements Printable{
    private static final double EPSILONE = 1e-9;

    private final Function function;
    private final double start;
    private final double end;
    private final double step;

    public double[] calculateArguments() {
        int count = (int) Math.floor((end - start) / step + EPSILONE) + 1;
        double[] xs = new double[count];
        for (int i = 0; i < count; i++) {
            xs[i] = start + i * step;
        }
        return xs;
    }

    public double[] calculateValues() {
        double[] xs = calculateArguments();
        double[] values = new double[xs.length];
        for (int i = 0; i < xs.length; i++) {
            values[i] = function.calculateValue(xs[i]);
        }
        return values;
    }

    public double findMin() {
        double[] values = calculateValues();
        double min = values[0];
        for (double value : values) {
            min = Math.min(min, value);
        }
        return min;
    }

    public double findMax() {
        double[] values = calculateValues();
        double max = values[0];
        for (double value : values) {
            max = Math.max(max, value);
        }
        return max;
    }

    public double calculateTrapezoidArea() {
        double[] values = calculateValues();
        double area = 0;
        for (int i = 0; i < values.length - 1; i++) {
            area += (values[i] + values[i + 1]) / 2 * step;
        }
        return area;
    }

    public FunctionOnInterval(Function function, double start, double end, double step){
        if(function == null){
            throw new IllegalArgumentException("Funkcja nie moze byc null");
        }
        if(start >= end){
            throw new IllegalArgumentException("Poczatek przedzialu musi byc mnieszy niz koniec");
        }
        if ( step <= 0 || step > end - start){
            throw new IllegalArgumentException("Krok musi spelniac: 0 < krok <= dlugosc przedziali");
        }
        this.function = function;
        this.start = start;
        this.end = end;
        this.step = step;

    }

    @Override
    public void print() {
        double[] xs = calculateArguments();
        double[] values = calculateValues();
        System.out.println(String.format(Locale.US,
                "Przebieg na [%.2f, %.2f], krok %.2f", start, end, step));
        StringBuilder xLine = new StringBuilder("x:");
        StringBuilder yLine = new StringBuilder("f(x):");
        for (int i = 0; i < xs.length; i++) {
            xLine.append(String.format(Locale.US, " %.2f", xs[i]));
            yLine.append(String.format(Locale.US, " %.2f", values[i]));
        }
        System.out.println(xLine);
        System.out.println(yLine);
        System.out.println(String.format(Locale.US,
                "Min: %.2f, max: %.2f", findMin(), findMax()));
        System.out.println(String.format(Locale.US,
                "Pole (metoda trapezow): %.2f", calculateTrapezoidArea()));
    }

}


