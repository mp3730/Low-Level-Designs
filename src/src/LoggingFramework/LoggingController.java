package LoggingFramework;

import LoggingFramework.Model.FileAppender;
import LoggingFramework.Model.LogConfig;
import LoggingFramework.Model.LogType;
import LoggingFramework.Model.Logger;

public class LoggingController {
    public static void logger(){
        Logger logger = Logger.getInstance();

        // Logging with default configuration - ConsoleAppender & INFO log Type
        logger.info("This is an information message");
        logger.warning("This is a warning message");

        // Changing log level and appender
        LogConfig config = new LogConfig(LogType.DEBUG, new FileAppender("app.log"));
        logger.setLogConfig(config);

        //these are not getting printed as the log config has been changed to FileAppender rather than ConsoleAppender
        logger.warning("This is a warning message 2");
        logger.error("This is an error message 2");
    }
}
