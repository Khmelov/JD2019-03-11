package by.it.bildziuh.jd03_03.dao;

import java.sql.SQLException;

public class Dao {

    private static volatile Dao instance;

    public RoleDao role;
    public UserDao user;
    public ModDao mod;

    public void resetDataBase() throws SQLException {
        C_Init.main(new String[]{});
    }

    public void showUsers()throws SQLException {
        ShowUsers.main(new String[]{});
    }

    private Dao() {
        role=new RoleDao();
        user=new UserDao();
        mod=new ModDao();
    }

    public static Dao getDao(){
        if (instance==null){
            synchronized (Dao.class){
                if (instance==null){
                    instance=new Dao();
                }
            }
        }

        return instance;
    }


}
