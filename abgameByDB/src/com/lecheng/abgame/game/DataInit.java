package com.lecheng.abgame.game;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import com.lecheng.abgame.bean.Login;
import com.lecheng.abgame.util.XMLParser;

/**
 * @author renjianyong
 *
 */
public class DataInit {

    // 创建需要解析的文件对象
    File parseFile = new File("DataInit.xml");
    // 创建解析器对象
    SAXReader parser = new SAXReader();

    // 初始化bird
    public List<Bird> initBird() {
        // 创建一个List容器
        List<Bird> birds = new ArrayList<Bird>();
        try {
            // 获取解析的文档
            Document doc = parser.read(parseFile);
            // 获取解析出来的bird对象
            birds = XMLParser.parseBird(doc);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return birds;
    }

    // 初始化admin
    public Login initAdmin() {
        // 创建一个Login对象
        Login login = new Login();
        try {
            // 获取解析文档
            Document doc = parser.read(parseFile);
            // 获取解析出来的admin对象
            login = XMLParser.parseAdmin(doc);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return login;
    }
}
