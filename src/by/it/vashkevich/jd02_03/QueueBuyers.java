package by.it.vashkevich.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class QueueBuyers {
    private QueueBuyers(){
    }

    private static final BlockingDeque<Buyer> customersQueue = new LinkedBlockingDeque<>(30);

    static void add(Buyer buyer) {
        if (buyer.pensioner)
            customersQueue.addFirst(buyer);
        else
            customersQueue.addLast(buyer);
    }

    static Buyer extract() {
        return customersQueue.poll();
    }

    static int size() { return customersQueue.size(); }
}
