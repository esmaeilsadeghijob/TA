package com.mahdi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LogBack {

    private final Logger LOG = LoggerFactory.getLogger(LogBack.class);

    public void logging() {
        String txt = "finish";
        LOG.info("Class Name: {},  {}...  " , LogBack.class.getSimpleName(), txt );
        LOG.error("Class Name: {},  {}...  " , LogBack.class.getSimpleName(), txt );
        LOG.debug("Class Name: {},  {}...  " , LogBack.class.getSimpleName(), txt );

    }
}
