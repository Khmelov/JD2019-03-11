package by.it.eslaikouskaya.jd03_03.beans;

public class Role {

	private long ID;
	private String role;

	public Role() {
	}

	public Role(long id, String role) {
		this.ID = id;
		this.role = role;
	}

	public long getID() {
		return ID;
	}

	public void setID(long ID) {
		this.ID = ID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Role{" +
				"ID=" + ID +
				", role='" + role + '\'' +
				'}';
	}
}