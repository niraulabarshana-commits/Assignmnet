import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LogFileReader {
    public static void main(String[] args) {
        String fileName = "server.log";
        createSampleLogIfMissing(fileName);

        ArrayList<String> errorLines = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("ERROR")) {
                    errorLines.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading log file: " + e.getMessage());
        }

        System.out.println("Lines containing ERROR:");
        for (String line : errorLines) {
            System.out.println(line);
        }
    }

    private static void createSampleLogIfMissing(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            return;
        }

        try (FileWriter writer = new FileWriter(file)) {
            writer.write("INFO Server started\n");
            writer.write("ERROR Database connection failed\n");
            writer.write("INFO Retrying connection\n");
            writer.write("ERROR Timeout while connecting\n");
        } catch (IOException e) {
            System.out.println("Could not create sample log: " + e.getMessage());
        }
    }
}
