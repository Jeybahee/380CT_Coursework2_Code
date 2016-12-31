package special_case;

import java.util.Random;

public class Special_case {

    public static void main(String[] args) {

        //int array[] = {3, 1, 1, 1, 2, 2, 1, 5};
        for (int i = 20; i < 1000; i = i + 50) {
            long startTime = System.nanoTime();
            int array[] = GenerateRandomArray(i);
            int len = array.length;
            findPartition(array, len);
            System.out.println((System.nanoTime() - startTime));
//            if (findPartition(array, len) == true) {
//                System.out.println(true);
//            } else {
//                System.out.println(false);
//            }
        }
    }

    public static int[] GenerateRandomArray(int size) {
        int[] array = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(100 + 1);
        }
        return array;
    }

    static boolean findPartition(int array[], int len) {
        int sum = 0;
        int i, j;

        for (i = 0; i < len; i++) {
            sum += array[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        boolean part[][] = new boolean[sum / 2 + 1][len + 1];

        for (i = 0; i <= len; i++) {
            part[0][i] = true;
        }
        for (i = 1; i <= sum / 2; i++) {
            part[i][0] = false;
        }
        for (i = 1; i <= sum / 2; i++) {
            for (j = 1; j <= len; j++) {
                part[i][j] = part[i][j - 1];
                if (i >= array[j - 1]) {
                    part[i][j] = part[i][j] || part[i - array[j - 1]][j - 1];
                }
            }
        }
        return part[sum / 2][len];
    }
}
