package by.it.narushevich.project.java.dao;

import java.sql.SQLException;

public class Dao {
    private static volatile Dao instance;

    public RoleDao role;
    public UserDao user;
    public TrademarkDao trademark;
    public MaterialDao material;
    public TeatagDao teatag;

    private Dao() {
        role=new RoleDao();
        user=new UserDao();
        trademark = new TrademarkDao();
        material = new MaterialDao();
        teatag = new TeatagDao();
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

    public static void resetDataBase() throws SQLException {
        C_init.main(new String[] {});
    }
}
