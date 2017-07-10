package OtherForAli.RedisTest;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 测试Redis
 * Created by fyy on 6/21/17.
 */
public class FirstRedis {

    public static void main(String[] args) {
        //链接本地的jedis
        Jedis jedis = new Jedis("www.fyypumpkin.cn", 6379);
        System.out.println("Run Successful");
        System.out.println(jedis.ping());
    }

}

/**
 * 连接池
 */
class SecRedis{

    public static void main(String[] args) {

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(8);
        config.setMaxTotal(18);
        JedisPool pool = new JedisPool(config,"www.fyypumpkin.cn");
        Jedis jedis = pool.getResource();
        System.out.println(jedis.ping());



    }


}