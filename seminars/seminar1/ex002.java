package seminars.seminar1;

public class ex002 {
    public static int findElementIndex(int[] arr, int element, int minLength) {
        if (arr == null) {
            return -3;
        }
        if (arr.length < minLength) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -2;
    }
}
