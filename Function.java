package lab1.logic;
import java.util.Locale;

public abstract class Function {
    protected static final double EPSILON = 1e-9;
    public abstract double calculateValue(double x);
    public abstract double[] calculateZeros();

    protected String zerosToString() {
        double[] zeros = calculateZeros();
        if (zeros.length == 0) {
            return "brak";
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < zeros.length; i++) {
            if (i > 0) {
                builder.append(", ");
            }
            builder.append(String.format(Locale.US, "%.2f", zeros[i]));
        }
        return builder.toString();
    }
}
