package Chapter8;

/**
 * 向上转型
 * Created by fyy on 5/24/17.
 */
public class Upcase {
    public static void main(String[] args) {
        A a = new B();   //子类向上转型为父类
        C c = new B();
        B b = new B();
        a.a1();
        c.c();
        b.a1();
        b.b1();
        b.c();
    }

}

class A {

    public void a1() {
        System.out.println("Super class A");
    }

}

class B extends A implements C{
    @Override
    public void a1() {
        System.out.println("Override super \n Child class B");
    }
    public void b1(){
        System.out.println("Child class B.b1");
    }

    @Override
    public void c() {
        System.out.println("Interface C");
    }
}


interface C{
    void c();
}