package by.it.vashkevich.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
            System.out.println();
        }
        catch (Exception e) {
            StackTraceElement[] st = e.getStackTrace();
            for (StackTraceElement element : st) {
                if (TaskA.class.getName().equals(element.getClassName())) {
                    String n = e.getClass().getName();
                    String cn = element.getClassName();
                    int number = element.getLineNumber();

                    System.out.printf(" name: %s\n" +
                                      "class: %s\n" +
                                      " line: %d\n",
                                        n, cn, number);
                }
            }
        }
    }
}
