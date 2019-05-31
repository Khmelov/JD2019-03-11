package by.it.vashkevich.jd01_15;

import java.io.File;
import java.util.Date;
import java.util.Formatter;
import java.util.Scanner;

public class TaskC {
    private static StringBuilder current;

    public static void main(String[] args) {
        TaskC c = new TaskC();
        Scanner scanner = new Scanner(System.in);
        String first = firstPath();
        current = new StringBuilder(first);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            if (! str.equals("end"))
                c.process(str);
            else break;
        }
    }

    private static String firstPath() {
        String src = System.getProperty("user.dir") + File.separator + "src" +File.separator;
        String pack = TaskA.class.getPackage().getName();
        String path = pack.replace(".", File.separator);
        return src + path + File.separator;
    }

    private void fileDescription(File fn) {
        String date = new Date(fn.lastModified()).toString();
        String description = fn.isDirectory() ? "<DIR>" : ((Long) fn.length()).toString();
        Formatter formatter = new Formatter();
        String result = formatter.format("%25s %10s %20s \n", date, description, fn.getName()).toString();
        formatter.close();
        System.out.println(result);
    }

    public void process(String str) {
        switch(str) {
            case "end":
                System.out.println(current.toString());
                break;
            case "cd..":
                String[] splitting = current.toString().split("[\\\\]");
                current.delete(0, current.length());
                for (int i = 0; i < splitting.length - 1; i++) {
                    current.append(splitting[i]);
                    current.append("\\");
                }
                System.out.println(current.toString());
                break;
            case "dir":
                File fn = new File(current.toString());
                String[] listing = fn.list();
                assert listing != null;
                for (String str1 : listing) {
                    fileDescription(new File(current + str1));
                }
                System.out.println(current);
                break;
            default:
                StringBuilder sb = new StringBuilder(str);
                sb.delete(0,3);
                sb.append("\\");
                current.append (sb);
                System.out.println(current.toString());
                break;
        }
    }
}
