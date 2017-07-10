package Chapter8;

/**
 *
 * Created by fyy on 5/26/17.
 */
public class Upcase2 {
}

class Instrument {
    public void play(String n) {
        System.out.println(n+" Instrument play");
    }
}

class Wind extends Instrument {
    @Override
    public void play(String n) {
        System.out.println(n+" wind play");
        super.play("super");
    }
}

class Music {
    private static void tune(Instrument i){
        i.play("this");
    }

    public static void main(String[] args) {
//        Wind f = new Wind();
//        tune(f); //向上转型为Instrument
//        或者可以这么写
          Instrument f = new Wind();//向上转型
          tune(f);
    }
}