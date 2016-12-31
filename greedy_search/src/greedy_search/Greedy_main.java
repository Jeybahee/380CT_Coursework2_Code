package greedy_search;

import java.util.Random;

public class Greedy_main {

    public static void main(String[] args) {

        for (int a = 20; a < 100000; a = a * 2) {
            long startTime = System.nanoTime();
            //System.out.print(beginGreedy(a) + " ");
            begin(a);
            System.out.println((System.nanoTime() - startTime));
            //System.out.println("(" + status + ") took " + ((System.nanoTime() - startTime) / 100) + " nano second(s).");
        }
    }

    public static boolean begin(int size) {
        int[] array = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(1000) + 1;
        }

        int sum = 1700;
        int len = array.length;

        if (SubsetSum_Greedy(array, len, sum) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static int SubsetSum_Greedy(int array[], int len, int sum) {
        int total = 0;
        int i = 0;
//        List subset = new ArrayList<>();

        while (i <= len - 1) {
            if (total + array[i] <= sum) {
                total = total + array[i];
//                subset.add(array[i]);
            }
            if(total == sum) {
                break;
            }
            i++;
        }

//        for (int a = 0; a < subset.size(); a++) {
//            System.out.print(subset.get(a).toString() + " ");
//        }
        return sum - total;
    }
}
