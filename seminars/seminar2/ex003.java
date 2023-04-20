package seminars.seminar2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class ex003 {

    private static final String FILE_NAME = "seminars/seminar2/data.txt";

    public static void main(String[] args) throws IOException {
        HashMap<String, String> data = readDataFromFile();
        System.out.println("Data read from file:");
        for (String key : data.keySet()) {
            System.out.println(key + " = " + data.get(key));
        }
        modifyData(data);
        writeDataToFile(data);
        System.out.println("Data written to file:");
        for (String key : data.keySet()) {
            System.out.println(key + " = " + data.get(key));
        }
    }

    private static HashMap<String, String> readDataFromFile() throws IOException {
        HashMap<String, String> data = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] tokens = line.split("=");
            if (tokens.length != 2) {
                throw new IOException("Invalid data format");
            }
            data.put(tokens[0].trim(), tokens[1].trim());
        }
        reader.close();
        return data;
    }

    private static void modifyData(HashMap<String, String> data) {
        for (String key : data.keySet()) {
            String value = data.get(key);
            if (value.equals("?")) {
                int num = findCorrespondingNumber(key);
                data.put(key, Integer.toString(num));
            } else if (!value.matches("\\d+")) {
                throw new IllegalArgumentException("Invalid data value: " + value);
            }
        }
    }

    private static int findCorrespondingNumber(String key) {
        int num = key.length();
        if (num == 0) {
            throw new IllegalArgumentException("Invalid key: " + key);
        }
        return num;
    }


    private static void writeDataToFile(HashMap<String, String> data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            StringBuilder sb = new StringBuilder();
            for (String key : data.keySet()) {
                sb.append(key).append("=").append(data.get(key)).append("\n");
            }
            writer.write(sb.toString());
        }
    }
}
