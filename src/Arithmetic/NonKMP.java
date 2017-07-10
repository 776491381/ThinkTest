package Arithmetic;

/**
 * 分析子串
 * Created by fyy on 6/15/17.
 */
public class NonKMP {

    public static void main(String[] args) {

        String a = "Hello";
        String b = "Hell Hell Hello";
        Analyze(b, a);

    }
    public static void Analyze(String a, String b) {
        long start  = System.currentTimeMillis();
        int j = 0, i = 0, alen = a.length(), blem = b.length();
        while (i < alen && j < blem) {
            if (j == -1 || a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == blem) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        long end = System.currentTimeMillis();
        System.out.println("NONKMP :"+(end-start)+" ms");
    }

}