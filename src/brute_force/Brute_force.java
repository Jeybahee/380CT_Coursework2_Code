package brute_force;

import java.util.Random;

public class Brute_force {

    public static void main(String[] args) {
        for (int a = 30; a < 40; a++) {
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

        int sum = 1200;
        int m = array.length;
        if (SubsetSum_Brute_Force(array, m, sum) == true) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean SubsetSum_Brute_Force(int[] array, int m, int sum) {
        if (sum == 0) {
            return true;
        }
        if (m == 0 && sum != 0) {
            return false;
        }
        if (array[m - 1] > sum) {
            return SubsetSum_Brute_Force(array, m - 1, sum);
        }
        return SubsetSum_Brute_Force(array, m - 1, sum) || SubsetSum_Brute_Force(array, m - 1, sum - array[m - 1]);
    }
}
