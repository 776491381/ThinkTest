package Chapter9;

/**
 * Created by fyy on 5/28/17.
 */
public class NestingInterface {
    public static void main(String[] args) {
        A a = new A();
        A.B b = a.new BImpl();//非静态内部类需要外部类实例访问
        A.C c = new A.CImpl();//静态内部类可以直接访问
        a.AcessPrivateInterfaceD(a.getD());
    }
}

class EImpl implements E{

    @Override
    public void g() {
        System.out.println("E IMpl");
    }
}

class EGImpl implements E.G{

    @Override
    public void f() {
        System.out.println("E.G Impl");
    }
}
class A {

    interface B {
        void f();
    }

    public class BImpl implements B {

        @Override
        public void f() {
            System.out.println("public interface b Impl");
        }
    }

    interface C {
        void f();
    }

    public static class CImpl implements C {

        @Override
        public void f() {
            System.out.println("public interface c Impl");
        }
    }

    private interface D {
        void f();
    }

    public class DImpl implements D {

        @Override
        public void f() {
            System.out.println("private interface d impl");
        }
    }


    public D getD() {
        return new DImpl();
    }

    public void AcessPrivateInterfaceD(D d) {
        d.f();
    }


}

interface  E{
    interface G{
        void f();
    }

    void g();
    //interface终不能private
//    private interface H{
//
//    }
}