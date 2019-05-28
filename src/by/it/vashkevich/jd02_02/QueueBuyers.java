package by.it.vashkevich.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

class QueueBuyers {
    private QueueBuyers(){
    }

    private static final Deque<Buyer> buyerDeque = new ArrayDeque<>();

    private static final Deque<Buyer> pensionerDeque = new ArrayDeque<>();

    static synchronized void add(Buyer buyer) {
        if (buyer.pensioner)
            pensionerDeque.addLast(buyer);
        else
            buyerDeque.addLast(buyer);
    }

    static synchronized Buyer extract() {
        if (pensionerDeque.size() != 0)
            return pensionerDeque.pollFirst();
        return buyerDeque.pollFirst();
    }

    static synchronized int size() { return buyerDeque.size() + pensionerDeque.size(); }
}
