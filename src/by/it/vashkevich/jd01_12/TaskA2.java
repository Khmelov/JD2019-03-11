package by.it.vashkevich.jd01_12;

import java.util.*;

public class TaskA2 {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(1,3,7,6,5,4,8,4,5,3,2,1));
        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(7,6,5,8,3,2,4,5,1,6,7,3));
        System.out.println(getUnion(treeSet, hashSet));
        System.out.println(getCross(treeSet, hashSet));
    }

    private static Set<Integer> getUnion (Set<Integer> first, Set<Integer> second) {
        Set<Integer> result = new HashSet<>(first);
        result.addAll(second);
        return result;
    }

    private static Set<Integer> getCross (Set<Integer> first, Set<Integer> second) {
        Set<Integer> result = new HashSet<>(first);
        result.retainAll(second);
        return result;
    }
}
