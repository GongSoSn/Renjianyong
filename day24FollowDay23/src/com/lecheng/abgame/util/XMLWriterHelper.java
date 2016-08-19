/**
 *
 */
package com.lecheng.abgame.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * @author renjianyong XML写出帮助类
 */
public class XMLWriterHelper {
    // XML写出帮助方法
    public static void writerHelper(Document d) {
        // 创建需要写出的文件对象
        File coverFile = new File("DataInit.xml");
        OutputFormat format = OutputFormat.createPrettyPrint();
        // 设置字符集编码
        format.setEncoding("UTF-8");
        // 转换流
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(coverFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 创建字符流写出对象
        XMLWriter xmlWriter = new XMLWriter(fileWriter, format);
        // 写出
        try {
            xmlWriter.write(d);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 关闭流
        try {
            xmlWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileWriter.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
