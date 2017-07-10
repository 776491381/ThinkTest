package Chapter8;

/**
 * 静态方法不具有多态特性
 * Created by fyy on 5/26/17.
 */
public class staticPoly {
    public static void main(String[] args) {
        StaticSuper sup = new StaticSub(); //向上转型
        System.out.println(sup.get());   //out nonstatic sub
        System.out.println(sup.staticGet()); //out static super
    }


}

class StaticSuper {
    public static String staticGet() {
        return "static super";
    }

    public String get() {
        return "nonstatic super";
    }
}

class StaticSub extends StaticSuper {
    public static String staticGet() {
        return "static sub";
    }

    @Override
    public String get() {
        return "nonstatic sub";
    }
}