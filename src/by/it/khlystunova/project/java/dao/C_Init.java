package by.it.khlystunova.project.java.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Init {

    private static final String URL="jdbc:mysql://127.0.0.1:2016/";
    private static final String USER="root";
    private static final String PASSWORD="";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception ex) {
            // handle the error
        }
    }

    public static void main(String[] args) throws SQLException {
        try (Connection connection= DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate("DROP SCHEMA IF EXISTS `khlystunova`");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `khlystunova` DEFAULT CHARACTER SET utf8 ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `khlystunova`.`roles` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `Role` VARCHAR(50) NULL,\n" +
                    "  PRIMARY KEY (`ID`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `khlystunova`.`users` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `Login` VARCHAR(45) NULL,\n" +
                    "  `Password` VARCHAR(45) NULL,\n" +
                    "  `Email` VARCHAR(45) NULL,\n" +
                    "  `roles_ID` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`),\n" +
                    "  UNIQUE INDEX `Login_UNIQUE` (`Login` ASC),\n" +
                    "  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`roles_ID`)\n" +
                    "    REFERENCES `khlystunova`.`roles` (`ID`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `khlystunova`.`coffemachines` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `Name` VARCHAR(50) NULL,\n" +
                    "  `Firm` VARCHAR(45) NULL,\n" +
                    "  `Power` VARCHAR(45) NULL,\n" +
                    "  `Size` VARCHAR(50) NULL,\n" +
                    "  `Weight` DOUBLE NULL,\n" +
                    "  `WaterContainer` VARCHAR(45) NULL,\n" +
                    "  `BeansContainer` VARCHAR(45) NULL,\n" +
                    "  `Color` VARCHAR(45) NULL,\n" +
                    "  `Price` DOUBLE NULL,\n" +
                    "  PRIMARY KEY (`ID`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `khlystunova`.`requests` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `users_ID` INT NOT NULL,\n" +
                    "  `Contact` VARCHAR(45) NULL,\n" +
                    "  `DeliveryAddress` VARCHAR(50) NULL,\n" +
                    "  `coffemachines_ID` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`),\n" +
                    "  CONSTRAINT `fk_requests_users1`\n" +
                    "    FOREIGN KEY (`users_ID`)\n" +
                    "    REFERENCES `khlystunova`.`users` (`ID`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE,\n" +
                    "  CONSTRAINT `fk_requests_coffemachines1`\n" +
                    "    FOREIGN KEY (`coffemachines_ID`)\n" +
                    "    REFERENCES `khlystunova`.`coffemachines` (`ID`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("INSERT INTO `khlystunova`.`roles` (`ID`, `Role`) VALUES (1, 'Administrator');\n");
            statement.executeUpdate("INSERT INTO `khlystunova`.`roles` (`ID`, `Role`) VALUES (2, 'User');\n");
            statement.executeUpdate("INSERT INTO `khlystunova`.`roles` (`ID`, `Role`) VALUES (3, 'Guest');\n");
            statement.executeUpdate("INSERT INTO `khlystunova`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'admin', 'padmin', 'admin@gmail.com', 1);\n");
            statement.executeUpdate("INSERT INTO `khlystunova`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'Petrov', 'puser', 'user@gmail.com', 2);\n");
            statement.executeUpdate("INSERT INTO `khlystunova`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'Sidorov', 'psidorov', 'sidorov@mail.ru', 2);\n");
            statement.executeUpdate("INSERT INTO `khlystunova`.`coffemachines` (`ID`, `Name`, `Firm`, `Power`, `Size`, `Weight`, `WaterContainer`, `BeansContainer`, `Color`, `Price`) VALUES (DEFAULT, 'LC/D', 'SAECO', '230-240 B / 50-60 Gc/5 kvt', '625x472x510 ', 49.3, '13 L', '7 l', 'Metalic', 5650);\n");
            statement.executeUpdate("INSERT INTO `khlystunova`.`coffemachines` (`ID`, `Name`, `Firm`, `Power`, `Size`, `Weight`, `WaterContainer`, `BeansContainer`, `Color`, `Price`) VALUES (DEFAULT, 'GE-GD ONE', 'GAGGIA', '230-240 B / 50-60 Gc/5 kvt', '530x550x420 ', 30.4, '2,3 L', '2 l', 'Red', 4620);\n");
            statement.executeUpdate("INSERT INTO `khlystunova`.`coffemachines` (`ID`, `Name`, `Firm`, `Power`, `Size`, `Weight`, `WaterContainer`, `BeansContainer`, `Color`, `Price`) VALUES (DEFAULT, 'EP 5331/10', 'PHILIPS', '-', '221x340x430', 8.8, '1.8 L', '250g', 'White', 1449);\n");
            statement.executeUpdate("INSERT INTO `khlystunova`.`coffemachines` (`ID`, `Name`, `Firm`, `Power`, `Size`, `Weight`, `WaterContainer`, `BeansContainer`, `Color`, `Price`) VALUES (DEFAULT, ' XD COMPACT', 'GAGGIA ', '230-240 B / 50-60 Gc/3,2 kvt', '310x470x510', 35, '4.9 L', '-', 'Metalic', 1330);\n");
            statement.executeUpdate("INSERT INTO `khlystunova`.`coffemachines` (`ID`, `Name`, `Firm`, `Power`, `Size`, `Weight`, `WaterContainer`, `BeansContainer`, `Color`, `Price`) VALUES (DEFAULT, ' DELONGHI EN 550.S', 'NESPRESSO ', '-', '167x253x319', 4.79, '0.9 L', '-', 'Black', 749);\n");
            statement.executeUpdate("INSERT INTO `khlystunova`.`requests` (`ID`, `users_ID`, `Contact`, `DeliveryAddress`, `coffemachines_ID`) VALUES (DEFAULT, 2, '+375293455837', 'Frolova27f3', 1);\n");
            statement.executeUpdate("INSERT INTO `khlystunova`.`requests` (`ID`, `users_ID`, `Contact`, `DeliveryAddress`, `coffemachines_ID`) VALUES (DEFAULT, 3, '+375296256313', 'Pr.Mira27b12', 2);\n");
        }
    }
}
