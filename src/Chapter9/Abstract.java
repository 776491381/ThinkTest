package Chapter9;

/**
 *
 * Created by fyy on 5/26/17.
 */
public class Abstract {

    public static void tune(Instrument i){
        i.play(" Test");
    }
    public static String testWhat(Instrument i){
        return i.what();
    }
    public static void main(String[] args) {
        Instrument wind = new Wind();
        tune(wind);
        System.out.println(testWhat(wind));
    }

}

/**
 * 抽象类可以有方法体,除了不能实例化，其他都和普通类一样
 */
abstract class Instrument {
    public int i = 9;

    public abstract void play(String n);

    public String what(){
        return "Instrument";
    }
}

class Wind extends Instrument{
    @Override
    public void play(String n) {
        System.out.println("Wind play"+" "+super.i +" "+n);
    }

    @Override
    public String what() {
        System.out.println(super.what());
        return "Wind Instrument";
    }
}


