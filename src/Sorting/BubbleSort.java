package Sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by fyy on 5/28/17.
 */
public class BubbleSort {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        Integer[] bubble = new Integer[sum];
        for(int i = 0;i<sum;i++){
            bubble[i] = scanner.nextInt();
        }

        sort(bubble);
    }


    public static void sort(Integer[] bubble){
        for(int i = 0;i<bubble.length;i++){
            for(int j = 0;j< bubble.length-1-i;j++){
                if(bubble[j] > bubble[j+1]){
                    int temp = bubble[j];
                    bubble[j] = bubble[j+1];
                    bubble[j+1] = temp;
                }
            }
        }
        Arrays.asList(bubble).forEach(System.out::println);
    }
}
