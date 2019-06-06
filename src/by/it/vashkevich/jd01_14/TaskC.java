package by.it.vashkevich.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TaskC {
    private static int count = 1;

    public static void main(String[] args) {
        String path = getPath(TaskC.class);
        File f = new File(path);

        try (PrintWriter writer = new PrintWriter(new FileWriter(path + File.separator + "resultTaskC.txt"))) {
            CheckFolder(f.getParent(), writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void CheckFolder(String dir, PrintWriter writer) {
        String offset = String.format("%" + count + "s", " ");

        File file = new File(dir);
        File[] all = file.listFiles();

        System.out.println(offset + "dir:" + file.getName());
        writer.println(offset + "dir:" + file.getName());
        count++;
        for (File current : all) {
            if (current.isDirectory()) {
                CheckFolder(current.getPath(), writer);
            } else {
                writer.println(offset + "\tfile:" + current.getName());
                System.out.println(offset + "\tfile:" + current.getName());
            }
        }
        count--;
    }

    private static String getPath(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;
    }
}
