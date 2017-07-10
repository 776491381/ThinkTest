package OtherForAli.ThreadSynchronized.Net;

/**
 * Created by fyy on 7/8/17.
 */
//队列接口
public interface Queue {

    // 入队
    public void append(Object obj) throws Exception;

    // 出队
    public Object delete() throws Exception;

    // 获得对头元素
    public Object getFront() throws Exception;

    // 判断是否为空
    public boolean isEmpty();

}