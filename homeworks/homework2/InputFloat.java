package homeworks.homework2;
// Реализуйте метод, который запрашивает у пользователя
// ввод дробного числа (типа float), и возвращает введенное значение.
// Ввод текста вместо числа не должно приводить к падению приложения,
// вместо этого, необходимо повторно запросить у пользователя ввод данных.

import java.util.Scanner;

public class InputFloat {
    public static void main(String[] args) {
        System.out.println(readFloat());
    }

    public static float readFloat() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a fractional number: ");
            String input = scanner.nextLine();
            try {
                return Float.parseFloat(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a fractional number.");
            }
        }
    }

}
