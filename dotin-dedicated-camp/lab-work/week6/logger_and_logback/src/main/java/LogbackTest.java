import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogbackTest.class);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
                LOGGER.info("program finished in {} class", LogbackTest.class.getSimpleName());
                break;
            }
            try {
                int c = (a / b);
                System.out.printf("%.2f\n", ((float)a / (float)b));
            } catch (ArithmeticException e) {
                //for (int i = 0; i < 20; i++) {
                    LOGGER.warn("divide by zero in {} class", LogbackTest.class.getSimpleName());
                //}
            }
        }
    }
}
