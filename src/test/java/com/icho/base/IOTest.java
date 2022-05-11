package com.icho.base;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.*;
import java.util.Arrays;

/**
 * @Author: icho
 * @Date: 2022/5/6 17:14
 * @Describe:
 */
public class IOTest implements FilenameFilter {

    // InputStream 输入流,从源读取数据
    // OutputStream 输出流,向目标写数据

    // InputStreamReader 将字节流转换为字符流
    // OutputStreamWriter 将字符流转换为字节流

    // TODO 遍历 all directory
    private static void test00() {

    }
    public static void main(String[] args) {
        new IOTest().test08();
    }

    public void test08() {
        File file = new File("F:\\java\\icho-springboot\\src\\test\\java\\com\\icho");
        String[] list = file.list();
        for (String s : list) {
            System.out.println("file name = " + s);
        }
        String[] list1 = file.list(this);
        for (String s : list1) {
            System.out.println("java file name = " + s);
        }
    }
    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(".java");
    }



    // create directory
    // delete directory
    private static void test07() {
        String dirname = "E:/tmp/user/java/bin";
        File file = new File(dirname);
        file.mkdirs();

        File file1 = new File("E:/tmp/user/java");
        deleteFolder(file1);
    }
    private static void deleteFolder(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    deleteFolder(f);
                }else {
                    file.delete();
                }
            }
        }
        file.delete();
    }

    /*
    FileReader 与 FileWriter 是默认编码的文本文件

    当我们使用默认GBK编码保存文本时,下面2句代码其实是一样的效果,
    new OutputStreamWriter(new FileOutputStream(“out.txt”))
    new FileWriter(“out.txt”)

    当要求保存为其他编码比如UTF-8时,就要这样写
    new OutputStreamWriter(new FileOutputStream(“out.txt”),“UTF-8”)
    */
    private static void test06() {
        try {
            File file = new File("E:/Hello.txt");
            //file.createNewFile();
            FileWriter writer = new FileWriter(file);
            writer.write("This\n is\n an\n example\n");
            //writer.write("多喝热水");
            writer.flush();
            writer.close();

            FileReader read = new FileReader(file);
            char[] c = new char[10];
            read.read(c);
            for (char c1 : c) {
                System.out.println(c1);
            }
            read.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void test05() {
        String dirname = "E:/Hello";
        File file = new File(dirname);
        if (file.isDirectory()) {
            System.out.println("Directory of " + dirname);
            String[] list = file.list();
            for (int i = 0; i < list.length; i++) {
                File file1 = new File(dirname + "/" + list[i]);
                if (file1.isDirectory()) {
                    System.out.println(list[i] + " is a directory");
                }else {
                    System.out.println(list[i] + " is a file");
                }
            }
        }else {
            System.out.println(dirname + " is not a directory");
        }

    }

    private static void test04() {
        try {
            File file = new File("E:/a.txt");
            FileOutputStream outputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
            outputStreamWriter.append("英文输入");
            outputStreamWriter.append("\r\n");
            outputStreamWriter.append("Chinese");
            outputStreamWriter.close();
            outputStream.close();

            FileInputStream inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            StringBuilder sb = new StringBuilder();
            while (inputStreamReader.ready()) {
                sb.append((char) inputStreamReader.read());
            }
            System.out.println(sb.toString());
            inputStreamReader.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void test03() {
        try {
            byte[] bWrite = {11, 21, 3, 40, 5};
            FileOutputStream outputStream = new FileOutputStream("E:/test.txt");
            //OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
            for (byte b : bWrite) {
                outputStream.write(b);
            }

            //outputStreamWriter.close();
            outputStream.close();

            FileInputStream inputStream = new FileInputStream("E:/test.txt");
            //InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"UTF-8");
            //StringBuilder sb = new StringBuilder();
            /*while (inputStreamReader.ready()) {
                sb.append((char) inputStreamReader.read());
            }*/
            int size = inputStream.available();
            for (int i = 0; i < size; i++) {
                System.out.println((byte) inputStream.read());
            }
            //System.out.println(sb.toString());
            //inputStreamReader.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // FileInputStream
    private static void test02() {
        try {
            FileInputStream inputStream1 = new FileInputStream("studentStream.txt");

            File file = new File("studentStream.txt");
            FileInputStream inputStream2 = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void test01() {
        char c = 0;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入字符, 按下 'q' 键退出。");
        do {
            try {
                c = (char) bufferedReader.read();
                System.out.println(c);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }while (c != 'q');
    }
}
