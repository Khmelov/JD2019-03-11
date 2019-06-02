package by.it.vashkevich.jd01_12;


import java.util.*;

public class TaskB2 {
    public static void main(String[] args) {
        String[] array = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"};
        List<String> names = Arrays.asList(array);
        ArrayList<String> arrayList = new ArrayList<>(names);
        LinkedList<String> linkedList = new LinkedList<>(names);
        String peopleA = TaskB2.process(arrayList);
        System.out.println(peopleA);
        String peopleB = TaskB2.process(linkedList);
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
            if (!iterator.hasNext())
                iterator = linkedList.iterator();
            iterator.next();
            if (!iterator.hasNext())
                iterator = linkedList.iterator();
            iterator.next();
            iterator.remove();
        }
        return linkedList.get(0);
    }

}
