package by.it.pileiko.jd01_08;

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

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double [] res= Arrays.copyOf(value, value.length);
            for (int i = 0; i <res.length ; i++) {
                res[i]=res[i]+((Scalar)other).getValue();

            }
            return new Vector(res);
        }
        else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Vector) other).value[i];
            }
            return new Vector(res);
        }
        else
        return super.add(other);
    }
    @Override
    public Var sub (Var other) {
        if (other instanceof Scalar){
            double [] res= Arrays.copyOf(value, value.length);
            for (int i = 0; i <res.length ; i++) {
                res[i]=res[i]-((Scalar)other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Vector) other).value[i];
            }
            return new Vector(res);
        }
        else
            return super.sub(other);
    }

    @Override
    public Var mul (Var other) {
        Vector res=new Vector(value);
        double res1=0.0;
        if (other instanceof Scalar){
          for (int i = 0; i <res.value.length ; i++) {
                res.value[i]=res.value[i]*((Scalar)other).getValue();
            }
            return res;
        }
        else if (other instanceof Vector) {
            for (int i = 0; i < this.value.length; i++) {
                res1 = res1 + this.value[i] *((Vector) other).value[i];
            }
            return new Scalar(res1);
        }
        else
            return super.mul(other);
    }

    @Override
    public Var div (Var other) {
        Vector res=new Vector(value);
        if (other instanceof Scalar){
            for (int i = 0; i <res.value.length ; i++) {
                res.value[i]=res.value[i]/((Scalar)other).getValue();
            }
            return res;
        }

            return super.div(other);
    }



}

