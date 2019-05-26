package by.it.narushevich.project.java.util;

public class Patterns {
    public static String LOGIN = "[\\w._]{8,15}";
    public static String PASSWORD = "[\\w]{8,15}";
    public static String EMAIL = "[\\w._]+@[a-z]+.[a-z]{2,3}";
    public static String TRADEMARK = "[\\w\\s']+";
    public static String MATERIAL = "[a-zA-Z]+";
    public static String SUBTITLE = "[\\w\\s']+";
    public static String DATE = "\\d{4}-\\d{2}-\\d{2}";
    public static String NUMBER_IN_CATALOG = "[\\d]{2}-[\\d]{2}-\\d";
}
