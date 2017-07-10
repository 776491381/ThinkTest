package OtherForAli.RedisMQ;

import java.io.*;

/**
 * 对象处理工具
 * Created by fyy on 6/20/17.
 */
public class ObjectUtil {

    /**
     * 将对象转为字节流
     *
     * @param obj 传入对象
     * @return 返回字节数组
     * @throws IOException 异常
     */
    public static byte[] object2Bytes(Object obj) throws IOException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(obj);
        byte[] bytes = bo.toByteArray();
        bo.close();
        oo.close();
        return bytes;
    }

    /**
     * 将字节流转换为对象
     *
     * @param arr 传入字节数组
     * @return 返回对象
     * @throws Exception 异常
     */
    public static Object bytes2Object(byte[] arr) throws Exception {
        ByteArrayInputStream bi = new ByteArrayInputStream(arr);
        ObjectInputStream oi = new ObjectInputStream(bi);
        return oi.readObject();


    }


}
