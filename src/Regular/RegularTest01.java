package Regular;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by fyy on 6/21/17.
 */
public class RegularTest01 {


    public static void main(String[] args) {
        Pattern p = Pattern.compile(".*good(.*)");
        String a = "hello good morning";
        Matcher m = p.matcher(a);
        while (m.find()){
            System.out.println(m.group());
            System.out.println(m.group(1));
        }



        String b = "AAAA9999BBBB8888CCCC";
        Pattern p2 = Pattern.compile("\\d+");
        System.out.println(Arrays.toString(p2.split(b)));

    }



}
