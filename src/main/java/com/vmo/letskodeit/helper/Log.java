package com.vmo.letskodeit.helper;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Log {
    private static Logger logger = LogManager.getLogger(Log.class);

    public static void info(String message){
        logger.info(message);
    }
    public static void error(String message){
        logger.info(message);
    }
    public static void debug (String message){
        logger.info(message);
    }
}