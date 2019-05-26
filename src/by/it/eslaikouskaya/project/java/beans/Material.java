package by.it.eslaikouskaya.project.java.beans;

public class Material {

	private long ID;
	private String name;
	private int price;
	private long grades_ID;

	public Material() {
	}

	public Material(long id, String name, int price, long grades_ID) {
		this.ID = id;
		this.name = name;
		this.price = price;
		this.grades_ID = grades_ID;
	}

	public long getID() {
		return ID;
	}

	public void setID(long ID) {
		this.ID = ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public long getGrades_ID() {
		return grades_ID;
	}

	public void setGrades_ID(long grades_ID) {
		this.grades_ID = grades_ID;
	}

	@Override
	public String toString() {
		return "Material{" +
				"ID=" + ID +
				", name='" + name + '\'' +
				", price='" + price + '\'' +
				", grades_ID=" + grades_ID +
				'}';
	}
}
