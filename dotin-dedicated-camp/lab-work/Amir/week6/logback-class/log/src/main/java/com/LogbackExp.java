package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LogbackExp {
    private static final Logger LOG = LoggerFactory.getLogger(LogbackExp.class);

    public static void main(String[] args) {
        String txt = "project finished";
        LOG.info("Class Name: {} ***** {}  ", LogbackExp.class.getSimpleName(), txt);
        LOG.error("Class Name: {} ***** {}...  ", LogbackExp.class.getSimpleName(), txt);
        LOG.debug("Class Name: {} *****  {}...  ", LogbackExp.class.getSimpleName(), txt);
        LOG.info("Class Name: {} ***** {}  ", LogbackExp.class.getSimpleName(), txt);
        LOG.error("Class Name: {} ***** {}...  ", LogbackExp.class.getSimpleName(), txt);
        LOG.debug("Class Name: {} *****  {}...  ", LogbackExp.class.getSimpleName(), txt);
        LOG.info("Class Name: {} ***** {}  ", LogbackExp.class.getSimpleName(), txt);
        LOG.error("Class Name: {} ***** {}...  ", LogbackExp.class.getSimpleName(), txt);
        LOG.debug("Class Name: {} *****  {}...  ", LogbackExp.class.getSimpleName(), txt);
        LOG.warn("Class Name: {} *****  {}...  ", LogbackExp.class.getSimpleName(), txt);
    }
}
