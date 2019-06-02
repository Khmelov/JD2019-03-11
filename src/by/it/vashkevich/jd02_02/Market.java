package by.it.vashkevich.jd02_02;

import static by.it.vashkevich.jd02_02.Buyer.customers;

public class Market {
    public static void main(String[] args) {
        System.out.println("the market is open");

        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i);
            Thread threadCashier = new Thread(cashier);
            threadCashier.start();
            Buyer.customers.add(threadCashier);
            Util.theActiveCashier++;
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
                    Buyer.customers.add(buyer);
                }
            }
            if (theTime > 30 && Dispatcher.theBuyer <= 30 + (30 - theTime))
                continue;
            if (theTime <= 30 && Dispatcher.theBuyer <= theTime + 10)
                continue;
            Util.sleep(1000);
            theTime++;
        }

        for (Thread buyer : customers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                System.out.println("exception");
            }
        }
        System.out.println("the market is closed");
    }
}
