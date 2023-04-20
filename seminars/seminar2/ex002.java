package seminars.seminar2;

public class ex002 {
    public static int Sum2D(String[][] arr) {
    if (arr == null || arr.length == 0) {
        throw new RuntimeException("Array is empty or null");
    }
    int sum = 0;
    for (String[] strings : arr) {
        for (String string : strings) {
            try {
                int val = Integer.parseInt(string);
                sum += val;
            } catch (NumberFormatException err) {
                System.out.println(err.getMessage());
            }
        }
    }
    return sum;
}
}
