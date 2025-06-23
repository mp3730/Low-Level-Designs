package LoggingFramework.Model;

public class Logger {
    private static Logger instance = new Logger();
    private LogConfig logConfig;

    public Logger() {
        this.logConfig = new LogConfig(LogType.INFO, new ConsoleAppender());
    }

    public static Logger getInstance() {
        return instance;
    }

    public void setLogConfig(LogConfig logConfig) {
        this.logConfig = logConfig;
    }

    public void log(LogType logType, String logMessage) {
        if(logType.ordinal() >= logConfig.getLogType().ordinal()) {
            logConfig.getLogOutputAppender().append(new LogMessage(logType, logMessage)); //new LogMessage(logType, logMessage);
        }
    }

    public void debug(String logMessage) {
        log(LogType.DEBUG, logMessage);
    }
    public void info(String logMessage) {
        log(LogType.INFO, logMessage);
    }
    public void warning(String logMessage) {
        log(LogType.WARNING, logMessage);
    }
    public void error(String logMessage) {
        log(LogType.ERROR, logMessage);
    }
    public void fatal(String logMessage) {
        log(LogType.FATAL, logMessage);
    }
}
