package LoggingFramework.Model;

public class ConsoleAppender implements LogOutputAppender{
    @Override
    public void append(LogMessage logMessage) {
        System.out.println(logMessage.getMessage());
    }
}
