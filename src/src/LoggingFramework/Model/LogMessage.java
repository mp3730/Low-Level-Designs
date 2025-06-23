package LoggingFramework.Model;

public class LogMessage {
    private long timestamp;
    private LogType logType;
    private String message;

    public LogMessage(LogType logType, String message) {
        this.timestamp = System.currentTimeMillis();
        this.logType = logType;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public LogType getLogType() {
        return logType;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + logType + ": " + message;
    }
}
