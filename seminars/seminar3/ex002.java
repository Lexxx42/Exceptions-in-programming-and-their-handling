package seminars.seminar3;

import java.io.IOException;

public class ex002 {

    public static void main(String[] args) {
        try {
            doSomething();
        } catch (IOException e) {
            System.out.println("Caught an IOException: " + e.getMessage());
        }
    }

    public static void doSomething() throws IOException {
        throw new IOException("Something went wrong!");
    }
}
