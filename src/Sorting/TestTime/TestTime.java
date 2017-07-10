package Sorting.TestTime;

import Sorting.BubbleSort;
import Sorting.InsertSort;
import Sorting.ShellSort;

/**
 * Created by fyy on 5/29/17.
 */
public class TestTime {

    public static void main(String[] args) {
        Integer[] test = {11111,22222,21123,45678,6543213,54654745,43234124,5,1,2,4,5,56,56,3,4523,234,5324,543,543,654,634,5,675,765,87,768,76,3435};

        long start,end;
        start = System.currentTimeMillis();
        BubbleSort.sort(test);
        end = System.currentTimeMillis();
        System.out.println("bubble"+(end-start));
        start = System.currentTimeMillis();
        InsertSort.sort(test);
        end = System.currentTimeMillis();
        System.out.println("Insert"+(end-start));
        start = System.currentTimeMillis();
        ShellSort.sort(test,4);
        end = System.currentTimeMillis();
        System.out.println("Shell"+(end-start));
    }



}
