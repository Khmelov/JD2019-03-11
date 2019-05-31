package by.it.vashkevich.jd02_04;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        try {
            Var.load();
        } catch (Exception e) {
        }
        Scanner scanner = new Scanner(System.in);
        String expression;
        Parser parser = new Parser();
        Printer printer = new Printer();
        Locale locale;

        while (!(expression = scanner.nextLine()).equals("end")) {
            expression = expression.replace(" ", "");
            if (expression.equals("printvar")) {
                printer.print(Var.varList());
            }
            if (expression.equals("sortvar")) {
                printer.print(Var.sortVarList());
            }
            if (expression.equals("en")) {
                locale = new Locale("en", "EN");
            }
            if (expression.equals("ru")) {
                locale = new Locale("ru", "RU");
            }
            if (expression.equals("by")) {
                locale = new Locale("by", "BY");
            }
            try {
                Var result = parser.calc(expression);
                printer.print(result);
                Var.save();
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
