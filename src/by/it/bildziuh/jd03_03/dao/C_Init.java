package by.it.bildziuh.jd03_03.dao;

import by.it.bildziuh.jd03_03.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Init {

    public static void main(String[] args) throws SQLException {
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ){
            statement.executeUpdate("DROP SCHEMA IF EXISTS `bildziuh`");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `bildziuh` DEFAULT CHARACTER SET utf8 ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `bildziuh`.`roles` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`ID`))\n" +
                    "ENGINE = InnoDB;\n");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `bildziuh`.`users` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(100) NULL,\n" +
                    "  `password` VARCHAR(100) NULL,\n" +
                    "  `email` VARCHAR(100) NULL,\n" +
                    "  `roles_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`roles_id`)\n" +
                    "    REFERENCES `bildziuh`.`roles` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;\n");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `bildziuh`.`mods` (\n" +

                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `game` VARCHAR(45) NULL,\n" +
                    "  `group` VARCHAR(45) NULL,\n" +
                    "  `name` VARCHAR(45) NULL,\n" +
                    "  `description` VARCHAR(5000) NULL,\n" +
                    "  `size` INT NULL,\n" +
                    "  `link` VARCHAR(1000) NULL,\n" +
                    "  `users_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  CONSTRAINT `fk_mods_users1`\n" +
                    "    FOREIGN KEY (`users_id`)\n" +
                    "    REFERENCES `bildziuh`.`users` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `bildziuh`.`messages` (\n" +

                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `users_id` INT NOT NULL,\n" +
                    "  `text` VARCHAR(5000) NULL,\n" +
                    "  `mods_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  CONSTRAINT `fk_messages_mods1`\n" +
                    "    FOREIGN KEY (`mods_id`)\n" +
                    "    REFERENCES `bildziuh`.`mods` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("INSERT INTO `bildziuh`.`roles` (`id`, `role`) VALUES (DEFAULT, 'administrator');");
            statement.executeUpdate("INSERT INTO `bildziuh`.`roles` (`id`, `role`) VALUES (DEFAULT, 'moderator');");
            statement.executeUpdate("INSERT INTO `bildziuh`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');");
            statement.executeUpdate("INSERT INTO `bildziuh`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');");
            statement.executeUpdate("INSERT INTO `bildziuh`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'admin', 'admin', 'admin@gmail.com', 1);\n");
            statement.executeUpdate("INSERT INTO `bildziuh`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'user', 'user', 'user@mail.ru', 3);\n");
            statement.executeUpdate("INSERT INTO `bildziuh`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'user2', 'user2', 'user2@mail.ru', 3);\n");
            statement.executeUpdate("INSERT INTO `bildziuh`.`mods` (`ID`, `Game`, `Group`, `Name`, `Description`, `Size`, `Link`, `users_ID`) VALUES (DEFAULT, 'Skyrim', 'User interface', 'Better UI', 'Improve ur interface w/o registration and for free', 42, 'gdisk', 2);\n");
            statement.executeUpdate("INSERT INTO `bildziuh`.`mods` (`ID`, `Game`, `Group`, `Name`, `Description`, `Size`, `Link`, `users_ID`) VALUES (DEFAULT, 'Witcher 3', 'Animations', 'Killing spree', 'New animations', 84, 'gdisk', 3);\n");
            statement.executeUpdate("INSERT INTO `bildziuh`.`messages` (`ID`, `users_ID`, `text`, `mods_ID`) VALUES (DEFAULT, '2', 'Awesome mod!!111oneone', '2');\n");
        }
    }
}
