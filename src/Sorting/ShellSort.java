package Sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 希尔排序
 * Created by fyy on 5/28/17.
 */
public class ShellSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        Integer[] shell = new Integer[sum];
        for (int i = 0; i < sum; i++) {
            shell[i] = scanner.nextInt();
        }

        int gap = 3;
        do {
            System.out.println("iii");
            sort(shell, gap);
            gap /= 2;
        }
        while (gap >= 1);

        Arrays.asList(shell).forEach(System.out::print);


    }


    public static void sort(Integer[] Insert, int gap) {
        for (int k = 0; k < gap; k++) {
            for (int i = gap; i < Insert.length; i += gap) {
                int current = Insert[i];
                int save = i - gap;
                for (int j = i - gap; j >= k; j -= gap) {
                    if (Insert[j] > current) {
                        Insert[j + gap] = Insert[j];
                    } else {
                        save = j;
                        break;
                    }
                    save = j - gap;
                }
                Insert[save + gap] = current;
//            Arrays.asList(Insert).forEach(System.out::print);
//                System.out.println();
            }
        }
        Arrays.asList(Insert).forEach(System.out::print);
        System.out.println();
    }
}
