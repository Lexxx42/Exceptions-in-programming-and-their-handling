package homeworks.homework3;

import java.io.File;
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
                System.out.println("Invalid date of birth. Please enter a valid date in the format "
                        + PersonalDataUtils.DATE_FORMAT);
                return;
            }

            int currentYear = LocalDate.now().getYear();
            if (birthDate.getYear() < 1950 || birthDate.getYear() > currentYear) {
                System.out.println("Invalid year of birth. Available years of birth are from 1950 to current year.");
                return;
            }

            if (!isValidGender(gender)) {
                System.out.println("Invalid gender. Available genders are 'f' (female) and 'm' (male).");
                return;
            }

            writeDataToFile(lastName, firstName, middleName, dateOfBirth, phoneNumber, gender);
        } catch (NumberFormatException e) {
            System.out.println("Invalid phone number format. Please enter an unsigned integer without formatting.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Incorrect number of data entries. Please enter all required data in the correct order.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file. Please try again later.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("An unexpected error occurred. Please try again later.");
            e.printStackTrace();
        }
    }

    private static void writeDataToFile(String lastName, String firstName, String middleName,
                                        String dateOfBirth, String phoneNumber,
                                        String gender) throws IOException {
        String fileName = lastName + ".txt";
        File file = new File(fileName);
        boolean fileExists = file.exists();
        FileWriter writer = new FileWriter(file, true);
        if (fileExists) {
            writer.append(System.lineSeparator());
        }
        writer.write(lastName + " " + firstName + " "
                + middleName + " " + dateOfBirth + " "
                + phoneNumber + " " + gender);
        writer.close();
        System.out.println("Data saved to file " + fileName);
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

    private static boolean isValidGender(String gender) {
        return gender.equals("f") || gender.equals("m");
    }
}

class PersonalDataUtils {
    public static final String DATE_FORMAT = "dd.mm.yyyy";
}
