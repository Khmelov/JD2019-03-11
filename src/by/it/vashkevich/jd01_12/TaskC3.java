package by.it.vashkevich.jd01_12;

import java.util.Deque;
import java.util.LinkedList;

public class TaskC3 {
    private static Deque<Character> roundBrackets = new LinkedList<>();
    private static Deque<Character> squareBrackets = new LinkedList<>();
    private static Deque<Character> figureBrackets = new LinkedList<>();

    public static void main(String[] args) {
        String exp = "[1,2,3],{4,5,6},(7*(8-1))";
        System.out.println(exp + " " + TaskC3.bracketsAreCorrect(exp));
        exp = "[1,2,3],{4,5,6},(7*(8-1))";
        System.out.println(exp + " " + TaskC3.bracketsAreCorrect(exp));
    }

    private static boolean bracketsAreCorrect(String exp) {
        StringBuilder sb = new StringBuilder(exp);
        char openRound = '(';
        char closedRound = ')';
        char openSquare = '[';
        char closedSquare = ']';
        char openFigure = '{';
        char closedFigure = '}';
        for (int i = 0; i < sb.length(); i++) {
            switch (sb.charAt(i)) {
                case '(': {
                    roundBrackets.addFirst(openRound);
                    break;
                }
                case ')':
                    roundBrackets.addLast(closedRound);
                    break;
                case '[': {
                    squareBrackets.addFirst(openSquare);
                    break;
                }
                case ']':
                    squareBrackets.addLast(closedSquare);
                    break;
                case '{': {
                    figureBrackets.addFirst(openFigure);
                    break;
                }
                case '}':
                    figureBrackets.addLast(closedFigure);
                    break;
                default:
                    break;
            }
        }
        return areCorrect();
    }

    private static boolean areCorrect() {
        while ((roundBrackets.peekFirst() == '(') && (roundBrackets.peekLast() == ')')) {
            roundBrackets.removeFirst();
            roundBrackets.removeLast();
            if (roundBrackets.isEmpty()) {
                break;
            }
        }
        while ((squareBrackets.peekFirst() == '[') && (squareBrackets.peekLast() == ']')) {
            squareBrackets.removeFirst();
            squareBrackets.removeLast();
            if (squareBrackets.isEmpty()) {
                break;
            }
        }
        while ((figureBrackets.peekFirst() == '{') && (figureBrackets.peekLast() == '}')) {
            figureBrackets.removeFirst();
            figureBrackets.removeLast();
            if (figureBrackets.isEmpty()) {
                break;
            }
        }
        return roundBrackets.isEmpty() && squareBrackets.isEmpty() && figureBrackets.isEmpty();
    }
}
