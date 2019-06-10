package by.it.vasiliuk.jd02_06;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        Singleton logging = Singleton.getInstance();
        for (int i = 0; i < 10; i++) {
            logging.log("Message " + i);
            Thread.sleep(800);
        }
    }
}