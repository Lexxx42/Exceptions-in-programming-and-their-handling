// Если необходимо, исправьте данный код
// (задание 2 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)

package homeworks.homework2;

import java.io.IOException;

public class CodeCheck1 {
    public static void main(String[] args) throws IOException {
        CodeCheck();
    }

    public static void CodeCheck() {
        try {
            int d = 0;
            int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
            if (intArray.length < 9) {
                throw new ArrayIndexOutOfBoundsException("intArray has fewer than 9 elements");
            }
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Catching exception: " + e);
        }
    }
}

