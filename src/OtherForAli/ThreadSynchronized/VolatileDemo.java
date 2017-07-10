package OtherForAli.ThreadSynchronized;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * volatile能够提供可见性但不保证原子性
 * volatile写操作会在操作后加一条store指令
 * volatile读操作后加一条load指令
 * Created by fyy on 7/10/17.
 */


public class VolatileDemo {
    /*
      private int num = 0;
      num ++;不是原子操作
      {
      1.读取num的值
      2.将num+1；
      3.写入num值
      }

      synchronized(this){
      num++;变换为原子操作
      }

      private volatile int num = 0;
      可见但不是原子操作

       lock 和 synchronize能保证原子性和可见性
     */

    private Lock lock = new ReentrantLock();

    //尽量保证共享变量为private的，通过set get方法获取
    private int number = 0;
//    private volatile int number = 0;

    public int getNumber() {
        return this.number;
    }

    public void increase() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.lock();
        //防止lock中抛出异常
        try {
            this.number++;
        } finally {
            lock.unlock();
        }

    }
//    使用synchronize保证原子性和可见性
//    public void increase(){
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        synchronized (this) {
//            this.number++;
//        }
//    }


    public static void main(String[] args) {
        final VolatileDemo volatileDemo = new VolatileDemo();
        for (int i = 0; i < 500; i++) {
            new Thread(volatileDemo::increase).start();
        }

        //如果还有子线程，主线程让出cpu知道没有子线程在执行打印
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }


        System.out.println(volatileDemo.getNumber());
    }


}
