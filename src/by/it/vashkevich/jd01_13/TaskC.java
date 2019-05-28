package by.it.vashkevich.jd01_13;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskC {
    private static ArrayList<Double> number = new ArrayList<>();
    private static String line;
    private static int count = 0;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (!(line = scanner.nextLine()).equals("END"))
            readData();
    }

    static void readData() throws Exception {
        try {
            number.add(Double.parseDouble(line));
        }
        catch (NumberFormatException e) {
            if (++count < 5) {
                Thread.sleep(100);
                for (int i = number.size() - 1; i >= 0; i--)
                    System.out.print(number.get(i) + " ");
                System.out.println();
            } else throw new Exception("Достигнут лимит в 5 допущенных ошибок");
        }
    }
}
