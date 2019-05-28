package by.it.vashkevich.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        double num = 0;
        double res;

        try {
            while (!(line = scanner.nextLine()).equals("END")) {
                num += Double.parseDouble(line);
                System.out.println(num);

                res = Math.sqrt(num);
                if (num < 0)
                    throw new ArithmeticException();
                System.out.println(res);
            }
        }
        catch (NumberFormatException | ArithmeticException e) {
            StackTraceElement[] st = e.getStackTrace();
            for (StackTraceElement element : st) {
                if (TaskB.class.getName().equals(element.getClassName())) {
                    String n = e.getClass().getName();
                    String cn = element.getClassName();
                    int number = element.getLineNumber();
                    System.out.printf("name: %s\nclass: %s\nline: %s\n", n, cn, number);
                }
            }
        }
    }
}
