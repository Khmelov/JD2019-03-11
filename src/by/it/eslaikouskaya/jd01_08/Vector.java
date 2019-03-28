package by.it.eslaikouskaya.jd01_08;

import java.util.Arrays;

class Vector extends Var {

	private double[] value;

	public double[] getValue() {
		return value;
	}


	@Override
	public Var add(Var other) {
		Vector result = new Vector(value);
		this.value=Arrays.copyOf(value,value.length);
		if (other instanceof Scalar) {
			for (int i = 0; i < result.value.length; i++) {
				result.value[i] = result.value[i] + ((Scalar) other).getValue();
			}
			return result;
		}
		if (other instanceof Vector) {
			for (int i = 0; i < result.value.length; i++) {
				result.value[i] = result.value[i] + ((Vector) other).value[i];
			}
			return result;
		}
		return super.add(other);
	}

	@Override
	public Var sub(Var other) {
		Vector result = new Vector(value);
		this.value=Arrays.copyOf(value,value.length);
		if (other instanceof Scalar) {
			for (int i = 0; i < result.value.length; i++) {
				result.value[i] = result.value[i] - ((Scalar) other).getValue();
			}
			return result;
		}
		if (other instanceof Vector) {
			for (int i = 0; i < result.value.length; i++) {
				result.value[i] = result.value[i] - ((Vector) other).value[i];
			}
			return result;
		}
		return super.sub(other);
	}

	@Override
	public Var mul(Var other) {
		Vector result = new Vector(value);
		this.value=Arrays.copyOf(value,value.length);
		if (other instanceof Scalar) {
			for (int i = 0; i < result.value.length; i++) {
				result.value[i] = result.value[i] * ((Scalar) other).getValue();
			}
			return result;
		}

		if (other instanceof Vector) {
			double sum = 0;
			for (int i = 0; i < result.value.length; i++) {
				result.value[i] = result.value[i] * ((Vector) other).value[i];
				sum=sum+result.value[i];
			}
			return new Scalar(sum);
		}
		return super.mul(other);
	}

	@Override
	public Var div(Var other) {
		Vector result = new Vector(value);
		this.value=Arrays.copyOf(value,value.length);
		if (other instanceof Scalar) {
			for (int i = 0; i < result.value.length; i++) {
				result.value[i] = result.value[i] / ((Scalar) other).getValue();
			}
			return result;
		}
		return super.div(other);
	}

	Vector(double[] value){
		this.value=Arrays.copyOf(value,value.length);
	}


	Vector(Vector vector){
		this.value=vector.value;
	}


	Vector(String strVector){
		StringBuilder sb = new StringBuilder(strVector);
		sb.deleteCharAt(0).deleteCharAt(sb.length()-1);
		String str = sb.toString();
		String[] arrayString = str.split("[^\\d.]+");
		double[]arrayDouble = new double[arrayString.length];
		for (int i = 0; i < arrayString.length; i++) {
			arrayDouble[i] = Double.parseDouble(arrayString[i]);
		}
		this.value=arrayDouble;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("{");
		String delimiter = "";
		for (double element : value) {
			sb.append(delimiter).append(element);
			delimiter=", ";
		}
		sb.append("}");

		return sb.toString();
	}
}
