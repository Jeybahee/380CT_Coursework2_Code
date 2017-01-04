package brute_force;

import java.util.Random;

public class Brute_force {

    public static void main(String[] args) {
        int bit = 10;
        for (int n = 1; n < 30; n++) {
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
        return SubsetSum_Brute_Force(S, n, t) == true;
    }

    public static boolean SubsetSum_Brute_Force(int[] S, int n, int t) {
        if (t == 0) {
            return true;
        }
        if (n == 0 && t != 0) {
            return false;
        }
        if (S[n - 1] > t) {
            return SubsetSum_Brute_Force(S, n - 1, t);
        }
        return SubsetSum_Brute_Force(S, n - 1, t) || SubsetSum_Brute_Force(S, n - 1, t - S[n - 1]);
    }
}
