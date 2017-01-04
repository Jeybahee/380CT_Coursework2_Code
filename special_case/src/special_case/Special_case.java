package special_case;

import java.util.Random;

public class Special_case {

    public static void main(String[] args) {

        //int array[] = {3, 1, 1, 1, 2, 2, 1, 5};
        int bit = 20;
        for (int n = 1; n < 200; n++) {
            long startTime = System.nanoTime();
            for (int i = 0; i < 100; i++) {
                begin(n, bit);
            }
            System.out.println((System.nanoTime() - startTime) / 100);
//            if (findPartition(array, len) == true) {
//                System.out.println(true);
//            } else {
//                System.out.println(false);
//            }
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
        return findPartition(S, n) == true;
    }

    static boolean findPartition(int S[], int n) {
        int sum = 0;
        int i, j;

        for (i = 0; i < n; i++) {
            sum += S[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        boolean part[][] = new boolean[sum / 2 + 1][n + 1];

        for (i = 0; i <= n; i++) {
            part[0][i] = true;
        }
        for (i = 1; i <= sum / 2; i++) {
            part[i][0] = false;
        }
        for (i = 1; i <= sum / 2; i++) {
            for (j = 1; j <= n; j++) {
                part[i][j] = part[i][j - 1];
                if (i >= S[j - 1]) {
                    part[i][j] = part[i][j] || part[i - S[j - 1]][j - 1];
                }
            }
        }
        return part[sum / 2][n];
    }
}
