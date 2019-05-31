package by.it.vashkevich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.String;


public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        System.out.println(sb);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()) {
            int start = matcher.start();
            sb.setCharAt(start+3,'#');
            if (matcher.group().length() >= 7) {
                sb.setCharAt(start+6,'#');

            }
        }
        System.out.println(sb);
    }
}
