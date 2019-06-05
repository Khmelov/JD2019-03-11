package by.it.vashkevich.jd01_12;

import java.util.*;

public class TaskC2 {
    public static void main(String[] args) {
        processWithDouble();
        processWithInteger();
    }

    private static void processWithDouble() {
        Double[] doubleA = {1d, 3d, 4d, 6d};
        Double[] doubleB = {1d, 5d, 7d, 7d, 9d};
        Double[] doubleC = {1d, 2d, 4d, 6d, 8d, 9d};
        List<Double> listDoubleA = Arrays.asList(doubleA);
        List<Double> listDoubleB = Arrays.asList(doubleB);
        List<Double> listDoubleC = Arrays.asList(doubleC);
        Set<Double> DoubleA = new HashSet<>(listDoubleA);
        Set<Double> DoubleB = new HashSet<>(listDoubleB);
        Set<Double> DoubleC = new HashSet<>(listDoubleC);
        System.out.println("Проверка на множестве типа double");
        System.out.println("DoubleA: " + DoubleA);
        System.out.println("DoubleB: " + DoubleB);
        System.out.println("DoubleC: " + DoubleC);
        System.out.println("Cross: " + getCross(DoubleA,DoubleB,DoubleC));
        System.out.println("Union: " + getUnion(DoubleA,DoubleB,DoubleC));
    }

    private static void processWithInteger() {
        Integer[] integerA = {1, 3, 4, 6};
        Integer[] integerB = {1, 5, 7, 7, 9};
        Integer[] integerC = {1, 2, 4, 6, 8, 9};
        List<Integer> listIntegerA = Arrays.asList(integerA);
        List<Integer> listIntegerB = Arrays.asList(integerB);
        List<Integer> listIntegerC = Arrays.asList(integerC);
        Set<Integer> IntegerA = new HashSet<>(listIntegerA);
        Set<Integer> IntegerB = new HashSet<>(listIntegerB);
        Set<Integer> IntegerC = new HashSet<>(listIntegerC);
        System.out.println("Проверка на множестве типа integer");
        System.out.println("IntegerA: " + IntegerA);
        System.out.println("IntegerB: " + IntegerB);
        System.out.println("IntegerC: " + IntegerC);
        System.out.println("Cross: " + getCross(IntegerA,IntegerB,IntegerC));
        System.out.println("Union: " + getUnion(IntegerA,IntegerB,IntegerC));
    }

    private static <E> Set<E> getCross(Set<?> ...sets) {
        Set<E> result = new HashSet<>();
        Set<E> union = (Set<E>) getUnion(sets);
        Iterator<E> iterator = union.iterator();
        boolean d = true;
        while(iterator.hasNext()) {
            E next = iterator.next();
            for(Set<?> set : sets) {
                if(!set.contains(next)) d = false;
            }
            if(d) {
                result.add(next);
            }
        }
        return result;
    }

    private static <E> Set<E> getUnion(Set<? extends E> ...sets) {
        Set<E> result = new TreeSet<>();
        for(Set<?> set : sets) {
            result.addAll((Set<? extends E>) set);
        }
        return result;
    }
}
