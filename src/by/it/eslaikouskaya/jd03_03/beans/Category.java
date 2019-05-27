package by.it.eslaikouskaya.jd03_03.beans;

public class Category {

	private long ID;
	private String category;

	public Category() {
	}

	public Category(long id, String category) {
		this.ID = id;
		this.category = category;
	}

	public long getID() {
		return ID;
	}

	public void setID(long ID) {
		this.ID = ID;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Category{" +
				"ID=" + ID +
				", category='" + category + '\'' +
				'}';
	}
}
