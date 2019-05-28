package by.it.vashkevich.jd02_03;

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
                    buyer.setWait(false);
                    buyer.gettingMonitor().notify();
                }
            }
        }
        System.out.println(this + " closed");
    }

    private void printingCheck(Buyer buyer) {
        double summary = 0;
        String firstCheckTab = stringFill((Dispatcher.checkingWidth + Dispatcher.checkingTab) * (num - 1), ' ');
        String secondCheckTab = stringFill((Dispatcher.maximum - num) * (Dispatcher.checkingWidth + Dispatcher.checkingTab) + Dispatcher.checkingTab, ' ');
        String tabs = stringFill(Dispatcher.checkingTab, ' ');
        String line = stringFill(Dispatcher.checkingWidth, '-');
        String border = firstCheckTab + line + secondCheckTab + line + tabs + line;

        System.out.printf("%s\n%s| %-13s |%s| In queue %-5s |%s| Total income %-2s |\n%s\n",
                border,
                firstCheckTab, buyer, secondCheckTab, " ", tabs, " ",
                border);

        for (HashMap.Entry<String, Double> entry : buyer.payment.entrySet()) {
            summary += entry.getValue();
            System.out.printf("%s| %-6s = %-5.2f |%s| %-14s |%s| %-14s |\n", firstCheckTab, entry.getKey(), entry.getValue(), secondCheckTab, " ", tabs, " ");
        }

        Dispatcher.income += summary;

        System.out.printf("%s\n%s| Summary = %-5.2f |%s| %-14s |%s| %-14.2f |\n%s\n",
                border,
                firstCheckTab, summary, secondCheckTab, QueueBuyers.size(), tabs, Dispatcher.income,
                border);
    }

    private String stringFill(int length, char symbol) {
        char[] charArray = new char[length];
        Arrays.fill(charArray, symbol);
        return new String(charArray);
    }

    @Override
    public String toString() { return "Cashier №" + num; }
}
