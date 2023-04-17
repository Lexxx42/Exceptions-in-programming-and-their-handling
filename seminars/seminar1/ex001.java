package seminars.seminar1;

public class ex001 {
    public static int ShowArray(int[] arr) {
        if (arr == null || arr.length < 1) {
            return -1;
        }
        return arr.length;
    }
}
