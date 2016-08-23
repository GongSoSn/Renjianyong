/**
 *
 */
package com.lecheng.abgame.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author renjianyong
 *
 */
public class SQLHelper {

    // 从外部获取SQL
    public static String getSQL(String key) {
        String sql = "";

        File file = new File("sqls.properties");
        InputStream in = null;
        try {
            in = new FileInputStream(file);
            Properties prop = new Properties();
            prop.load(in);
            sql = prop.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sql;
    }
}
