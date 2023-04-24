package seminars.seminar3;

public class ArraySum {
    public int sum(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        for (String[] row : arr) {
            if (row.length != 4) {
                throw new MyArraySizeException();
            }
        }

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }

        return sum;
    }

    public static class MyArraySizeException extends Exception {
        public MyArraySizeException() {
            super("Array size is not 4x4");
        }
    }

    public static class MyArrayDataException extends Exception {
        private int i, j;

        public MyArrayDataException(int i, int j) {
            super(String.format("Invalid data at cell [%d, %d]", i, j));
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static void main(String[] args) {
        String[][] arr = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16", "17"}
        };

        try {
            ArraySum arraySum = new ArraySum();
            int sum = arraySum.sum(arr);
            System.out.println("The sum of the elements is: " + sum);
        } catch (ArraySum.MyArraySizeException e) {
            System.out.println("Array size is not 4x4");
        } catch (ArraySum.MyArrayDataException e) {
            System.out.println("Invalid data at cell [" + e.getI() + ", " + e.getJ() + "]");
        }
    }
}