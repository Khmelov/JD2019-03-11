package by.it.vashkevich.jd01_15;

import java.io.*;

public class TaskA {
    private static String getFileName() {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String pack = TaskA.class.getPackage().getName();
        String path = pack.replace(".", File.separator);
        return src + path + File.separator + "matrix.txt";
    }

    public static void main(String[] args) {
        int[][] array = create();
        String fileName = getFileName();
        saveM(array, fileName);
        showF(fileName);
    }

    private static int[][] create() {
        int[][] res = new int[6][4];
        boolean maximum;
        boolean minimum;
        do {
            maximum = false;
            minimum = false;
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[j].length; j++) {
                    res[i][j] = (int) (Math.random() * (15 * 2 + 1)) - 15;
                    if (res[i][j] == 15) maximum = true;
                    if (res[i][j] == -15) minimum = true;
                }
            }
        } while (!(maximum && minimum));
        return res;
    }

    private static void saveM (int[][] array, String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (int[] row : array) {
                for (int element : row) {
                    writer.printf("%3d ", element);
                }
                writer.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void showF (String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
