package by.it.eslaikouskaya.jd03_03.dao;

import java.sql.SQLException;

public class Dao {

	private static volatile Dao instance;

	public RoleDao role;
	public UserDao user;
	public PurchaseDao purchase;
	public MaterialDao material;
	public GradeDao grade;
	public CategoryDao category;

	public void resetDataBase() throws SQLException {
		C_Init.main(new String[]{});
	}

	private Dao() {
		role = new RoleDao();
		user = new UserDao();
		purchase = new PurchaseDao();
		material = new MaterialDao();
		grade = new GradeDao();
		category = new CategoryDao();
	}

	public static Dao getDao() {
		if (instance == null) {
			synchronized (Dao.class) {
				if (instance == null) {
					instance = new Dao();
				}
			}
		}

		return instance;
	}


}
