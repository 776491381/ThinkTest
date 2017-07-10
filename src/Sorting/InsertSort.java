package Sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 直接插入排序
 * Created by fyy on 5/28/17.
 */
public class InsertSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        Integer[] Insert = new Integer[sum];
        for (int i = 0; i < sum; i++) {
            Insert[i] = scanner.nextInt();
        }

        sort(Insert);

    }

    public static void sort(Integer[] Insert) {
        for (int i = 1; i < Insert.length; i++) {
            int current = Insert[i];
            int save = i - 1;
            for (int j = i - 1; j >= 0; j--) {
                if (Insert[j] > current) {
                    Insert[j + 1] = Insert[j];
                } else {
                    save = j;
                    break;
                }
                save = j -1;
            }
            Insert[save+1] = current;
//            Arrays.asList(Insert).forEach(System.out::print);

        }
        Arrays.asList(Insert).forEach(System.out::println);
    }


}
