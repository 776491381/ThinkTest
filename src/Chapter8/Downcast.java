package Chapter8;

/**
 * Created by fyy on 5/26/17.
 */
public class Downcast {
    public static void main(String[] args) {
        Useful x[] = {
                new Useful(),
                new MoreUseful()
        };
        x[0] .f();
        x[1] .f();
        x[0] .g();
        x[1] .g();
        ((MoreUseful)x[0]) .h(); //向下转型
        ((MoreUseful)x[1]) .h();
    }
}

class Useful {

    public void f() {}

    public void g() {}

}
class MoreUseful extends  Useful{

    public void f() {}

    public void g() {}

    public void h() {}

    public void i() {}

    public void j() {}

    public void k() {}

}