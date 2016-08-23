/**
 *
 */
package com.lecheng.abgame.util;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;

import com.lecheng.abgame.bean.Bird;
import com.lecheng.abgame.bean.Login;
import com.lecheng.abgame.bean.RedBird;

/**
 * @author renjianyong
 *
 */
public class XMLParser {
    // 解析Birds
    public static List<Bird> parseBird(Document doc) {
        // 定义一个List容器存放解析的bird对象
        List<Bird> birds = new ArrayList<Bird>();
        // 获取root节点
        Element rootNode = doc.getRootElement();
        // 获取birds子节点
        Element birdsNode = rootNode.element("birds");
        // 获取birds节点下的bird子节点
        List<Element> birdNodes = birdsNode.elements();
        // 遍历数据
        Bird bird = null;
        for (Element e : birdNodes) {
            // 获取bird标识‘id’属性
            int identify = Integer.parseInt(e.attributeValue("id"));
            // 根据标识符进行判断bird type
            switch (identify) {
                case 1:// RedBird
                    bird = new RedBird();
                    break;
                case 2:// BlueBird
                    bird = new RedBird();
                    break;
                case 3:// BlackBird
                    bird = new RedBird();
                    break;
                default:
                    System.out.println("不存在此类型的Bird !");
            }
            // 解析信息，set到对象中
            // 解析ID
            bird.setId(identify);
            // 解析(姓名)name
            bird.setBirdName(e.elementText("name"));
            // 解析(攻击力)gjValue
            bird.setGJValue(Integer.parseInt(e.elementText("gjValue")));
            // 解析(命中率)hitValue
            bird.setHitValue(Integer.parseInt(e.elementText("hitValue")));
            // 每次解析一个bird，就添加到容器中
            birds.add(bird);
        }
        return birds;
    }

    // 解析Admin
    public static Login parseAdmin(Document doc) {

        // 创建一个Login对象
        Login login = new Login();
        // 获取root节点
        Element rootNode = doc.getRootElement();
        // 获取admin子节点
        Element adminNode = rootNode.element("admin");
        // 解析获取loginName
        login.setName(adminNode.elementText("loginName"));
        // 解析获取passWord
        login.setPass(adminNode.elementText("passWord"));
        // 解析获取loginTimes
        login.setLoginTimes(Integer.parseInt(adminNode.elementText("loginTimes")));

        return login;
    }
}
