package by.it.pileiko.jd01_07;

public class Runner {


    public static void main(String[] args) {
        Var var1=new Scalar(3.1415);
        Var var2=new Scalar("3.1415");

        System.out.println(var1);
        System.out.println(var2);

        Var var3=new Vector(new double[] {1,2,4});
        Var var4=new Vector("{1, 2, 4.0}");

        System.out.println(var3);
        System.out.println(var4);



    }
}
