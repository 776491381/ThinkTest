package Arithmetic;

import java.util.Arrays;

/**
 * Created by fyy on 6/16/17.
 */
public class KMP {

    private static Integer[] next;

    public static void main(String[] args) {
        String a = "abababababababababababababababababd";
        String b = "abababababHell Hell Helloabababababababababababababababababaababababababababababababababababababab" +
                "babababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "ababababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "ababababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "abababababababababababababababababababababababababababababababababababaabababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "ababababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "ababababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "ababababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "ababababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "ababababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "ababababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "ababababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "abababababababababababababababababababababababababababababababababababababababababababababababababababd";
        next = CreateNext(a.length(), a);
        Analyze(b, a);
        NonKMP.Analyze(b, a);
    }

    private static void Analyze(String a, String b) {
        long start = System.currentTimeMillis();
        int j = 0, i = 0, alen = a.length(), blem = b.length();
        while (i < alen && j < blem) {
            if (j == -1 || a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == blem) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        long end = System.currentTimeMillis();
        System.out.println("KMP :" + (end - start) + " ms");

    }

    private static Integer[] CreateNext(int length, String p) {
        Integer[] nextTemp = new Integer[length];
        Integer[] next = new Integer[length];
        nextTemp[0] = 0;
        String temp;
        int tempMax = 0;
        for (int i = 0; i < length - 1; i++) {
            temp = p.substring(0, i + 2);
            System.out.println(temp + "----------------------");
            for (int j = 0; j < i + 1; j++) {
                if ((temp.substring(0, j + 1).equals(temp.substring(temp.length() - j - 1, temp.length())))) {
                    tempMax = tempMax > (temp.substring(0, j + 1).length()) ? tempMax : temp.substring(0, j + 1).length();
                }
                System.out.println(temp.substring(0, j + 1) + "     " + temp.substring(temp.length() - j - 1, temp.length()));
            }
            nextTemp[i + 1] = tempMax;
            tempMax = 0;
        }
        System.out.println(Arrays.asList(nextTemp));
        next[0] = -1;
        for (int i = 1; i < nextTemp.length; i++) {
            next[i] = i - (i - nextTemp[i - 1]);
        }
        System.out.println(Arrays.asList(next));
        return next;
    }
}
