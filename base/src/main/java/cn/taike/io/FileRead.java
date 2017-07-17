package cn.taike.io;

import java.io.*;

/**
 * Created by huayandong on 17/6/12.
 */
public class FileRead {

    private String sourcePath = "/share/json_newest/student/L3NoYXJlL3N2bi8wMDEvMjA2LuWMl-S6rOWIneS6jOS4iuWPo-ivree7g-S5oOmimDYoMSkueGxzeA.json";
    private String targetPath = "/test/save.json";

    //读文件
    public void readFile() {
        File file = new File("/share/json_newest/student/L3NoYXJlL3N2bi8wMDEvMjA2LuWMl-S6rOWIneS6jOS4iuWPo-ivree7g-S5oOmimDYoMSkueGxzeA.json");
        try (InputStream in = new FileInputStream(file)) {
            //创建文件字节数组
            byte[] data = new byte[1024];
            //读取文件内容，放到文件数组中
            int read = in.read(data);
            System.out.println("123:" + read);
            System.out.println("data:" + new String(data));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //写文件
    public void writeFile() {
        File saveFile = new File("/test/save.json");
        if (!saveFile.exists()) {
            try {
                saveFile.createNewFile();
                System.out.println("创建文件");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (OutputStream out = new FileOutputStream(saveFile)) {
            String message = "{\"id\":\"L3NoYXJlL3N2bi8wMDEvMjA2LuWMl-S6rOWIneS6jOS4iuWPo-ivree7g-S5oOmimDYoMSkueGxzeA\",\"name\":\"北京初二上口语练习题6(1)\",\"type\":[]}";
            //将内容转换成字节数组
            byte[] bytes = message.getBytes();
            //向文件写入内容
            out.write(bytes);
            System.out.println("写入完成");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //复制文件
    public void copyFiles() {
        //源文件
        File sourceFile = new File(sourcePath);
        //目标文件
        File targetFile = new File(targetPath);
        if (!targetFile.exists()) {
            try {
                targetFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (InputStream in = new FileInputStream(sourceFile); OutputStream out = new FileOutputStream(targetFile)) {

            //创建字节数组
            byte[] data = new byte[1024];
            int length = 0;
            //循环读取文件内容
            while ((length = in.read(data)) != -1) {
                //将读取到的文件内容写出去
                out.write(data, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void inputFile(File file) {

        if (!file.isFile()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //判断输入的文件是文件还是文件夹
        if (file.isDirectory()) {
            File absoluteFile = file.getAbsoluteFile();
        }

    }


    public static void main(String[] args) {
        FileRead fr = new FileRead();
        fr.copyFiles();


        System.out.println("jhjjjjj");
    }
}
