package by.it.vashkevich.jd02_01;

import java.util.HashMap;

class Dispatcher {
    private static final Object theCounter = new Object();

    final static int theSpeed = 100;

    final static int theCycle = 150;

    static volatile int theBuyer = 0;

    final static HashMap<String, Double> goodsList = new HashMap<String, Double>(){
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
        synchronized (theCounter) {
            theBuyer++;
        }
    }

    static void minusBuyer() {
        synchronized (theCounter) {
            theBuyer--;
        }
    }
}
