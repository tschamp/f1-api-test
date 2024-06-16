package ch.timo.f1;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {

    public Logger logger;

    public Log(String logFileName) throws IOException {
        // Create logger
        logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        // Create FileHandler to write log to file
        FileHandler fileHandler = new FileHandler(logFileName, true); // true for append mode
        fileHandler.setFormatter(new SimpleFormatter());

        // Add FileHandler to logger
        logger.addHandler(fileHandler);
    }
}
