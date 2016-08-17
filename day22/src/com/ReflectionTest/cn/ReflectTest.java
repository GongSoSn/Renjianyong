/**
 *
 */
package com.ReflectionTest.cn;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

/**
 * @author renjianyong
 *
 */
public class ReflectTest {

    @Test
    public void test01() {
        int[] ints = new int[10];
        Class<?> clazz = ints.getClass();
        System.out.println(clazz);
    }

    @Test
    public void test02() {
        try {
            Class<Person> clazz = (Class<Person>) Class.forName("com.RefllectionTest.cn.Person");

            // Method[] ms = clazz.getMethods();
            Method[] ms = clazz.getDeclaredMethods();
            System.out.println(ms);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void test03() throws Exception {
        Class clazz = Person.class;
        System.out.println(clazz.getName());

        Class clazz02 = new Person().getClass();
        System.out.println(clazz02.getName());
        System.out.println("Person类加载器：" + new Person().getClass().getClassLoader());
        String className = "com.RefllectionTest.cn.Person";
        try {
            Class clazz03 = Class.forName(className);
            System.out.println(clazz03.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ClassLoader loader = this.getClass().getClassLoader();
        System.out.println(loader);
        Class clazz05 = loader.loadClass(className);
        System.out.println(clazz05.getName());
    }

    @Test
    public void test04() {
        // 获取Class对象
        Class c = Person.class;
        // 获取属性
        Field[] fs = c.getFields();

        for (Field f : fs) {
            System.out.println(f.getName());
        }
    }

    @Test
    public void test05() throws Exception {
        // 获取Class对象
        Class c = Person.class;
        Person p = (Person) c.newInstance();
        // 获取属性
        Field[] fs = c.getDeclaredFields();

        for (Field f : fs) {
            System.out.println(f.getName());
            // f.set(p, 23);
        }
    }

    @Test
    public void test06() throws Exception {
        // 获取Class对象
        Class c = Person.class;
        Person p = (Person) c.newInstance();
        // 获取属性
        Field name = c.getDeclaredField("name");
        System.out.println(name.getName());
        System.out.println(p);
        name.setAccessible(true);
        name.set(p, "Join");
        System.out.println(p);
    }

    @Test
    public void test07() throws Exception {
        // 获取Class对象
        Class c = Person.class;
        Person p = (Person) c.newInstance();

        Method get = c.getDeclaredMethod("say", String.class);
        System.out.println(get.getName());
        get.invoke(p, "Hello");
    }
}


