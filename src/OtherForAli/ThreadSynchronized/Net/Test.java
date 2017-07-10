package OtherForAli.ThreadSynchronized.Net;

public class Test {
    public static void main(String[] args) throws Exception {
         /*
          * CircleSequenceQueue queue = new CircleSequenceQueue();
          * queue.append("a"); queue.append("b"); queue.append("c");
          * queue.append("d"); queue.append("e");
          *
          * while (!queue.isEmpty()) { System.out.print(queue.delete() + " "); }
          */

        // 卖票与买票模拟,使用同一个窗口对象
        WindowQueue queue = new WindowQueue();
        // 生产者
        Producer P = new Producer(queue);
        // 消费者
        Consumer c = new Consumer(queue);

        // 排队买票线程
        Thread pThread = new Thread(P);
        // 买票线程
        Thread cThread = new Thread(c);

        pThread.start(); // 开始排队买票
        cThread.start(); // 卖票
    }
}