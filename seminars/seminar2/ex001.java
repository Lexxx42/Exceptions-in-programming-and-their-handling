package seminars.seminar2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ex001 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[10];
        System.out.println("Enter index of element of array that do you want write first value");
        int index = 0;
        try {
            index = in.nextInt();
        } catch (NumberFormatException | InputMismatchException err) {
            System.out.println("Invalid value for index");
        }
        try {
            arr[index] = 1;
        } catch (IndexOutOfBoundsException err) {
            System.out.println("Invalid index");
        }
    }
}
