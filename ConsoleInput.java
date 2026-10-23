package lab1.ui;
import java.util.Scanner;

public class ConsoleInput {
    private final Scanner scanner = new Scanner(System.in);

    public int readInt(String promt){
        while(true){
            System.out.print(promt);
            String line = scanner.nextLine().trim();
            try{
                return Integer.parseInt(line);
            } catch (NumberFormatException e){
                System.out.println("Liczba musi byc calkowita");
            }
        }
    }

    public double readDouble(String promt){
        while(true){
            System.out.print(promt);
            String line = scanner.nextLine().trim().replace(',', '.');
            try{
                return Double.parseDouble(line);
            } catch( NumberFormatException e){
                System.out.println("To nie jest liczba!");
            }
        }
    }
}
