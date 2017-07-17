package cn.taike.folder;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;

import java.io.File;
import java.io.FileFilter;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/**
 * Created by huayandong on 17/5/25.
 */
public class FileRunning {

    //用于保存文件的集合要定义在成员位置，否则在递归调用goFolder方法的时候集合会被初始化，数据保存失败！
    static List<File> fileList = Lists.newArrayList();

    public static List<File> goFolder(File file) {
        //List<File> fileList = Lists.newArrayList();
        File[] files = file.listFiles();
        for (File f : files) {
            if (!f.isDirectory()) {
                if (isCondition(f)) {
                    fileList.add(f);
                }
            } else {
                goFolder(f);
            }
        }
        return fileList;
    }

    //遍历时过滤条件
    private static boolean isCondition(File file) {
        if (!(file.getName().startsWith("~")) && file.getName().endsWith(".jpg")) {
            return true;
        }
        return false;
    }


    //定义过滤器，接受满足条件的文件
    public static FileFilter fileFilter = FileFilterUtils.and(
            FileFilterUtils.fileFileFilter(),
            FileFilterUtils.notFileFilter(
                    FileFilterUtils.prefixFileFilter("~$")
            ),
            FileFilterUtils.suffixFileFilter(".jpg")
    );

    //使用Java8的方式遍历文件
    public static List<File> goFolder2(File file) {
        try {
            //返回值是遍历文件的路径
            Path path = Files.walkFileTree(
                    file.toPath(),
                    EnumSet.allOf(FileVisitOption.class),
                    Integer.MAX_VALUE,
                    new SimpleFileVisitor<Path>() {
                        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                            if (fileFilter.accept(file.toFile())) {
                                fileList.add(file.toFile());
                            }
                            return FileVisitResult.CONTINUE;
                        }
                    }
            );
            System.out.println("文件路径:" + path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileList;
    }


    //使用文件过滤的方式遍历文件
    public static List<File> goFolder3(File file) {
        Collection<File> files = FileUtils.listFiles(
                file,
                FileFilterUtils.and(
                        FileFilterUtils.fileFileFilter(),
                        FileFilterUtils.notFileFilter(
                                FileFilterUtils.prefixFileFilter("~$")
                        ),
                        FileFilterUtils.notFileFilter(
                                FileFilterUtils.prefixFileFilter(".")
                        ),
                        FileFilterUtils.suffixFileFilter(".jpg")
                ),
                FileFilterUtils.trueFileFilter()
        );

        files.forEach(it -> {
            fileList.add(it);
        });


        //将上面的lambda表达式替换成addAll(Collection<? extends E> c)方法
        //fileList.addAll(files);

        return fileList;

    }

    private static TreeSet<File> set = Sets.newTreeSet(Comparator.comparing(File::getName));

    private static List<File> goFolder4(File file) {

        File[] files = file.listFiles(pathname -> {
            if (!pathname.isDirectory()) {
                return pathname.getName().endsWith(".jpg") && !(pathname.getName().startsWith("~$"));
            } else {
                goFolder4(pathname);
            }
            return false;
        });
        Collections.addAll(set, files);
        return Lists.newArrayList(set);
    }

    public static void testBoolean(File file) {
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (!pathname.isDirectory()) {
                    return Boolean.logicalAnd(pathname.getName().endsWith(".jpg"), !pathname.getName().startsWith("~$"));
                } else {
                    testBoolean(pathname);
                }
                return false;
            }
        });
    }

    public static void main(String[] args) {
        Path path = Paths.get("/test/Hellen");
        List<File> fileList = goFolder4(path.toFile());
        fileList.forEach(it -> {
            System.out.println("name：" + it.getName());
        });

    }

}
