package by.it.pileiko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1{
    public static void main(String[]args){
        StringBuilder sb=new StringBuilder(Poem.text);
        Pattern pattern=Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher matcher=pattern.matcher(Poem.text);
        while (matcher.find()){
            int start = matcher.start();
            sb.setCharAt(start+3, '#');
            if (matcher.end()-matcher.start()>6);
                sb.setCharAt(start+6, '#');

        }
        System.out.println(sb);
    }

}




/*import java.util.regex.Matcher;
import java.util.regex.Pattern;

 public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder(Poem.text);
        Pattern word4 = Pattern.compile("[а-яА-ЯёЁ] {4,}");
        Matcher matcher = word4.matcher(sb);
        while (matcher.find()){
            sb.setCharAt(matcher.start()+3, '#');
            if (matcher.end()-matcher.start()>6)
            sb.setCharAt(matcher.start()+6, '#');
        }
        System.out.println(sb);
    }
}
*/
