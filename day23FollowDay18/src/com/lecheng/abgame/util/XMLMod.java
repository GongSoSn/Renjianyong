/**
 *
 */
package com.lecheng.abgame.util;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;

import com.lecheng.abgame.game.Bird;

/**
 * @author renjianyong 修改XML帮助类
 */
public class XMLMod {
    // 修改XML
    public static void modXML(Bird bird) {
        // 获取document对象
        Document doc = XMLParseHelper.XMLParseHelper();
        // 获取root节点
        Element rootNode = doc.getRootElement();
        // 获取birds子节点
        Element birdsNode = rootNode.element("birds");
        // 获取birds下的子节点
        List<Element> birdNodes = birdsNode.elements();
        // 修改属性
        for (Element birdElement : birdNodes) {
            // 根据ID标识修改
            if (Integer.parseInt(birdElement.attributeValue("id")) == bird.getId()) {
                // 逐步修改
                birdElement.element("name").setText(bird.getBirdName());
                birdElement.element("gjValue").setText(bird.getGJValue() + "");
                birdElement.element("hitValue").setText(bird.getHitValue() + "");
            }
        }
        // 写出
        XMLWriterHelper.writerHelper(doc);
        System.out.println("已经修改结束... ...");
    }

    // 修改管理员信息
    public static <T, E> void XMLAdminMod(T paramater, E flag) {
        // 获取document对象
        Document doc = XMLParseHelper.XMLParseHelper();
        // 获取根节点
        Element rootNode = doc.getRootElement();
        // 获取admin子节点
        Element adminNode = rootNode.element("admin");
        // 修改
        if (flag.equals("Name")) {

            adminNode.element("loginName").setText((String) paramater);
        } else if (flag.equals("Pass")) {

            adminNode.element("passWord").setText((String) paramater);
        } else if (flag.equals("Times")) {

            adminNode.element("loginTimes").setText((String) paramater);
        }

        // 写出
        XMLWriterHelper.writerHelper(doc);
        System.out.println("已经修改结束... ...");
    }
}
