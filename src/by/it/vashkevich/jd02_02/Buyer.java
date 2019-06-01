package by.it.vashkevich.jd02_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class Buyer extends Thread implements IBuyer, IUseBucket {
    HashMap<String, Double> payment = new HashMap<>();

    static List<Thread> customers = new ArrayList<>();

    @Override
    public void run() {
        enteringToMarket();
        takingBucket();
        choosingGoods();
        puttingIntoBucket();
        gettingIntoQueue();
        goingOutOfMarket();
    }

    Object gettingMonitor() { return this; }

    boolean pensioner = false;

    Buyer(int num) {
        super("Buyer № " + num);
        if (Util.random(1, 4) == 4)
            this.pensioner = true;
        Dispatcher.plusBuyer();
    }

    @Override
    public void enteringToMarket() {
        System.out.println(this + " enters to the market");
    }

    @Override
    public void choosingGoods() {
        System.out.println(this + " start choosing goods");
        int time = Util.random(500, 2000);
        if (pensioner)
            time *= 3 / 2;
        Util.sleep(time);
        System.out.println(this + " finish choosing goods");
    }

    @Override
    public void gettingIntoQueue() {
        System.out.println(this + " got in line");
        QueueBuyers.add(this);
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(this + " finished shopping at cashdesk");
    }

    @Override
    public void goingOutOfMarket() {
        System.out.println(this + " going out of market");
        Dispatcher.minusBuyer();
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takingBucket() {
        int time = Util.random(100, 200);
        if (pensioner)
            time *= 3 / 2;
        Util.sleep(time);
        System.out.println(this + " has taken a bucket");
    }

    @Override
    public void puttingIntoBucket() {
        int time = Util.random(100, 200);
        if (pensioner)
            time *= 3 / 2;
        Util.sleep(time);
        HashMap<String, Double> chosenGoods = new HashMap<>(Util.goodsList);
        Iterator iterator = chosenGoods.entrySet().iterator();
        int size = chosenGoods.size();
        while (iterator.hasNext() && chosenGoods.size() != Util.random(1, 4)) {
            iterator.next();
            if (Util.random(1, size) != size) {
                iterator.remove();
                size--;
            }
        }
        System.out.println(this + " goods that were put into a bucket");
        payment.putAll(chosenGoods);
    }
}
