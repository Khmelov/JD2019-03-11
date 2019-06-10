package by.it.pileiko.jd01_07;

import java.util.Arrays;

class Vector extends Var {

    private double [] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector){
        this.value=vector.value;

    }

    Vector(String strVector){
        StringBuilder strb=new StringBuilder((strVector));
        strb.deleteCharAt(0);
        strb.deleteCharAt(strb.length()-1);
        String str=strb.toString();
        String [] masstr=str.split("[^\\d.]+");
        double [] array=new double[masstr.length];
        for (int i = 0; i < masstr.length; i++) {
            array[i]=Double.parseDouble(masstr[i]);
        }
        this.value=array;





    }



    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("{");
        String delimiter="";
        for (double element: value) {
            sb.append(delimiter).append(element);
            delimiter=", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
