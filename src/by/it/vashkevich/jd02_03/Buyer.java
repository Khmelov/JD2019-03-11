package by.it.vashkevich.jd02_03;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Semaphore;

class Buyer extends Thread implements IBuyer, IUseBucket {
    private static Semaphore choosing = new Semaphore(20);

    private static Semaphore takeBucket = new Semaphore(50);

    HashMap<String, Double> payment = new HashMap<>();

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
    private boolean waiting;

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

    void setWait(boolean waiting) {
        this.waiting = waiting;
    }

    @Override
    public void choosingGoods() {
        try {
            choosing.acquire();
            System.out.println(this + " start choosing goods");
            int time = Util.random(500, 2000);
            if (pensioner)
                time *= 3 / 2;
            Util.sleep(time);
            System.out.println(this + " finish choosing goods");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            choosing.release();
        }
    }

    @Override
    public void gettingIntoQueue() {
        while (true) {
            if (QueueBuyers.size() < 30) {
                QueueBuyers.add(this);
                break;
            } else {
                Util.sleep(10);
            }
        }
        System.out.println(this + " got in line");
        waiting = true;
        synchronized (this) {
            while (waiting)
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
        takeBucket.release();
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takingBucket() {
        try {
            takeBucket.acquire();
            int time = Util.random(100, 200);
            if (pensioner)
                time *= 3 / 2;
            Util.sleep(time);
            System.out.println(this + " has taken a bucket");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            takeBucket.release();
        }
    }

    @Override
    public void puttingIntoBucket() {
        int time = Util.random(100, 200);
        if (pensioner)
            time *= 3 / 2;
        Util.sleep(time);
        HashMap<String, Double> chosenGoods = new HashMap<>(Dispatcher.goodsList);
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
