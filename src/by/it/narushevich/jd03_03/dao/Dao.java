package by.it.narushevich.jd03_03.dao;

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
}
