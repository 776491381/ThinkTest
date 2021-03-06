package OtherForAli.RedisMQ;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;


/**
 * Jedis
 * Created by fyy on 6/20/17.
 */
public class JedisUtil {

    public static JedisPool getJedisPool(){
        ResourceBundle bundle=ResourceBundle.getBundle("redis");
        String host=bundle.getString("host");
        int port=Integer.valueOf(bundle.getString("port"));
        int timeout=Integer.valueOf(bundle.getString("timeout"));
//  String password=bundle.getString("password");

        JedisPoolConfig config=new JedisPoolConfig();
//        config.setMaxActive(Integer.valueOf(bundle.getString("maxActive")));
//        config.setMaxWait(Integer.valueOf(bundle.getString("maxWait")));
        config.setTestOnBorrow(Boolean.valueOf(bundle.getString("testOnBorrow")));
        config.setTestOnReturn(Boolean.valueOf(bundle.getString("testOnReturn")));

        JedisPool pool=new JedisPool(config, host, port, timeout);

        return pool;
    }

}
