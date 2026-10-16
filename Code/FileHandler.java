import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
    // Write information to a text file
    public static void writeToFile(String fileName, String content)
            throws IOException {

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
        }
    }

    // Read information from a text file
    public static void readFromFile(String fileName)
            throws IOException {

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
