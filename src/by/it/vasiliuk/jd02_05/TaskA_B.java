package by.it.vasiliuk.jd02_05;



import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

@SuppressWarnings("all")
class TaskA_B {

    public static void main(String[] args) {

        ResourceManager manager_langs=ResourceManager.INSTANCE;
        Scanner scanner = new Scanner(System.in);
        System.out.println("please,choose language:\n" +
                "en-English\n" +
                "be-Белоруский\n" +
                "ru-Русский");
        while (true) {
            String language = "";
            String country = "";
            String line = scanner.nextLine();
            switch (line){
                case"en":
                    language="en";
                    country="EN";
                    break;
                case"be":
                    language="be";
                    country="BY";
                    break;
                case"ru":
                    language="ru";
                    country="RU";
                    break;
                default:
                    language = "en";
                    country = "EN";
                    break;

            }

            Locale locale  = new Locale(language,country);
            manager_langs.setLocale(locale);
            Date date_01 = new Date();
            DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM,locale);
            String format = df.format(date_01);
            System.out.println(format);
            System.out.printf("%s\n%s\n%s %s\n",
                    manager_langs.getString(Msg.WELCOME),
                    manager_langs.getString(Msg.QUESTION),
                    manager_langs.getString(Msg.FISRTNAME),
                    manager_langs.getString(Msg.LASTNAME)
            );
        }
    }
}