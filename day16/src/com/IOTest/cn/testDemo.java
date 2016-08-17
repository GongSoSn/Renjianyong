/**
 *
 */
package com.IOTest.cn;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

import org.junit.Test;

/**
 * @author renjianyong
 *
 */
public class testDemo {
    /**
     * 使用字节流读入和写出文件信息
     * 基于字符流的抽象父类：InputStream(实现类：访问文件FileInputStream)和OutputStream(实现类：访问文件FileOutPutSream)
     */
    @Test
    public void inputStreamTest01() throws IOException {
        // 源文件
        File file = new File("K:" + File.separator + "study_space" + File.separator + "Java"
                + File.separator + "eclipse-jee-mars-1-win32-x86_64" + File.separator + "eclipse"
                + File.separator + "myWorkspace" + File.separator + "files" + File.separator
                + "test.txt");
        // 创建inputstream（抽象类）实现类对象(多态)
        InputStream inputStream = new FileInputStream(file);
        // 创建一个新文件接收从内存中读出的信息
        File newFile = new File(
                "K:/study_space/Java/eclipse-jee-mars-1-win32-x86_64/eclipse/myWorkspace/files/test--副本.txt");
        // 创建outStream实现类的对象
        OutputStream outputStream = new FileOutputStream(newFile);
        // 开始读入内存
        int count = 0;
        while ((count = inputStream.read()) != -1) {
            // 每读入一次就写出一次
            outputStream.write(count);
        }
    }

    /**
     * 使用字节流读入和写出文件信息 || 基于字符流抽象父类：InputSream(实现类：缓冲流)和OutputSream(实现类：缓冲流)
     *
     * @throws IOException
     */
    @Test
    public void InputStreamTest02() throws IOException {
        // 通过连接原文件创建一个基于此文件的对象
        File file = new File("K:" + File.separator + "study_space" + File.separator + "Java"
                + File.separator + "eclipse-jee-mars-1-win32-x86_64" + File.separator + "eclipse"
                + File.separator + "myWorkspace" + File.separator + "files" + File.separator
                + "test.txt");
        // 创建一个文件对象(基于一个新建的文件)
        File newfile = new File("K:" + File.separator + "study_space" + File.separator + "Java"
                + File.separator + "eclipse-jee-mars-1-win32-x86_64" + File.separator + "eclipse"
                + File.separator + "myWorkspace" + File.separator + "files" + File.separator
                + "test--副本.txt");
        // 创建缓冲流对象(读入/写出)

        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(newfile));

        // 读入--->写出
        // 第一种方式：
        // int count = 0;
        // while ((count = inputStream.read()) != -1) {
        // outputStream.write(count);
        // }
        // 第二种方式：
        byte[] bytes = new byte[1024];
        int count = 0;
        for (; (count = inputStream.read(bytes)) != -1;) {
            outputStream.write(bytes, 0, bytes.length);
        }
        // 关闭输入/输出流
        outputStream.close();
        inputStream.close();
    }

    /**
     * 使用字符流方式读取文件信息 || 使用Reader和Writer 抽象类
     *
     * @throws IOException
     */
    @Test
    public void charReaderTest() throws IOException {
        // 创建需要读取的文件对象
        File file = new File("K:" + File.separator + "study_space" + File.separator + "Java"
                + File.separator + "eclipse-jee-mars-1-win32-x86_64" + File.separator + "eclipse"
                + File.separator + "myWorkspace" + File.separator + "files" + File.separator
                + "test.txt");
        // 创建需要写出的文件对象
        File newFile = new File("K:" + File.separator + "study_space" + File.separator + "Java"
                + File.separator + "eclipse-jee-mars-1-win32-x86_64" + File.separator + "eclipse"
                + File.separator + "myWorkspace" + File.separator + "files" + File.separator
                + "test--副本-字符流.txt");
        // 创建字符流的输入和输出对象
        Reader reader = new FileReader(file);
        Writer writer = new FileWriter(newFile);
        // 进行读写操作
        int count = 0;
        while ((count = reader.read()) != -1) {
            System.out.print((char) count);
            writer.write((char) count);
        }
        // 关闭输入输出流
        writer.close();
        reader.close();
    }

    @Test
    public void readerTest() throws IOException {
        // 创建需要读取的文件对象
        File file = new File("K:" + File.separator + "study_space" + File.separator + "Java"
                + File.separator + "eclipse-jee-mars-1-win32-x86_64" + File.separator + "eclipse"
                + File.separator + "myWorkspace" + File.separator + "files" + File.separator
                + "test.txt");
        // 创建需要写出的文件对象
        File newFile = new File("K:" + File.separator + "study_space" + File.separator + "Java"
                + File.separator + "eclipse-jee-mars-1-win32-x86_64" + File.separator + "eclipse"
                + File.separator + "myWorkspace" + File.separator + "files" + File.separator
                + "test--副本-字符流缓冲.txt");
        // 创建缓冲流
        InputStreamReader input = new InputStreamReader(new FileInputStream(file));
        BufferedReader bufferedReader = new BufferedReader(input);
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(newFile));
        BufferedWriter bufferedWriter = new BufferedWriter(out);
        // 读写文件信息
        int count = 0;
        while ((count = input.read()) != -1) {
            out.write(count);
        }
        // 关闭
        input.close();
        out.close();
    }
}
