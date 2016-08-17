/**
 *
 */
package com.XmlReader.cn;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * @author renjianyong
 *
 */
public class ModXmLTest {
    /**
     * 解析文件 ===> 修改文件
     *
     * @throws DocumentException
     * @throws IOException
     */
    public static void main(String[] args) throws DocumentException, IOException {
        // 创建需要解析文件对象
        File parseFile = new File("books.xml");
        // 获取解析对象
        SAXReader parser = new SAXReader();
        // 开始解析
        Document doc = parser.read(parseFile);
        // 获取root节点
        Element rootNode = doc.getRootElement();
        // 修改第一个子节点中的“书名”和内容
        // 获取该节点
        Element booksName = rootNode.element("计算机书籍").element("书名");
        booksName.setName("BookName");
        booksName.setText("又又修改过的书籍");
        // 将修改过的文本写入到原来的文件中
        FileWriter fWriter = new FileWriter(parseFile);
        // 设置字符集编码格式
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");
        // 开始写入内存(覆盖原来的文件)
        XMLWriter cover = new XMLWriter(fWriter, format);
        cover.write(doc);
        // 关闭输出流
        cover.close();
        fWriter.close();
        // 写出
        // XMLWriter writer = new XMLWriter();
        // writer.write(booksName);
    }
}
