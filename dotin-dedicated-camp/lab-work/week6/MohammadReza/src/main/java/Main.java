import java.io.File;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    private final static Logger LOGGER = Logger.getLogger(Main.class.getName());
//    Log4j2

    public static void main(String[] args) {

//        LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME).setLevel(Level.INFO);

        LOGGER.setLevel(Level.WARNING);
        LOGGER.info("start project ");
        // if 1 / 0
        LOGGER.warning("Exp");
        System.out.println(LOGGER.getLevel());;
//        System.out.println(new Date() + " Start project ...");
//        System.err.println(new Date() + " Error project ...");
//        File file = new File("log.txt");
//        //

    }
}
