package OtherForAli.ThreadSynchronized;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Queue;

/**
 * Created by fyy on 7/7/17.
 */
public class Test1 {


    //定义队列最大长度
    int maxSize = 10;
    //用来统计卖票数
    int num = 0;
    //用来判断是否可以继续卖票
    boolean isActive = true;
    //定义队列
    Queue queue = new ArrayDeque(maxSize);


    //排队买票
    public synchronized void producer() throws Exception {

        if (queue.size() < maxSize) {
            queue.add(num++);
            System.out.println("第" + num + "等待买票");
            this.notifyAll();
        } else {
            try {
                System.out.println("队伍已经满了");
                this.wait();
            }catch (Exception ignore){

            }
        }
    }

    //卖票
    public synchronized  void consumer() throws Exception{
        if(queue.size()>0) {
            Object object = queue.remove();
            int temp = Integer.parseInt(object.toString());
            System.out.println("第" + (temp + 1) + "个客户排队买到票离开队列");
            // 如果当前队列为空，并且卖出票的数量的大于等于100说明卖票要结束
            if (queue.isEmpty() && num >= 5) {
                this.isActive = false;
            }
            //队伍离开一人可以进来买票
            this.notifyAll();
        }else {
            try {
                System.out.println("队列已空...请进入队伍准备买票");
                this.wait();
            }catch (Exception ignore){

            }
        }
    }


    public static void main(String[] args) {
        Test1 test1 = new Test1();
        Producer producer = new Producer(test1);
        Consumer consumer = new Consumer(test1);
        Thread pThread = new Thread(producer);
        Thread cThread = new Thread(consumer);
        pThread.start();
        cThread.start();
    }

}

//买票
class  Producer implements  Runnable{

    Test1 test1;

    public Producer(Test1 test1) {
        this.test1 = test1;
    }

    @Override
    public void run() {
        while (test1.num <5){
            try {
                test1.producer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}

//卖票
class Consumer implements Runnable{

    Test1 test1;

    public Consumer(Test1 test1) {
        this.test1 = test1;
    }

    @Override
    public void run() {

        Collection collection = new ArrayList();
        while (test1.isActive){
            try {
                test1.consumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}