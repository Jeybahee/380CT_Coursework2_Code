package dynamic_programming;

import java.util.Random;

public class Dynamic_programming {

    public static void main(String[] args) {
        for (int a = 20; a < 1000; a = a + 40) {
            long startTime = System.nanoTime();
            //System.out.print(begin(a) + " ");
            begin(a);
            System.out.println((System.nanoTime() - startTime));
        }
    }

    public static boolean begin(int size) {
        int[] array = new int[size];
        Random rand = new Random();
        int n;
        for (int i = 0; i < size; i++) {
            n = rand.nextInt(100) + 1;
            array[i] = n;
        }
        int sum = 1700;
        int m = array.length;
        if (SubsetSum_Dynamic_Programming(array, m, sum) == true) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean SubsetSum_Dynamic_Programming(int[] array, int m, int sum) {
        boolean subset[][] = new boolean[m + 1][sum + 1];
        for (int i = 1; i <= sum; i++) {
            subset[0][i] = false;
        }

        for (int i = 0; i <= m; i++) {
            subset[i][0] = true;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= sum; j++) {
                subset[i][j] = subset[i - 1][j];
                if (subset[i][j] == false && j >= array[i - 1]) {
                    subset[i][j] = subset[i][j]
                            || subset[i - 1][j - array[i - 1]];
                }
            }
        }
        return subset[m][sum];
    }
}
