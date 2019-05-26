package by.it.khlystunova.jd03_03.dao;

//import by.it.khlystunova.jd03_03.C_Init;

//import java.sql.SQLException;

public class Dao {

    private static volatile Dao instance;


    public RoleDao role;
    public UserDao user;
    public RequestDao request;
    public FirmDao firm;
    public SteamDao steam;
    public CoffemachineDao coffemachine;


    //public void resetDataBase() throws SQLException {
    //    C_Init.main(new String[]{});
    //}

    private Dao() {
        role=new RoleDao();
        user=new UserDao();
        request=new RequestDao();
        firm=new FirmDao();
        steam=new SteamDao();
        coffemachine=new CoffemachineDao();

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
