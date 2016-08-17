/**
 *
 */
package com.Hashtable.cn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

/**
 * @author renjianyong
 *
 */
public class PropertiesTest {
    @Test
    public void test() throws FileNotFoundException, IOException {
        Properties props = new Properties();

        // 加载属性文件
        props.load(new FileInputStream(new File("user.properties")));

        // 加载之后读取
        String userName = props.getProperty("userName");
        System.out.println(userName);
        String userPass = props.getProperty("userPass");
        System.out.println(userPass);
    }
}
