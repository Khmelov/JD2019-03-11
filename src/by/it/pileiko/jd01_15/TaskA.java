package by.it.pileiko.jd01_15;
import java.io.*;
import  java.util.Arrays ;

public class TaskA {


    private static String dir(Class<?> cl, String name){
        String path= System.getProperty("user.dir")+ File.separator + "src" +File.separator;
        String clDir=cl.getName().replace(cl.getSimpleName(),"").replace(".",File.separator);
        return path+clDir;
    }
    public static void main(String[] args) {
        int[][] array = create(6, 4, 15);
        String filename=dir(TaskA.class,"matrix.txt");
        saveMatrix(array, filename);
        showFile(filename);
    }


    private static void showFile(String filename) {

        try (BufferedReader in=new BufferedReader(new FileReader(filename))){
            String line;
            while ((line=in.readLine())!=null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void saveMatrix(int[][] array, String filename) {
        try (PrintWriter out=new PrintWriter(new FileWriter(filename))){
            for (int[] row : array) {
                for (int element : row) {
                    out.printf("%3d ",element);
                }
                out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static int[][] create(int rows, int cols, int max) {
        int[][] result = new int[rows][cols];
        boolean maxOk;
        boolean minOk;
        do {
            maxOk=false;
            minOk=false;
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = (int) (Math.random() * (max*2+1)) - 15;
                    if (result[i][j]==max) maxOk=true;
                    if (result[i][j]==-max) minOk=true;
                }
            }
        } while (!(maxOk && minOk));
        return result;
    }
}




