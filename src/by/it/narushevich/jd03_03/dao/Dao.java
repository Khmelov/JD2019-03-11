package by.it.narushevich.jd03_03.dao;

import java.sql.SQLException;

public class Dao {
    private static volatile Dao instance;

    public RoleDao role;
    public UserDao user;
    public TrademarkDao trademark;
    public MaterialDao material;
    public TeatagDaoUniversal teatag;

    private Dao() {
        role=new RoleDao();
        user=new UserDao();
        trademark = new TrademarkDao();
        material = new MaterialDao();
        teatag = new TeatagDaoUniversal();
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
