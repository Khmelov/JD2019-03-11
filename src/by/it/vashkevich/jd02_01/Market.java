package by.it.vashkevich.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {
    public static void main(String[] args) {
        List<Thread> customers = new ArrayList<>();
        System.out.println("the market is open");
        
        int theTime = 0;
        int customerNum = 0;
        for (int cycle = 1; cycle <= 5; cycle++) {
            while (theTime < Dispatcher.theCycle) {
                int counter = Util.random(5);
                for (int j = 0; j < counter; j++) {
                    Buyer customer = new Buyer(++customerNum);
                    customer.start();
                    customers.add(customer);
                }
                if (theTime > 50 && Dispatcher.theBuyer <= 50 + (50 - theTime))
                    continue;
                if (theTime <= 50 && Dispatcher.theBuyer <= theTime + 10)
                    continue;
                Util.sleep(1500);
                theTime++;
            }
        }
        for (Thread thr : customers) {
            try {
                thr.join();
            } catch (InterruptedException e) {
                System.out.println("except");
            }
        }
        System.out.println(" the market is closed ");
    }
}
