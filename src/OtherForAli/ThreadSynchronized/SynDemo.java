package OtherForAli.ThreadSynchronized;

/**
 * synchroni保证了可见性和原子性
 * Created by fyy on 7/10/17.
 */
public class SynDemo {

    private boolean ready = false;
    private int result = 0;
    private int number = 1;

    //写操作
    public synchronized void write() {
        ready = true;
        number = 2;
    }

    //读操作
    public synchronized  void read() {
        if (ready) {
            result = number * 3;
        }
        System.out.println(result);
    }

    private class ReadWriteThread extends  Thread{
        private boolean flag;
        public ReadWriteThread(boolean flag){
            this.flag = flag;
        }

        @Override
        public void run() {
            if(flag){
                write();
            }else {
                read();
            }
        }
    }

    public static void main(String[] args) {
        SynDemo synDemo = new SynDemo();
        synDemo.new ReadWriteThread(true).start();
        synDemo.new ReadWriteThread(false).start();


    }



}
