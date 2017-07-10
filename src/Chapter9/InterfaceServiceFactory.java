package Chapter9;

/**
 * Created by fyy on 5/28/17.
 */
public class InterfaceServiceFactory {
    public static void serviceConsumer(MyServiceFactory myServiceFactory){
        Service s = myServiceFactory.getService();
        s.method1();
        s.method2();
    }
    public static void main(String[] args) {
       serviceConsumer(new ServiceFactory());
       serviceConsumer(new ServiceFactory2());
    }
}

interface Service{
    void method1();
    void method2();
}
interface MyServiceFactory{
    Service getService();
}

class Impl implements  Service{

    @Override
    public void method1() {
        System.out.println("method 1");
    }

    @Override
    public void method2() {
        System.out.println("method 2");
    }
}

class Impl2 implements  Service{

    @Override
    public void method1() {
        System.out.println("2   method 1");
    }

    @Override
    public void method2() {
        System.out.println("2   method 2");
    }
}

class ServiceFactory2 implements MyServiceFactory{

    @Override
    public Service getService() {
        return new Impl2();
    }
}

class ServiceFactory implements MyServiceFactory{

    @Override
    public Service getService() {
        return new Impl();
    }
}