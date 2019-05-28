package by.it.eslaikouskaya.project.java.beans;

public class Purchase {

	private long ID;
	private long users_ID;
	private long materials_ID;
	private int number;

	public Purchase() {
	}

	public Purchase(long id, long usersID, long materialsID, int number) {
		this.ID = id;
		this.users_ID = usersID;
		this.materials_ID = materialsID;
		this.number = number;
	}

	public long getID() {
		return ID;
	}

	public void setID(long ID) {
		this.ID = ID;
	}

	public long getUsers_ID() {
		return users_ID;
	}

	public void setUsers_ID(long users_ID) {
		this.users_ID = users_ID;
	}

	public long getMaterials_ID() {
		return materials_ID;
	}

	public void setMaterials_ID(long materials_ID) {
		this.materials_ID = materials_ID;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Purchase{" +
				"ID=" + ID +
				", users_ID=" + users_ID +
				", materials_ID=" + materials_ID +
				", number=" + number +
				'}';
	}
}
