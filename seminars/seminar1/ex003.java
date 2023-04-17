package seminars.seminar1;

public class ex003 {
    public static int summSquareArray(int[][] arr) {
        if (arr.length != arr[0].length) {
            throw new RuntimeException("Массив дожен быть квадратным");
        };
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0 && arr[i][j] != 1) {
                    throw new RuntimeException("Должны быть только 0 или 1");
                }
                sum += arr[i][j];
            }
        }
        return sum;
    }
}
