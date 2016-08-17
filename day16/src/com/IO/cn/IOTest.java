/**
 *
 */
package com.IO.cn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.junit.Test;

/**
 * @author renjianyong
 *
 */
public class IOTest {

    // 字节流的读写
    @Test
    public void test() throws Exception {
        File file = new File(
                "K:\\study_space\\Java\\eclipse-jee-mars-1-win32-x86_64\\eclipse\\myWorkspace\\files\\从此以后.mp3");

        FileInputStream inputStream = new FileInputStream(file);

        int i = 0;

        File copyfile = new File(
                "K:\\study_space\\Java\\eclipse-jee-mars-1-win32-x86_64\\eclipse\\myWorkspace\\files\\从此以后--副本.mp3");

        FileOutputStream outputStream = new FileOutputStream(copyfile);

        while ((i = inputStream.read()) != -1) {
            outputStream.write(i);
        }
        // 关闭
        outputStream.close();
        inputStream.close();
    }

    // 字节流的读写(使用byte[])
    @Test
    public void ioTest01() throws IOException {
        File file = new File(
                "K:\\study_space\\Java\\eclipse-jee-mars-1-win32-x86_64\\eclipse\\myWorkspace\\files\\从此以后.mp3");
        InputStream inputStream = new FileInputStream(file);

        File copyfile = new File(
                "K:\\study_space\\Java\\eclipse-jee-mars-1-win32-x86_64\\eclipse\\myWorkspace\\files\\从此以后--副本.mp3");

        OutputStream outputStream = new FileOutputStream(copyfile);

        byte[] bytes = new byte[1024];

        while (inputStream.read(bytes) != -1) {
            outputStream.write(bytes, 0, bytes.length);
        }
        // 关闭
        outputStream.close();
        inputStream.close();
    }

    // 字符流读写
    @Test
    public void test02() throws IOException {
        File file = new File(
                "K:\\study_space\\Java\\eclipse-jee-mars-1-win32-x86_64\\eclipse\\myWorkspace\\files\\test.txt");

        FileReader fileReader = new FileReader(file);
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));

        File copyFile = new File(
                "K:\\study_space\\Java\\eclipse-jee-mars-1-win32-x86_64\\eclipse\\myWorkspace\\files\\test--副本.txt");
        OutputStreamWriter outputStreamWriter =
                new OutputStreamWriter(new FileOutputStream(copyFile));

        int c = 0;
        while ((c = inputStreamReader.read()) != -1) {
            System.out.print((char) c + "  ");
            outputStreamWriter.write(c);
        }
        outputStreamWriter.close();
        inputStreamReader.close();
    }

    @Test
    public void test03() throws Exception {
        // 定位目标文件
        File file = new File(
                "K:\\study_space\\Java\\eclipse-jee-mars-1-win32-x86_64\\eclipse\\myWorkspace\\files\\test.txt");
        // 创建输入转换流
        InputStream inputStream = new FileInputStream(file);
        // 创建输入字符流
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        File copyFile = new File(
                "K:\\study_space\\Java\\eclipse-jee-mars-1-win32-x86_64\\eclipse\\myWorkspace\\files\\test--副本.txt");
        OutputStream outputStream = new FileOutputStream(copyFile);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);

        char[] characters = new char[1024];

        int next = 0;
        while ((next = inputStreamReader.read(characters)) != -1) {
            System.out.println((char) next);
            outputStreamWriter.write(characters, 0, characters.length);
        }
        outputStreamWriter.close();
        inputStreamReader.close();
    }

    @Test
    public void test04() throws Exception {
        File file = new File(
                "K:\\study_space\\Java\\eclipse-jee-mars-1-win32-x86_64\\eclipse\\myWorkspace\\files\\test.txt");


        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        File copyFile = new File(
                "K:\\study_space\\Java\\eclipse-jee-mars-1-win32-x86_64\\eclipse\\myWorkspace\\files\\test--副本.txt");


        OutputStreamWriter outputStreamWriter =
                new OutputStreamWriter(new FileOutputStream(copyFile));

        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        String str = null;
        if (bufferedReader != null && bufferedWriter != null) {
            while ((str = bufferedReader.readLine()) != null) {
                System.out.println(str);
                bufferedWriter.write(str);
            }
        }
        bufferedWriter.close();
        bufferedReader.close();
    }

    // File.separator
    @Test
    public void test05() {

        File file = new File("K:" + File.separator + "study_space" + File.separator + "Java"
                + File.separator + "eclipse-jee-mars-1-win32-x86_64" + File.separator + "eclipse"
                + File.separator + "myWorkspace" + File.separator + "files" + File.separator
                + "从此以后.mp3");

        long length = file.length();
        System.out.println("File length : " + length / 1024.0);
    }
}
