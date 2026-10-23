package lab1;

import lab1.logic.ExponentialFunction;
import lab1.logic.Function;
import lab1.logic.FunctionOnInterval;
import lab1.logic.LinearFunction;
import lab1.logic.Printable;
import lab1.logic.QuadraticFunction;
import lab1.ui.ConsoleInput;

public class Main {
    public static void main(String[] args) {
        ConsoleInput input = new ConsoleInput();
        boolean running = true;

        while (running) {
            System.out.println("1 - Liniowa  2 - Kwadratowa  3 - Wykldnicza  0 - Wyjscie");
            int choice = input.readInt("> ");

            try {
                Function function = null;
                switch (choice) {
                    case 0:
                        running = false;
                        break;
                    case 1:
                        function = new LinearFunction(
                                input.readDouble("a: "), input.readDouble("b: "));
                        break;
                    case 2:
                        function = new QuadraticFunction(
                                input.readDouble("a: "), input.readDouble("b: "), input.readDouble("c: "));
                        break;
                    case 3:
                        function = new ExponentialFunction(
                                input.readDouble("a: "), input.readDouble("b: "));
                        break;
                    default:
                        System.out.println("Nieznana opcja.");
                        break;
                }

                if (function != null) {
                    double start = input.readDouble("Poczatek przedzialu: ");
                    double end = input.readDouble("Koniec przedzialu: ");
                    double step = input.readDouble("Krok: ");
                    FunctionOnInterval onInterval = new FunctionOnInterval(function, start, end, step);

                    ((Printable) function).print();
                    onInterval.print();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Blad: " + e.getMessage());
            }
            System.out.println();
        }
        System.out.println("Koniec programu.");
    }
}