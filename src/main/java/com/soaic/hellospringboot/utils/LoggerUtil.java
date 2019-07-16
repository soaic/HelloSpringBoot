package com.soaic.hellospringboot.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtil {

    public static void info(String msg) {
        Logger logger = LoggerFactory.getLogger(LoggerUtil.class);
        logger.info(msg);
    }

    public static void info(String msg, Class<?> clazz) {
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.info(msg);
    }
}
