package by.it.vashkevich.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        split(scanner, map);
        print(map);
    }

    private static void split (Scanner scanner, Map<String, Integer> map) {
        String line;
        String[] words;
        while (!(line = scanner.nextLine()).equals("end")) {
            line = line.replaceAll("[,\";.-]", " ").replace("isn't", "don't");
            words = line.split(" ");
            count(words, map);
        }
    }

    private static void count(String[] words, Map<String, Integer> map) {
        for (String word : words) {
            if (map.containsKey(word)) {
                int newValue = map.get(word);
                map.replace(word, ++newValue);
            } else
                map.put(word, 1);
        }
    }

    private static void print(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet())
            System.out.println(entry.getKey() + "=" + entry.getValue());
    }
}
