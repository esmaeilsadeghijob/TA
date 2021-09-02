import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingTest {
    private final static Logger LOGGER = Logger.getLogger(LoggingTest.class.getName());
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LOGGER.setLevel(Level.ALL);
        while (true) {
            System.out.println("enter -1 for exit!");
            System.out.print("enter dividend: ");
            int a = scanner.nextInt();
            if (a == -1) {
                LOGGER.info("program finished!");
                break;
            }
            System.out.print("enter divisor: ");
            int b = scanner.nextInt();
            if (b == -1) {
                LOGGER.info("program finished!");
                break;
            }
            try {
                int c = (a / b);
                System.out.printf("%.2f\n", ((float)a / (float)b));
            } catch (ArithmeticException e) {
                LOGGER.warning("divide by zero!");
            }
        }
    }
}
