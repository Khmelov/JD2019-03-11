package by.it.vashkevich.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        String string;
        int pos = 0;
        while (!(string = scanner.next()).equals("end")) {
            Integer value = Integer.valueOf(string);
            if (value > 0)
                list.add(pos++, value);
            else if (value == 0)
                list.add(pos, 0);
            else
                list.add(value);
        }
        System.out.println(list);
    }
}
