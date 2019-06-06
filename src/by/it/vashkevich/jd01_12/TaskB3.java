package by.it.vashkevich.jd01_12;

import java.util.*;

public class TaskB3 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        for (int i = 0; i < 1024; i++) {
            names.add("egor");
            names.add("nastya");
            names.add("platon");
            names.add("inna");
        }
        ArrayList<String> arrayList = new ArrayList<>(names);
        LinkedList<String> linkedList = new LinkedList<>(names);
        String peopleA = TaskB3.process(arrayList);
        String peopleB = TaskB3.process(linkedList);
        System.out.println(peopleA);
        System.out.println(peopleB);
    }

    private static String process(ArrayList<String> arrayList) {
        Iterator<String> iterator = arrayList.iterator();
        while (arrayList.size() != 1) {
            if (!iterator.hasNext())
                iterator = arrayList.iterator();
            iterator.next();
            if (!iterator.hasNext())
                iterator = arrayList.iterator();
            iterator.next();
            iterator.remove();
        }
        return arrayList.get(0);
    }

    private static String process(LinkedList<String> linkedList) {
        Iterator<String> iterator = linkedList.iterator();
        while (linkedList.size() != 1) {
            String poll = linkedList.poll();
            linkedList.offer(poll);
            linkedList.remove();
        }
        return linkedList.get(0);
    }
}
