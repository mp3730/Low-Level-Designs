package LoggingFramework.Model;

public class LogConfig {
    private LogType logType;
    private LogOutputAppender logOutputAppender;

    public LogConfig(LogType logType, LogOutputAppender logOutputAppender) {
        this.logType = logType;
        this.logOutputAppender = logOutputAppender;
    }

    public LogType getLogType() {
        return logType;
    }

    public void setLogType(LogType logType) {
        this.logType = logType;
    }

    public LogOutputAppender getLogOutputAppender() {
        return logOutputAppender;
    }

    public void setLogOutputAppender(LogOutputAppender logOutputAppender) {
        this.logOutputAppender = logOutputAppender;
    }
}
