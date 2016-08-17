/**
 *
 */
package com.XmlReader.cn;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * @author renjianyong
 *
 */
public class XmlParseTest {

    public static void main(String[] args) throws DocumentException, IOException {

        // 使用SAXReader解析XML文档
        // 创建解析文件
        File parseXml = new File("books.xml");
        // 创建解析器
        SAXReader saxReader = new SAXReader();
        // 开始解析
        Document document = saxReader.read(parseXml);
        // 获取根节点
        Element rootNode = document.getRootElement();
        // 获取子节点的集合
        List<Element> elements = rootNode.elements();
        // 遍历
        Iterator iterator = elements.iterator();
        // 读出
        XMLWriter writer = new XMLWriter();
        writer.write(elements.get(0));
        while (iterator.hasNext()) {
            // System.out.println(iterator.next());
            writer.write(iterator.next());
        }
    }
}
