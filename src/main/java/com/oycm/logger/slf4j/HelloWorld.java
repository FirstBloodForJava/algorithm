package com.oycm.logger.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ouyangcm
 * create 2025/4/14 12:51
 */
public class HelloWorld {

    public static void main(String[] args) {
        Logger log = LoggerFactory.getLogger(HelloWorld.class);
        log.info("HelloWorld");

        log.atInfo().log("HelloWorld");

        log.info("HelloWorld {}", "04/14");
        log.atInfo().setMessage("HelloWorld {}").addArgument("04/14").log();
        log.atInfo().setMessage("HelloWorld {}").addArgument(() -> "04/14").log();


        log.info("yesterday={} today={} HelloWorld", "04/13", "04/14");
        log.atInfo().setMessage("HelloWorld").addKeyValue("yesterday", "04/13").addKeyValue("today", "04/14").log();
    }
}
