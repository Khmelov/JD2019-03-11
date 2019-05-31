package by.it.vashkevich.jd01_04;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String doubleLine = scanner.nextLine();
        buildOneDimArray(doubleLine);
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V",5);
        double First = array[0];
        double Last = array[array.length - 1];
        TaskC.mergeSort(array);
        int newF = TaskC.binarySearch(array, First);
        int newL = TaskC.binarySearch(array, Last);
        InOut.printArray(array, "V", 5);
        System.out.println("Index of first element" + newF);
        System.out.println("Index of last element" + newL);
    }

    static void mergeSort(double[] array) {
        if (array.length > 1){
            int middle = array.length / 2;
            double[] leftArr = new double[middle];
            System.arraycopy(array, 0, leftArr, 0, leftArr.length);
            double[] rightArr = new double[array.length - middle];
            System.arraycopy(array, middle, rightArr, 0, rightArr.length);

            mergeSort(leftArr);
            mergeSort(rightArr);
            merge(leftArr, rightArr);

            double[] result = merge(leftArr, rightArr);
            System.arraycopy(result, 0, array, 0, array.length);
        }
    }

    private static double[] merge(double[] leftArr, double[] rightArr) {
        int fullSize = leftArr.length + rightArr.length;
        double[] merge = new double[fullSize];
        int indexLeftArr = 0;
        int indexRightArr = 0;
        int indexMerge = 0;
        while (indexLeftArr < leftArr.length && indexRightArr < rightArr.length) {
            if (leftArr[indexLeftArr] <= rightArr[indexRightArr]) {
                merge[indexMerge] = leftArr[indexLeftArr];
                indexMerge++;
                indexLeftArr++;
            } else {
                merge[indexMerge] = rightArr[indexRightArr];
                indexMerge++;
                indexRightArr++;
            }
        }
        while (indexLeftArr < leftArr.length) {
            merge[indexMerge] = leftArr[indexLeftArr];
            indexMerge++;
            indexLeftArr++;
        }
        while (indexRightArr < rightArr.length) {
            merge[indexMerge] = rightArr[indexRightArr];
            indexMerge++;
            indexRightArr++;
        }
        return merge;
    }

    private static int binarySearch(double[] array, double value) {
        int result = 0;
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (array[middle] < value) {
                low = middle + 1;
            } else if (array[middle] > value) {
                high = middle - 1;
            } else if (array[middle] == value) {
                result = middle;
                break;
            }
        }
        return result;
    }
}
