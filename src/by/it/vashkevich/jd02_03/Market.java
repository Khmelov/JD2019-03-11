package by.it.vashkevich.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Market {
    public static void main(String[] args) {
        System.out.println("the market is open");
        ExecutorService executorService = Executors.newFixedThreadPool(Dispatcher.maximum);
        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i);
            executorService.execute(cashier);
        }

        int theTime = 0;
        int customerNum = 0;
        while (!Dispatcher.completedPlan()) {
            if (theTime >= 60) theTime -= 60;
            int theCount = Util.random(2);
            for (int n = 0; n < theCount; n++) {
                if (!Dispatcher.completedPlan()) {
                    Buyer buyer = new Buyer(++customerNum);
                    buyer.start();
                }
            }
            if (theTime > 30 && Dispatcher.theBuyer.get() <= 40 + (30 - theTime)) {
                Util.sleep (10);
                continue;
            }
            if (theTime <= 30 && Dispatcher.theBuyer.get() <= theTime + 10) {
                Util.sleep(10);
                continue;
            }
            Util.sleep(1000);
            theTime++;
        }

        executorService.shutdown();
        while (!executorService.isTerminated())
            Util.sleep(1000);
        System.out.println("the market is closed");
    }
}
