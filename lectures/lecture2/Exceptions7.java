package lectures.lecture2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Exceptions7 {
    public static void main(String[] args) {
        FileReader test = null;
        try {
            test = new FileReader("test.txt");
            test.read();
        } catch (RuntimeException | IOException e) {
            System.out.println("catch exception: " + e.getClass().getSimpleName());
        } finally {
            System.out.println("finally start");
            if (test != null) {
                try {
                    test.close();
                } catch (IOException e) {
                    System.out.println("exc when closing");
                }
            }
            System.out.println("finally finish");
        }
        // unreported exception java.io.FileNotFoundException; must be caught or declared to be thrown
    }
}
