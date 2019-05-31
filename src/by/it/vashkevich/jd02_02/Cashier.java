package by.it.vashkevich.jd02_02;

import java.util.Arrays;
import java.util.HashMap;

class Cashier implements Runnable {
    private int num;
    Cashier(int num) { this.num = num; }

    @Override
    public void run() {

        while (Dispatcher.openedMarket()) {
            Buyer buyer = QueueBuyers.extract();
            if (buyer != null) {
                System.out.println(this + " began service" + buyer);
                int time = Util.random(2000, 5000);
                Util.sleep(time);
                System.out.println(this + " finished service" + buyer);
                synchronized (System.out) {
                    printingCheck(buyer);
                }
                synchronized (buyer.gettingMonitor()) {
                    buyer.gettingMonitor().notify();
                }
            }
        }
        System.out.println(this + " closed");
    }

    private void printingCheck(Buyer buyer) {
        double summary = 0;
        char[] cashierTabsCh = new char[22 * (num - 1)];
        char[] tabsCh = new char[92 - 22 * (num - 1)];
        Arrays.fill(cashierTabsCh, ' ');
        Arrays.fill(tabsCh, ' ');
        String cashierTabs = new String(cashierTabsCh);
        String tabs = new String(tabsCh);
        String line = "_-_-_-_-_";
    //  synchronized (System.out) {
            System.out.printf("%s%s%s%s\t%s\n", cashierTabs, line, tabs, line, line);
            System.out.printf("%s| %-13s | In the queue %-5s | \t| Total income%-2s |\n", cashierTabs, buyer, tabs, " ", " ");
            System.out.printf("%s%s%s%s\t%s\n", cashierTabs, line, tabs, line, line);
            for (HashMap.Entry<String, Double> entry : buyer.payment.entrySet()) {
                summary += entry.getValue();
                System.out.printf("%s| %-6s = %-5.2f |%s| %-14s |\t| %-14s |\n", cashierTabs, entry.getKey(), entry.getValue(), tabs, " ", " ");
            }
            Util.income += summary;
            System.out.printf("%s%s%s%s\t%s\n", cashierTabs, line, tabs, line, line);
            System.out.printf("%s| Summary = %-5.2f |%s| %-14s |\t| %-14.2f |\n");
            System.out.printf("%s%s%s%s\t%s\n", cashierTabs, line, tabs, line, line);
    //  }
    }

    public String toString() { return "Cashier №" + num; }
}
