package homeworks.homework3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PersonalData {

    public static void main(String[] args) {
        String[] fieldNames = {
                "Last name", "First name",
                "Middle name", "Date of birth (dd.mm.yyyy)",
                "Phone number", "Gender (f/m)"
        };
        String[] userData = new String[6];

        Scanner scanner = new Scanner(System.in);
        List<Integer> fieldIndices = new ArrayList<>();
        for (int i = 0; i < fieldNames.length; i++) {
            fieldIndices.add(i);
        }
        Collections.shuffle(fieldIndices);

        for (int i = 0; i < fieldNames.length; i++) {
            int fieldIndex = fieldIndices.get(i);
            System.out.print("Enter " + fieldNames[fieldIndex] + ": ");
            userData[fieldIndex] = scanner.nextLine();
        }

        String lastName = userData[0];
        String firstName = userData[1];
        String middleName = userData[2];
        String dateOfBirth = userData[3];
        String phoneNumber = userData[4];
        String gender = userData[5];

        try {
            LocalDate birthDate = parseDateOfBirth(dateOfBirth);
            if (birthDate == null) {
                System.out.println("Invalid date of birth. Please enter a valid date in the format " + PersonalDataUtils.DATE_FORMAT);
                return;
            }

            int currentYear = LocalDate.now().getYear();
            if (birthDate.getYear() < 1950 || birthDate.getYear() > currentYear) {
                System.out.println("Invalid year of birth. Available years of birth are from 1950 to current year.");
                return;
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(lastName + ".txt"));
            writer.write(lastName + " " + firstName + " " + middleName + " " + dateOfBirth + " " + phoneNumber + " " + gender);
            writer.close();
            System.out.println("Data saved to file " + lastName + ".txt");
        } catch (NumberFormatException e) {
            System.out.println("Invalid phone number format. Please enter an unsigned integer without formatting.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Incorrect number of data entries. Please enter all required data in the correct order.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file. Please try again later.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred. Please try again later.");
        }
    }

    private static LocalDate parseDateOfBirth(String dateOfBirth) {
        String[] parts = dateOfBirth.split("\\.");
        if (parts.length != 3) {
            return null;
        }
        int day, month, year;
        try {
            day = Integer.parseInt(parts[0]);
            month = Integer.parseInt(parts[1]);
            year = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            return null;
        }
        try {
            return LocalDate.of(year, month, day);
        } catch (Exception e) {
            return null;
        }
    }
}

class PersonalDataUtils {
    public static final String DATE_FORMAT = "dd.mm.yyyy";
}
