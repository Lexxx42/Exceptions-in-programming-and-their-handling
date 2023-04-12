package lectures.lecture3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Exceptions8 {
    public static void main(String[] args) {

        try (FileReader reader = new FileReader("test_file.txt");
             FileWriter writer = new FileWriter("test")) {
            while (reader.ready()) {
                writer.write(reader.read());
            }
        } catch (RuntimeException | IOException e) {
            System.out.println("catch exception: " + e.getClass().getSimpleName());
        }
        System.out.println("copy successful");
    }
}
