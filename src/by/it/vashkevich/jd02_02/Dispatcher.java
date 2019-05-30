package by.it.vashkevich.jd02_02;

class Dispatcher {
    private static final Object theCounter = new Object();

    final static int theSpeed = 1000;

    private static final int thePlan = 100;

    private static volatile int theCounterOfBuyers = 0;

    static volatile int theBuyer = 0;

    static void plusBuyer() {
        synchronized (theCounter) {
            theCounterOfBuyers++;
            theBuyer++;
        }
    }

    static void minusBuyer() {
        synchronized (theCounter) {
            theBuyer--;
        }
    }

    static boolean openedMarket() { return theCounterOfBuyers < thePlan || theBuyer > 0; }

    static boolean completedPlan() { return theCounterOfBuyers == thePlan; }
}
