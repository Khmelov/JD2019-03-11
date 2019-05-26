package by.it.narushevich.jd03_03.connect;

public class SetupConnection {

    private static final String URL = "jdbc:mysql://127.0.0.1:2016/narushevich?" +
                        "useUnicode=true&" +
                        "characterEncoding=UTF-8&" +
                        "useJDBCCompliantTimezoneShift=true&" +
                        "useLegacyDatetimeCode=false&" +
                        "serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static String getURL() {
        return URL;
    }

    public static String getUSER() {
        return USER;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }
}
