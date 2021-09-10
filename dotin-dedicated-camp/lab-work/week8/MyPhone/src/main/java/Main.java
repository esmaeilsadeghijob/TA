import JDBC.ConnectionDB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOG= LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        ConnectionDB.setvalue();
        new MyScanner();

        String txt="niloo-log";
        LOG.info("Class Name: {},  {}...  " ,  Main.class.getSimpleName(), txt );
        LOG.error("Class Name: {},  {}...  " , Main.class.getSimpleName(), txt );
        LOG.debug("Class Name: {},  {}...  " , Main.class.getSimpleName(), txt );

    }
}
