package by.it.vashkevich.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] surnamesArray = new String[n];
        for (int i = 0; i < surnamesArray.length; i++) {
            surnamesArray[i] = scanner.next();
        }
        int[][] salaryArray = new int[n][4];
        double all = n*4;
        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для" + surnamesArray[i]);
            for (int j = 0; j < 4; j++) {
                salaryArray[i][j] = scanner.nextInt();
            }
        }
        System.out.println("------------------------------------------------------");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s\n","Фамилия","Квартал1","Квартал2","Квартал3","Квартал4","Итого");
        double totalSummary = 0;
        for (int i = 0; i < surnamesArray.length; i++) {
            int summary = 0;
            System.out.println("------------------------------------------------------");
            System.out.printf("%7s: ", surnamesArray[i]);
            for (int j = 0; j < 5; j++) {
                if(j < 4) {
                    summary += salaryArray[i][j];
                    System.out.printf("%-10d", salaryArray[i][j]);
                }else if (j==4) {
                    totalSummary += summary;
                    System.out.printf("%-10d", summary);
                }
            }
            System.out.println();
        }
        System.out.println("------------------------------------------------------");
        System.out.printf("%-10s%-10f\n","Итого", totalSummary);
        System.out.printf("%-10s%-10f", totalSummary/all);
    }
}
