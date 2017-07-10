package Chapter7;

/**
 * Created by fyy on 5/26/17.
 */
public class Final {
    private final int a;

    public Final() {
        a = 9;
        System.out.println(a);
    }

    public void testFinalInFuncton() {
        final int b;
//        System.out.println(b);//必须初始化
        b = 9;
        System.out.println(b);
    }

    public static void main(String[] args) {
        Final f = new Final();
        f.testFinalInFuncton();
    }

}
class A{
    final void test(){
        System.out.println("final test");
    }
}
class B extends A{
    //    final  void test(){
//
//    }
    //final 不能被继承
public static void main(String[] args) {
   new B().test1();
}
    void test1(){
        super.test();
    }
}