package by.it.eslaikouskaya.jd03_03.beans;

public class Grade {
	private long ID;
	private String grade;
	private long categories_ID;

	public Grade() {
	}

	public Grade(long id, String grade, long categoriesId) {
		this.ID = id;
		this.grade = grade;
		this.categories_ID = categoriesId;
	}

	public long getID() {
		return ID;
	}

	public void setID(long ID) {
		this.ID = ID;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public long getCategories_ID() {
		return categories_ID;
	}

	public void setCategories_ID(long categories_ID) {
		this.categories_ID = categories_ID;
	}

	@Override
	public String toString() {
		return "Grade{" +
				"ID=" + ID +
				", Grade='" + grade + '\'' +
				", categories_ID=" + categories_ID +
				'}';
	}
}
