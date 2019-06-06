package by.it.vashkevich.jd01_05;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        int arrayIndex = 0;
        int count = 0;
        int arrayLength = 20 + (int) (Math.random() * 21);
        char arrayName = 'A';
        double step = (9 - 5.3) / arrayLength;
        double[] arrayA = new double[arrayLength];

        for (double x = 5.33; x <= 9; x += step) {
            double z = cbrt(x * x + 4.5);
            arrayA[arrayIndex] = z;
            arrayIndex++;
        }
        Print(arrayA, arrayName++);

        for (int y = 0; y < arrayA.length; y++) {
            if (arrayA[y] > 3.5) {
                count = y;
                break;
            }
        }

        double[] arrayB = new double[arrayA.length - count];

        for (int y = 0; y < arrayB.length; y++) {
            arrayB[y] = arrayA[count];
            count++;
        }
        Print(arrayB, arrayName);

        double res = 0;

        for (int y = 0; y < arrayB.length; y++) {
            res = res + log10(arrayB[y]);
        }

        res = res / arrayB.length;
        res = pow(10, res);
        System.out.println(res);
    }

    private static void Print(double[]array, char arrayName) {
        for (int y = 0; y < array.length; y++) {
            if (y == 0)
                System.out.printf("Массив %c[]\n", arrayName);
            System.out.printf("%c[% -2d ] = %-6.5f\t",arrayName,y,array[y]);
            if ((y + 1) % 5 == 0 && y - 1 != 0)
                System.out.println();
        }
    }
}
