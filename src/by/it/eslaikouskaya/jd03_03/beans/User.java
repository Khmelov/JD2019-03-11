package by.it.eslaikouskaya.jd03_03.beans;


public class User {

	private long ID;
	private String login;
	private String password;
	private String email;
	private long roles_ID;

	public User() {
	}

	public User(long id, String login, String password, String email, long rolesId) {
		this.ID = id;
		this.login = login;
		this.password = password;
		this.email = email;
		this.roles_ID = rolesId;
	}

	public long getID() {
		return ID;
	}

	public void setID(long ID) {
		this.ID = ID;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getRoles_ID() {
		return roles_ID;
	}

	public void setRoles_ID(long roles_ID) {
		this.roles_ID = roles_ID;
	}

	@Override
	public String toString() {
		return "User{" +
				"ID=" + ID +
				", login='" + login + '\'' +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				", roles_ID=" + roles_ID +
				'}';
	}
}