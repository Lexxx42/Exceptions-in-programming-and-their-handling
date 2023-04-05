package lectures.lecture1;

import java.io.File;

public class Exceptions4 {
    public static void main(String[] args) {
        System.out.println(divide(10, 0));
    }

    public static int divide(int a1, int a2) {
        if (a2 == 0) {
            throw new RuntimeException("Can't divide by zero");
        }        return a1 / a2;
    }

    public static long getFileSize(File file) {
        if (!file.exists()) {
            return -1L;
        }
        return file.length();
    }
}
