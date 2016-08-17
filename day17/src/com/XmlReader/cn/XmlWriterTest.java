/**
 *
 */
package com.XmlReader.cn;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * @author renjianyong
 *
 */
public class XmlWriterTest {

    public static void main(String[] args) throws IOException {
        // 创建一个文本文档
        Document document = DocumentHelper.createDocument();

        // XMLWriter writer = new XMLWriter();

        // 创建一个Root节点
        Element rootNode = document.addElement("书籍列表");
        // 在root节点上创建新的子节点
        Element sonNode = rootNode.addElement("计算机书籍");

        sonNode.setAttributeValue("isbn", "465");
        Element sonBookNameNode = sonNode.addElement("书名");
        Element sonBookPriceNode = sonNode.addElement("价格");

        sonBookNameNode.setText("java");
        sonBookPriceNode.setText("10$");

        // 在root节点上创建新的子节点
        Element sonNodeSecond = rootNode.addElement("计算机书籍");
        sonNodeSecond.setAttributeValue("isbn", "607");
        Element sonBookNameNodeSecond = sonNodeSecond.addElement("书名");
        Element sonBookPriceNodeSecond = sonNodeSecond.addElement("价格");
        sonBookNameNodeSecond.setText("Struts");
        sonBookPriceNodeSecond.setText("17$");

        // 在root节点上创建新的子节点
        Element sonNodeThird = rootNode.addElement("计算机书籍");
        sonNodeThird.setAttributeValue("isbn", "909");
        Element sonBookNameNodeThird = sonNodeThird.addElement("书名");
        Element sonBookPriceNodeThird = sonNodeThird.addElement("价格");
        sonBookNameNodeThird.setText("Spring");
        sonBookPriceNodeThird.setText("50$");

        Element sonNodeForth = rootNode.addElement("计算机书籍");
        sonNodeForth.setAttributeValue("isbn", "9909");
        Element sonBookNameNodeForth = sonNodeForth.addElement("书名");
        Element sonBookPriceNodeForth = sonNodeForth.addElement("价格");
        sonBookNameNodeForth.setText("HHHHHH");
        sonBookPriceNodeForth.setText("50$");
        // 设置字符集编码
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");

        // 新建文件接受
        File newFile = new File("books.xml");

        // 使用IO流中的字符输出流输出（写出到一个新的文件中）
        FileWriter fileWriter = new FileWriter(newFile);
        XMLWriter writer = new XMLWriter(fileWriter, format);

        // 读入信息
        writer.write(document);
        // System.out.println(document);
        // 关闭流(不关闭是不能显示文档中的内容的)
        writer.close();
        fileWriter.close();
    }
}
