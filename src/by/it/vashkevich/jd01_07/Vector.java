package by.it.vashkevich.jd01_07;

import java.util.Arrays;

class Vector extends Var{
    private double[] value;

    Vector(double[] value) {
        this.value = Arrays.copyOf(value,value.length);
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String strValue) {
        StringBuilder sb = new StringBuilder(strValue);
        sb.deleteCharAt(0).deleteCharAt(sb.length() - 1);
        String str = sb.toString();
        String[] arrayString = str.split("[^\\d.]+");
        double[] arrayDouble = new double[arrayString.length];
        for (int i = 0; i < arrayString.length; i++) {
            arrayDouble[i] = Double.parseDouble(arrayString[i]);
        }
        this.value = arrayDouble;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delim = "";
        for (int i = 0; i < value.length; i++) {
            double element = value[i];
            sb.append(delim).append(element);
            delim = ", ";
        }
        sb.append(" }");
        return sb.toString();
    }
}
