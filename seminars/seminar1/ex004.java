package seminars.seminar1;

import java.util.Arrays;

public class ex004 {
    public static class ArraySum {
        public static int[] sumArrays(int[] arr1, int[] arr2) throws IllegalArgumentException {
            if (arr1.length != arr2.length) {
                throw new IllegalArgumentException("Input arrays must have equal lengths.");
            }

            int[] sumArray = new int[arr1.length];
            for (int i = 0; i < arr1.length; i++) {
                sumArray[i] = arr1[i] + arr2[i];
            }

            return sumArray;
        }

        public static void main(String[] args) {
            int[] arr1 = {1, 2, 3};
            int[] arr2 = {4, 5, 6};

            try {
                int[] sumArray = sumArrays(arr1, arr2);
                System.out.println(Arrays.toString(sumArray));
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

}
