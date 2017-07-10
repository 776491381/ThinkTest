package Chapter9;

import java.util.Scanner;

/**
 * Created by fyy on 5/28/17.
 */
public class ExtendsInterface {


    public static void main(String[] args) {
        Man man = new TestMan();
        Woman woman = new TestWoman();
        man.eat();
        man.man();
        woman.eat();
        woman.woman();
    }


}

class TestMan implements Man {

    @Override
    public void eat() {
        System.out.println("man eat");
    }

    @Override
    public void man() {
        System.out.println("i am a man");
    }
}

class TestWoman implements Woman {

    @Override
    public void eat() {
        System.out.println("woman eat");
    }

    @Override
    public void woman() {
        System.out.println("i am a woman");
    }
}

interface Person {
    void eat();
}

interface Man extends Person {
    void man();
}

interface Woman extends Person {
    void woman();
}