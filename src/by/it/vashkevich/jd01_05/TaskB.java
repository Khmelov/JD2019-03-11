package by.it.vashkevich.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        task4();
        task5();
    }

    private static void task4() {
        double y = 0;

        for (double a = 0; a <= 2; a = a+0.2) {
            for (double x = 1; x <= 6; x++){
                y += pow(7,a) - cos(x);
            }
            System.out.printf("При a=%3.2f Сумма y=%g\n",a,y);
        }
    }

    private static void task5() {
        double x;
        double a;
        double b = 0;
        boolean c;

        for (x = -5.5; x < 2; x += 0.5) {

            if((x / 2) > -2 && (x / 2) < -1) {
                b = sin(x*x);
                c = true;
            }else if(x / 2 > -1 && x / 2 < 0.2) {
                b = cos(x*x);
                c = true;
            }else if(x / 2 == 0.2) {
                b = 1 / (tan(x*x));
                c = true;
            }else c = false;

        if (c == true) {
            a = log10(abs(b + 2.74));
            System.out.printf("При x/2=%3.2f a=%g\n",x / 2,a);
        }else
            System.out.printf("При x/2=%3.2f вычисления не определены\n",x / 2);
        }
    }
}
