package by.it.narushevich.project.java.util;

public class Patterns {
    public static final String LOGIN = "[а-яА-Яa-zA-Z0-9._]{8,15}";
    public static final String PASSWORD = "[a-zA-Z0-9._]{6,15}";
    public static final String EMAIL = "[a-zA-Z0-9._]+@[a-z]+.[a-z]{2,3}";
    public static final String TRADEMARK = "[а-яА-Яa-zA-Z0-9._\\s']+";
    public static final String SUBTITLE = "[а-яА-Яa-zA-Z0-9._\\s']+";
    public static final String NUMBER_IN_CATALOG = "[\\d]{2}-[\\d]{2}-\\d";
    public static final String ALL = ".*";
}
