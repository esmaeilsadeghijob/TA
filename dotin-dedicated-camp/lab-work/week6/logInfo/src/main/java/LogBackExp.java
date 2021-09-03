import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogBackExp {
    private final static Logger logger = LoggerFactory.getLogger(LogBackExp.class);

    public static void main(String[] args) {
        String txt = "finish";
        logger.debug("Class Name: {} , {} ... ", LogBackExp.class.getSimpleName(), txt);
        logger.info("Class Name: {} , {} ... ", LogBackExp.class.getSimpleName(), txt);
        logger.error("Class Name: {} , {} ... ", LogBackExp.class.getSimpleName(), txt);

    }
}
