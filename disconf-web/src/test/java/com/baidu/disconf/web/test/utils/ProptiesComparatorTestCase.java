package com.baidu.disconf.web.test.utils;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Created by qihongwei on 2016/9/29.
 */
public class ProptiesComparatorTestCase {

    @Test
    public void test1() throws IOException {
        String dbData  = "promotionMS.redis.host=10.20.65.133\\npromotionMS.redis.port=6379\\npromotionMS.redis.password=nopass\\npromotionMS.redis.timeout=3000\\npromotionMS.redis.maxActive=500\\npromotionMS.redis.maxIdle=300\\npromotionMS.redis.maxWait=100000\\npromotionMS.redis.testOnBorrow=false";
        String dbData2  = "promotionMS.redis.host=10.20.65.133\npromotionMS.redis.port=6379\npromotionMS.redis.password=nopass\npromotionMS.redis.timeout=3000\npromotionMS.redis.maxActive=500\npromotionMS.redis.maxIdle=300\npromotionMS.redis.maxWait=100000\npromotionMS.redis.testOnBorrow=false";
        String dbData3 ="pushmsg.redis.host=192.168.106.112\r\npushmsg.redis.port=6379\r\npushmsg.redis.password=testredis\r\npushmsg.redis.timeout=15000\r\npushmsg.redis.maxActive=500\r\npushmsg.redis.maxIdle=300\r\npushmsg.redis.maxWait=100000\r\npushmsg.redis.testOnBorrow=false\r\n";
        String dbData4 = "pushmsg.redis.host=192.168.106.112\n" +
                "pushmsg.redis.port=6379\n" +
                "pushmsg.redis.password=testredis\n" +
                "pushmsg.redis.timeout=15000\n" ;
        Properties prop = new Properties();
//        dbData = dbData.replaceAll("\\r\\n","\\n");
          dbData = dbData.replaceAll("\\\\n","\n");
          dbData = dbData.replaceAll("\n","\r\n");
            prop.load(IOUtils.toInputStream(dbData));
        for (Object key : prop.keySet()) {
            System.out.println(key + "是：" + prop.get(key));
        }

    }

    @Test
    public void test2() throws  IOException {
        //将properties文件加载到输入字节流中
        InputStream is = new FileInputStream("D:\\test.properties");
        String fileString = IOUtils.toString(is);
        //创建一个Properties容器
        Properties prop = new Properties();
        //从流中加载properties文件信息
        //prop.load(is);
        prop.load(IOUtils.toInputStream(fileString));
        //循环输出配置信息
        for (Object key : prop.keySet()) {
            System.out.println(key + "是：" + prop.get(key));
        }
    }
}
