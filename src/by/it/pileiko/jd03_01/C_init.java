package by.it.pileiko.jd03_01;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_init {

    private static final String URL = "jdbc:mysql://127.0.0.1:2016/?"+
            "useUnicode=true&" +
            "characterEncoding=UTF-8&" +
            "useJDBCCompliantTimezoneShift=true&" +
            "useLegacyDatetimeCode=false&" +
            "serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";


    public static void main(String[] args) throws SQLException {

        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement()
        )

        {
            statement.executeUpdate("DROP SCHEMA IF EXISTS `pileiko`");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `pileiko` DEFAULT CHARACTER SET utf8;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `pileiko`.`roles` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `Role` VARCHAR(50) NULL,\n" +
                    " PRIMARY KEY (`ID`))\n" +
                    "ENGINE = InnoDB;\n");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `pileiko`.`users` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `Login` VARCHAR(45) NULL,\n" +
                    "  `Password` VARCHAR(45) NULL,\n" +
                    "  `Email` VARCHAR(45) NULL,\n" +
                    "  `roles_ID` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`),\n" +
                    "   CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`roles_ID`)\n" +
                    "    REFERENCES `pileiko`.`roles` (`ID`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "   ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB\n");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `pileiko`.`cars` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +


                    "  `description` VARCHAR(5000) NULL,\n" +

                    "  `brand` VARCHAR(45) NULL,\n" +
                    "  `model` VARCHAR(45) NULL,\n" +

                    "  `engine` DOUBLE NULL,\n" +
                    "   `price` DOUBLE NULL,\n" +
                    "  `users_ID` INT NOT NULL,\n" +
                    "  `year` INT NULL,\n" +
                    "  PRIMARY KEY (`ID`),\n" +
                    "   CONSTRAINT `fk_cars_users1`\n" +
                    "    FOREIGN KEY (`users_ID`)\n" +
                    "     REFERENCES `pileiko`.`users` (`ID`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");

            statement.executeUpdate("INSERT INTO `pileiko`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Administrator');");
            statement.executeUpdate("INSERT INTO `pileiko`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'User');");
            statement.executeUpdate("INSERT INTO `pileiko`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Guest');");
            statement.executeUpdate("INSERT INTO `pileiko`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'admin', 'gfhjkm', 'admin@gmail.com', 1);");
            statement.executeUpdate("INSERT INTO `pileiko`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'user', 'uspass', 'us@mail.ru', 2);");
            statement.executeUpdate("INSERT INTO `pileiko`.`cars` (`ID`, `brand`, `model`, `engine`, `price`, `year`, `description`, `users_ID`) VALUES (DEFAULT, 'Audi', 'A6', 1800, 5500, 2001, 'norm avto', 2);");
            statement.executeUpdate("INSERT INTO `pileiko`.`cars` (`ID`, `brand`, `model`, `engine`, `price`, `year`, `description`, `users_ID`) VALUES (DEFAULT, 'Fiat', 'a500', 800, 8050, 2014, 'small and pretty', 1);");

        }

    }

}



