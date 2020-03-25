package com.junjunlei.o1;

import org.junit.Test;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * 类加载器
 * @author junjun.lei
 * @create 2020-03-25 19:20
 */
public class ClassLoaderTest {
    @Test
    public void test1(){

        //双亲委派  沙箱安全

        //对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        //调用系统类加载器的getParent()：获取扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);
        //调用扩展类加载器的getParent()：无法获取引导类加载器
        //引导类加载器主要负责加载java的核心类库，无法加载自定义类的。
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);

        ClassLoader classLoader3 = String.class.getClassLoader();
        System.out.println(classLoader3);

    }

    /**
     * properties
     */
    @Test
    public void test02() throws Exception {

        Properties properties=new Properties();
        //此时的文件默认在当前module下
        FileInputStream fileInputStream =new FileInputStream("jdbc.properties");
        properties.load(fileInputStream);
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        System.out.println(user);
        System.out.println(password);


        //读取配置文件方式二  使用类加载器
        //配置文件默认识别为当前module src下

        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream in = classLoader.getResourceAsStream("jdbc.properties");
        properties.load(in);
        String user1 = properties.getProperty("user");
        String password1 = properties.getProperty("password");
        System.out.println(user1);
        System.out.println(password1);

    }
}
