package LoggingFramework.Model;

import java.io.FileWriter;
import java.io.IOException;

public class FileAppender implements LogOutputAppender {
    private String filePath;

    public FileAppender(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void append(LogMessage logMessage) {
        try(FileWriter fileWriter = new FileWriter(filePath, true)){
            fileWriter.write(logMessage.toString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
