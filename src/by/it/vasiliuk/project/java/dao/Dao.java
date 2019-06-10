package by.it.vasiliuk.project.java.dao;

import java.sql.SQLException;

public class Dao {

    private static volatile Dao instance;

    public RoleDao role;
    public UserDao user;
    public TaskDao task;

    public void resetDataBase() throws SQLException {
        C_Init.main(new String[]{});
    }

    private Dao() {
        role=new RoleDao();
        user=new UserDao();
        task=new TaskDao();
    }

    public static Dao getDao(){
        if (instance==null) {
            synchronized (Dao.class){
                if (instance==null){
                    instance=new Dao();
                }
            }
        }
        return instance;
    }
}
