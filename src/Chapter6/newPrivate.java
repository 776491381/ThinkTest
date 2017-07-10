package Chapter6;

/**
 * 测试静态类实例化构造器为private的类
 * Created by fyy on 5/26/17.
 */
public class newPrivate {
    private  newPrivate(){}
    public static newPrivate getInstance(){
        return new newPrivate();
    }
    public void hello(){
        System.out.println("hello");
    }
    private void hi(){
        System.out.println("Hi");
    }
}
class Test{

    public static void main(String[] args) {
//        newPrivate newPrivate = new newPrivate();
        newPrivate newPrivate = Chapter6.newPrivate.getInstance();
        newPrivate.hello();
    }


}
