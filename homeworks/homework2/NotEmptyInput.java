package homeworks.homework2;

import java.util.Scanner;

public class NotEmptyInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            String input = "";
            while (input.isEmpty()) {
                System.out.print("Enter a non-empty string: ");
                input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    throw new Exception("Blank lines cannot be entered");
                }
            }
            System.out.println("You entered: " + input);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
