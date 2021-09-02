import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogNiloo {


        private static final Logger LOG= LoggerFactory.getLogger(LogNiloo.class);

        public static void main(String[] args) {
            String txt="finisssshhhhhhhhh finish";
            LOG.info("Class Name: {},  {}...  " ,  LogNiloo.class.getSimpleName(), txt );
            LOG.error("Class Name: {},  {}...  " , LogNiloo.class.getSimpleName(), txt );
            LOG.debug("Class Name: {},  {}...  " , LogNiloo.class.getSimpleName(), txt );

        }


}
