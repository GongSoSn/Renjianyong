/**
 *
 */
package com.lecheng.abgame.util;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

/**
 * @author renjianyong XML解析帮助类
 */
public class XMLParseHelper {
    // XML解析帮助方法
    public static Document XMLParseHelper() {
        Document doc = null;
        // 获取需要解析的文件对象
        File parseFile = new File("DataInit.xml");
        // 创建解析器对象
        SAXReader parser = new SAXReader();
        // 获取Document对象
        try {
            doc = parser.read(parseFile);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return doc;
    }
}
