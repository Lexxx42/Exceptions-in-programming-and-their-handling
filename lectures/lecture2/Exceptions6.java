package lectures.lecture2;

public class Exceptions6 {
    public static void main(String[] args) {
        int number = 1;
        try {
            number = 10 / 1;
            String message = null;
            System.out.println(message.length());
        } catch (ArithmeticException e) {
            System.out.println("Division by zero");
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
        }
        System.out.println(number);
    }
}
