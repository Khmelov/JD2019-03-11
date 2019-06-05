package by.it.vashkevich.jd01_14;

import java.io.*;

public class TaskA {
    private static String getFileName(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String classDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + classDir;
    }

    public static void main(String[] args) {
        DataOutputStream outBin = null;
        try {
            outBin = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(getFileName(TaskA.class) + "dataTaskA.bin")));
            for (int i = 0; i < 20; i++) {
                outBin.writeInt((int) (Math.random() * 50));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outBin != null) {
                try {
                    outBin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        try (DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(getFileName(TaskA.class) + "dataTaskA.bin")));
             PrintWriter outTxt = new PrintWriter(new FileWriter(getFileName(TaskA.class) + "resultTaskA.txt"))
        ) {
            double sum = 0;
            double count = 0;
            while (input.available() > 0) {
                int i = input.readInt();
                System.out.print(i + " ");
                outTxt.print(i + " ");
                sum += i;
                count++;
            }
            System.out.println();
            double res = sum / count;
            System.out.println("avg=" + res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
