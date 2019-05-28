package by.it.vashkevich.jd02_02;

import java.util.HashMap;

class Util {
    private Util(){
    }

    static double income = 0;

    static int theActiveCashier = 0;

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
    static void sleep(int time) {
        try {
            Thread.sleep (time / Dispatcher.theSpeed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static int random (int start, int stop) { return (int) (Math.random() * (stop - start + 1)) + start; }

    static int random (int range) { return random (0, range); }
}
