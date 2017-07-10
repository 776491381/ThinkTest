package Arithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fyy on 6/19/17.
 */
public class NormalTest {

    public static void main(String[] args) {
        List<Integer> listTest = new ArrayList<>();
        Integer var = 11, var2 = 12;
        Integer var3 = 130, var4 = 130;
        Integer var5 = null;
//        int var6 = null;非包装类不能为null
        String var6 = "a,b,c,,";
        String[] arrVar7 = var6.split(",");
        Arrays.asList(arrVar7).forEach(System.out::print);
        System.out.println(arrVar7.length);
        System.out.println((var == var2) + " " + (var3 == var4));
        System.out.println((var.equals(var2) + " " + (var3.equals(var4))));
        List<String> a = new ArrayList<String>();
        a.add("1");
        a.add("2");
        for (String temp : a) {
            if ("1".equals(temp)) {
                a.remove(temp);
            }
        }
        a.forEach(System.out::print);
    }

}
