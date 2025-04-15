package com.oycm.logger.jcl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author ouyangcm
 * create 2025/4/15 16:49
 */
public class JclHelloWorld {

    public static void main(String[] args) {

        Log log = LogFactory.getLog(JclHelloWorld.class);

        log.info("JCL HelloWorld");
        log.info("JCL HelloWorld");
    }
}
