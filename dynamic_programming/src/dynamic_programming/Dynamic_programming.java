package dynamic_programming;

import java.util.Random;

public class Dynamic_programming {

    public static void main(String[] args) {
        int bit = 10;
        for (int n = 1; n < 200; n++) {
            long startTime = System.nanoTime();
            for (int i = 0; i < 100; i++) {
                //System.out.print(begin(a) + " ");
                begin(n, bit);
            }
            System.out.println((System.nanoTime() - startTime) / 100);
        }
    }

    public static boolean begin(int n, int bit) {
        int max_n_bit_number = (int) Math.pow(2, bit - 1);
        int[] S = new int[n];
        Random rand = new Random();
        int temp;
        for (int i = 0; i < n; i++) {
            temp = rand.nextInt(max_n_bit_number) + 0;
            S[i] = temp;
        }
        int t = rand.nextInt(n * max_n_bit_number) + 0;
        return SubsetSum_Dynamic_Programming(S, n, t) == true;
    }

    public static boolean SubsetSum_Dynamic_Programming(int[] S, int n, int t) {
        boolean subset[][] = new boolean[n + 1][t + 1];
        for (int i = 1; i <= t; i++) {
            subset[0][i] = false;
        }

        for (int i = 0; i <= n; i++) {
            subset[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= t; j++) {
                subset[i][j] = subset[i - 1][j];
                if (subset[i][j] == false && j >= S[i - 1]) {
                    subset[i][j] = subset[i][j]
                            || subset[i - 1][j - S[i - 1]];
                }
            }
        }
        return subset[n][t];
    }
}
