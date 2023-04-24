package homeworks.homework3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        Pattern datePattern = Pattern.compile("([0-9]{2}).([0-9]{2}).([0-9]{4})");
        Matcher matcher = datePattern.matcher(dateOfBirth);
        if (!matcher.matches()) {
            System.out.println("Invalid date format. Please enter date in the format " + PersonalDataUtils.DATE_FORMAT);
            return;
        }

        try {
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
}

class PersonalDataUtils {
    public static final String DATE_FORMAT = "dd.mm.yyyy";
}
