package by.it.vashkevich.jd02_01;

import java.util.HashMap;
import java.util.Iterator;

public class Buyer extends Thread implements IBuyer, IUseBucket {

    @Override
    public void run() {
        enteringToMarket();
        takingBucket();
        choosingGoods();
        puttingToBucket();
        goingOutOfMarket();
    }

    private boolean pensioneer = false;

    Buyer(int num) {
        super("Buyer № " + num);
        if (Util.random(1, 4) == 4)
            this.pensioneer = true;
    }

    @Override
    public void enteringToMarket() {
        System.out.println(this + " enters to the market");
        Dispatcher.plusBuyer();
    }

    @Override
    public void choosingGoods(){
        System.out.println(this + " start choosing goods");
        int time = Util.random(500, 2000);
        if (pensioneer)
            time *= 3 / 2;
        Util.sleep(time);
        System.out.println(this + "finish choosing goods");
    }

    @Override
    public void goingOutOfMarket() {
        System.out.println(this + "going out of market");
        Dispatcher.minusBuyer();
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takingBucket() {
        int time = Util.random(100, 200);
        if (pensioneer)
            time *= 3 / 2;
        Util.sleep(time);
        System.out.println(this + "has taken a bucket");
    }

    @Override
    public void puttingToBucket() {
        int time = Util.random(100, 200);
        if (pensioneer)
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
        System.out.println(this + "goods that were put into a bucket");
        System.out.println(chosenGoods);
    }
}
