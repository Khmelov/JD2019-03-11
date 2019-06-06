package by.it.vashkevich.jd01_03;


public class Helper {
    static double findMin(double[ ] arr) {
        if (arr.length == 0) {
            return Double.MIN_VALUE;
        } else {
            double min=arr[0];
            for (double m : arr) {
                if (min > m) min = m;
            }
            return min;
        }
    }

    static double findMax(double[ ] arr) {
        if (arr.length == 0) {
            return Double.MAX_VALUE;
        } else {
            double max=arr[0];
            for (double m : arr) {
                if (max < m) max = m;
            }
            return max;
        }
    }

    static void sort(double[ ] arr) {
        boolean swap;
        double last=arr.length-1;
        do {
            swap=false;
            for (int i = 0; i < last; i++) {
                if (arr[i]>arr[i+1]) {
                    double buffer = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buffer;
                    swap = true;
                }
            }
            last--;
        }
        while (swap);
        for (double element : arr) {
            System.out.print(element+" ");
        }
        System.out.println();
    }

    static double[ ] mul(double[ ][ ] matrix, double[ ] vector) {
        System.out.println("\nРезультат умножения матрицы на вектор: ");
        double[] result = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                result[i] = result[i] + matrix[i][j] * vector[j];
            }
            System.out.print(result[i] + " ");
        }
        System.out.println();
        return result;
    }

    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight) {
        System.out.println("\nРезультат умножения матрицы на матрицу: ");
        double[][] result = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    result[i][j] = result[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        return result;
    }
}
