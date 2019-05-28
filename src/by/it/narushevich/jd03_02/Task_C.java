package by.it.narushevich.jd03_02;

import by.it.narushevich.jd03_02.beans.*;
import by.it.narushevich.jd03_02.crud.*;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Task_C {
    public static void main(String[] args) throws SQLException {
        Driver driver = new FabricMySQLDriver();
        DriverManager.registerDriver(driver);

        try (Connection connection = ConnectionCreator.get();
             Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate("DROP TABLE IF EXISTS teatags");
            statement.executeUpdate("DROP TABLE IF EXISTS material");
            statement.executeUpdate("DROP TABLE IF EXISTS trademark");
            statement.executeUpdate("DROP TABLE IF EXISTS users");
            statement.executeUpdate("DROP TABLE IF EXISTS roles");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS roles (" +
                    "  id INT NOT NULL AUTO_INCREMENT," +
                    "  role VARCHAR(45) NULL," +
                    "  PRIMARY KEY (id))");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS users (" +
                    "  id INT NOT NULL AUTO_INCREMENT," +
                    "  login VARCHAR(15) NULL," +
                    "  password VARCHAR(15) NULL," +
                    "  email VARCHAR(25) NULL," +
                    "  roles_id INT NOT NULL, " +
                    "  PRIMARY KEY (id)," +
                    "  CONSTRAINT fk_users_roles" +
                    "  FOREIGN KEY (roles_id)" +
                    "  REFERENCES narushevich.roles (id)" +
                    "  ON DELETE RESTRICT" +
                    "  ON UPDATE RESTRICT)");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS material (" +
                    "  id INT NOT NULL AUTO_INCREMENT," +
                    "  material VARCHAR(10) NULL," +
                    "  PRIMARY KEY (id))");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS trademark (" +
                    "  id INT NOT NULL AUTO_INCREMENT," +
                    "  trademark VARCHAR(15) NULL," +
                    "  PRIMARY KEY (id))");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS teatags (" +
                    "  id INT NOT NULL AUTO_INCREMENT," +
                    "  trademark_id INT NOT NULL," +
                    "  subtitle VARCHAR(45) NULL," +
                    "  material_id INT NOT NULL," +
                    "  width DECIMAL NULL," +
                    "  height DECIMAL NULL," +
                    "  in_collection_since DATE NULL," +
                    "  num_in_catalog VARCHAR(7) NULL," +
                    "  users_id INT NOT NULL," +
                    "  PRIMARY KEY (id)," +
                    "  CONSTRAINT fk_teatags_users1" +
                    "    FOREIGN KEY (users_id)" +
                    "    REFERENCES narushevich.users (id)" +
                    "    ON DELETE CASCADE" +
                    "    ON UPDATE CASCADE," +
                    "  CONSTRAINT fk_teatags_material1" +
                    "    FOREIGN KEY (material_id)" +
                    "    REFERENCES narushevich.material (id)" +
                    "    ON DELETE RESTRICT" +
                    "    ON UPDATE CASCADE," +
                    "  CONSTRAINT fk_teatags_trademark1" +
                    "    FOREIGN KEY (trademark_id)" +
                    "    REFERENCES narushevich.trademark (id)" +
                    "    ON DELETE RESTRICT" +
                    "    ON UPDATE CASCADE)");
            RoleCRUD roleCRUD = new RoleCRUD();
            roleCRUD.create(new Role(0, "administrator"));
            roleCRUD.create(new Role(0, "user"));
            roleCRUD.create(new Role(0, "moderator"));
            roleCRUD.create(new Role(0, "guest"));
            UserCRUD userCRUD = new UserCRUD();
            userCRUD.create(new User(0, "masha_05", "qwerty", "masha_05@tut.by", 1));
            userCRUD.create(new User(0, "fr_pol", "asdfgh", "pol_zhan@gmail.com", 2));
            userCRUD.create(new User(0, "dimon_rus", "wasder", "dimas@mail.ru", 2));
            MaterialCRUD materialCRUD = new MaterialCRUD();
            materialCRUD.create(new Material(0, "cardboard"));
            materialCRUD.create(new Material(0, "paper"));
            materialCRUD.create(new Material(0, "plastic"));
            TrademarkCRUD trademarkCRUD = new TrademarkCRUD();
            trademarkCRUD.create(new Trademark(0, "Ahmad tea"));
            trademarkCRUD.create(new Trademark(0, "Akbar"));
            trademarkCRUD.create(new Trademark(0, "Alattar"));
            trademarkCRUD.create(new Trademark(0, "Auchan"));
            trademarkCRUD.create(new Trademark(0, "Brooke Bond"));
            trademarkCRUD.create(new Trademark(0, "Chelton"));
            trademarkCRUD.create(new Trademark(0, "Dilmah"));
            trademarkCRUD.create(new Trademark(0, "Forest of Arden"));
            trademarkCRUD.create(new Trademark(0, "Golden Bowl"));
            trademarkCRUD.create(new Trademark(0, "Greenfield"));
            trademarkCRUD.create(new Trademark(0, "Jaf Tea"));
            trademarkCRUD.create(new Trademark(0, "Kakoo"));
            trademarkCRUD.create(new Trademark(0, "Lipton"));
            trademarkCRUD.create(new Trademark(0, "Lord Nelson"));
            trademarkCRUD.create(new Trademark(0, "Mabroc"));
            trademarkCRUD.create(new Trademark(0, "Maitre de The"));
            trademarkCRUD.create(new Trademark(0, "Malwa"));
            trademarkCRUD.create(new Trademark(0, "Messmer"));
            trademarkCRUD.create(new Trademark(0, "Mistral"));
            trademarkCRUD.create(new Trademark(0, "Natursan"));
            trademarkCRUD.create(new Trademark(0, "Pickwick"));
            trademarkCRUD.create(new Trademark(0, "Princess Java"));
            trademarkCRUD.create(new Trademark(0, "Tea"));
            TeatagCRUD teatagCRUD = new TeatagCRUD();
//           teatagCRUD.create(new Teatag(0,1, "English Tea #1", 1, 28, 32, 2017.04.01, "02-08-3", 1));
//            teatagCRUD.create(new Teatag(0,1,"Cinnamon Haze",1, 28, 32, 2018.05.05,"02-08-4",1));
//            teatagCRUD.create(new Teatag(0,1, "Earl Grey", 1, 28, 32, 2002.01.07, "02-09-1", 1));
//            teatagCRUD.create(new Teatag(0,1, "Earl Grey", 1, 28, 32, 2005.09.14, "02-09-2", 1));
//            teatagCRUD.create(new Teatag(0,1, "Green Tea", 1, 28, 32, 2008.04.18, "02-09-4", 1));
//            teatagCRUD.create(new Teatag(0,1, "English Breakfast", 1, 28, 32, 2001.04.05, "02-10-1", 1));
//            teatagCRUD.create(new Teatag(0,1, "English Breakfast", 1, 28, 32, 1998.10.18, "02-10-2", 1));
//            teatagCRUD.create(new Teatag(0,1, "Lemon & Lime Twist", 1, 28, 32, 2018.01.06, "02-10-3", 1));
//            teatagCRUD.create(new Teatag(0,1, "Classic black tea", 1, 28, 32, 2013.05.20, "02-10-4", 1));
//            teatagCRUD.create(new Teatag(0,13, "Yellow Label tea", 1, 28, 32, 2012.03.20, "02-11-2", 1));
//            teatagCRUD.create(new Teatag(0,13, "Yellow Label tea", 1, 28, 32, 2005.03.20, "02-11-1", 1));
//            teatagCRUD.create(new Teatag(0,13, "Royal Ceylon", 1, 28, 32, 2003.05.10, "02-11-3", 1));
//            teatagCRUD.create(new Teatag(0,13, "A moment to energise", 1, 26, 28, 2017.12.31, "02-13-2", 1));
//            teatagCRUD.create(new Teatag(0,13, "A moment to balance", 1, 26, 28, 2017.12.31, "02-13-3", 1));
//            teatagCRUD.create(new Teatag(0,13, "pure black ceylon", 2, 22, 22, 2007.02.15, "01-17-1", 1));
//            teatagCRUD.create(new Teatag(0,13, "cherry morello", 2, 22, 22, 2007.10.12, "01-17-2", 1));
//            teatagCRUD.create(new Teatag(0,13, "pear chocolate", 2, 22, 22, 2007.08.29, "01-17-3", 1));
//            teatagCRUD.create(new Teatag(0,13, "flirty lady", 2, 20, 20, 2015.07.14, "01-17-4", 1));
//            teatagCRUD.create(new Teatag(0,13, "blue fruit", 2, 22, 22, 2011.03.20, "01-17-5", 1));
//            teatagCRUD.create(new Teatag(0,13, "Orange Jaipur", 2, 22, 22, 2006.12.16, "01-18-3", 1));
//            teatagCRUD.create(new Teatag(0,11, "temptation", 1, 23, 28, 2001.10.02, "01-14-1", 1));
//            teatagCRUD.create(new Teatag(0,10, "finelly selected speciality tea", 2, 20, 28, 2003.05.16, "01-15-1", 1));
//            teatagCRUD.create(new Teatag(0,22, "black", 2, 20, 28, 2000.12.28, "01-06-1", 1));
//            teatagCRUD.create(new Teatag(0,20, "La via del te firenze", 2, 20, 28, 2005.09.12, "01-04-5", 1));
//            teatagCRUD.create(new Teatag(0,19, "Cristmas tea", 1, 23, 28, 2017.12.25, "01-27-1", 1));
//            teatagCRUD.create(new Teatag(0,6, "100% pure ceylon tea", 1, 28, 32, 2003.11.12, "02-04-2", 1));
//            teatagCRUD.create(new Teatag(0,4, "Black tea", 1, 28, 32, 2018.04.06, "02-01-1", 1));
//            teatagCRUD.create(new Teatag(0,13, "Russian Earl Grey", 1, 25, 30, 2010.05.20, "02-12-4", 1));
//            teatagCRUD.create(new Teatag(0,2, "English breakfast", 1, 28, 32, 2007.08.31, "02-19-4", 1));
//            teatagCRUD.create(new Teatag(0,2, "flavoured tea", 1, 28, 32, 2011.05.10, "02-19-3", 1));
//            teatagCRUD.create(new Teatag(0,14, "Lemon & Ginger", 1, 28, 32, 2015.10.18, "02-21-2", 1));
//            teatagCRUD.create(new Teatag(0,8, "2006", 2, 20, 28, 2008.09.15, "01-02-4", 2));
//            teatagCRUD.create(new Teatag(0,15, "1001 night", 2, 20, 28, 2010.04.20, "01-02-2", 2));
//            teatagCRUD.create(new Teatag(0,16, "Noir", 2, 23, 28, 2002.01.19, "01-04-2", 2));
//            teatagCRUD.create(new Teatag(0,18, "Zitrone", 1, 28, 32, 2009.02.14, "02-26-1", 2));
//            teatagCRUD.create(new Teatag(0,12, "Green tea bags", 2, 25, 28, 2010.11.05, "02-26-2", 2));
//            teatagCRUD.create(new Teatag(0,23, "green", 2, 20, 20, 2010.11.06, "01-03-3", 2));
//            teatagCRUD.create(new Teatag(0,7, "Ceylon gold", 2, 25, 30, 2010.04.09, "02-06-3", 2));
//            teatagCRUD.create(new Teatag(0,7, "Lychee", 2, 20, 28, 2012.03.22, "01-09-4", 2));
//            teatagCRUD.create(new Teatag(0,7, "Earl Grey", 2, 20, 28, 2012.01.19, "01-09-5", 2));
//            teatagCRUD.create(new Teatag(0,7, "Strawberry tea", 2, 20, 28, 2012.06.15, "01-09-2", 2));
//            teatagCRUD.create(new Teatag(0,7, "Natural green tea", 2, 20, 28, 2012.07.25, "01-09-1", 2));
//            teatagCRUD.create(new Teatag(0,21, "finest taste", 2, 25, 30, 2006.07.14, "01-16-1", 2));
//            teatagCRUD.create(new Teatag(0,17, "Exclusive smak natury", 2, 20, 28, 2016.12.15, "01-24-3", 2));
//            teatagCRUD.create(new Teatag(0,5, "history", 1, 28, 32, 2008.04.14, "02-35-1", 3));
//            teatagCRUD.create(new Teatag(0,5, "history", 1, 28, 32, 2008.04.14, "02-35-2", 3));
//            teatagCRUD.create(new Teatag(0,5, "history", 1, 28, 32, 2008.04.14, "02-35-3", 3));
//            teatagCRUD.create(new Teatag(0,9, "strawberry", 2, 25, 28, 2011.06.30, "02-39-3", 3));
//            teatagCRUD.create(new Teatag(0,9, "green tea", 1, 26, 28, 2010.03.25, "02-38-4", 3));
//            teatagCRUD.create(new Teatag(0,9, "black tea", 1, 28, 32, 2007.12.15, "02-38-3", 3));
//            teatagCRUD.create(new Teatag(0,9, "indian", 1, 26, 28, 2010.05.04, "02-38-1", 3));
        }
    }
}
