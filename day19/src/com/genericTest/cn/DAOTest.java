/**
 *
 */
package com.genericTest.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author renjianyong
 *
 */
public class DAOTest {
    public static void main(String[] args) {

        DAO<User> dao = new DAO<>();

        Map<String, User> userMap = new HashMap<>();
        userMap.put("001", new User(1, 23, "1111"));
        userMap.put("002", new User(1, 23, "2222"));
        userMap.put("003", new User(1, 23, "3333"));
        userMap.put("004", new User(1, 23, "4444"));
        dao.setMap(userMap);

        System.out.println(dao.get("004"));

        dao.save("005", new User(1, 23, "5555"));

        System.out.println(userMap);

        System.out.println(dao.get("003"));

        dao.delete("003");

        System.out.println(dao.get("003"));

        dao.update("005", new User(1, 23, "update"));

        System.out.println(dao.get("005"));

        System.out.println(dao.list());
    }
}
