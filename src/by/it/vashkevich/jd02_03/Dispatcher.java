package by.it.vashkevich.jd02_03;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {
    private Dispatcher() {
    }

    final static int theSpeed = 1000;

    private static final int thePlan = 100;

    private static final AtomicInteger theCounterOfBuyers = new AtomicInteger(0);

    static final AtomicInteger theBuyer = new AtomicInteger(0);

    static final AtomicInteger activeCashier = new AtomicInteger(0);

    static final int maximum = 5;

    static final int checkingWidth = 18;

    static final int checkingTab = 4;

    static double income = 0;

    final static HashMap<String, Double> goodsList = new HashMap<String, Double>() {
        {
            put("Milk", 1.59);
            put("Bread", 1.39);
            put("Cake", 3.99);
            put("Fish", 8.99);
            put("Eggs", 2.39);
            put("Cheese", 5.49);
            put("Potatoes", 2.59);
            put("Carrots", 2.29);
        }
    };

    static void plusBuyer() {
       theCounterOfBuyers.getAndIncrement();
       theBuyer.getAndIncrement();
    }

    static void minusBuyer() {
        theBuyer.getAndDecrement();
    }

    static boolean openedMarket() { return theCounterOfBuyers.get() < thePlan || theBuyer.get() < 0; }

    static boolean completedPlan() { return theCounterOfBuyers.get() == thePlan; }

    public static int getTheCounterOfBuyers() { return theCounterOfBuyers.get(); }

    public static int getTheBuyer() { return theBuyer.get(); }
}
