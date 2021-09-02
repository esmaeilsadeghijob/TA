package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Logback {
    private static final Logger LOG = LoggerFactory.getLogger(Logback.class);

    public static void main(String[] args) {
        String txt = "Done";
        LOG.info("Class Name: {},  {}...  " , Logback.class.getSimpleName(), txt );
        LOG.error("Class Name: {},  {}...  " , Logback.class.getSimpleName(), txt );
        


    }
}
