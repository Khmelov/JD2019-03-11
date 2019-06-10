package by.it.vasiliuk.project.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Init {

    private static final String URL="jdbc:mysql://127.0.0.1:2016/";
    private static final String USER="root";
    private static final String PASSWORD="";


    public static void main(String[] args) throws SQLException {
        try (
        Connection connection= DriverManager.getConnection(URL,USER,PASSWORD);
        Statement statement = connection.createStatement()
        ){
            statement.executeUpdate("DROP SCHEMA IF EXISTS `vasiliuk` ;\n");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `vasiliuk` DEFAULT CHARACTER SET utf8 ;\n");
            statement.executeUpdate("DROP TABLE IF EXISTS `vasiliuk`.`roles` ;\n");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `vasiliuk`.`roles` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(100) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("DROP TABLE IF EXISTS `vasiliuk`.`users` ;\n");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `vasiliuk`.`users` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(100) NULL,\n" +
                    "  `password` VARCHAR(100) NULL,\n" +
                    "  `email` VARCHAR(100) NULL,\n" +
                    "  `phone` VARCHAR(20) NULL,\n" +
                    "  `roles_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  UNIQUE `login_UNIQUE` (`login` ASC),\n" +
                    "  UNIQUE `email_UNIQUE` (`email` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`roles_id`)\n" +
                    "    REFERENCES `vasiliuk`.`roles` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("DROP TABLE IF EXISTS `vasiliuk`.`tasks` ;\n");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `vasiliuk`.`tasks` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `task_type` VARCHAR(100) NULL,\n" +
                    "  `tag` VARCHAR(100) NULL,\n" +
                    "  `grp_project` VARCHAR(100) NULL,\n" +
                    "  `date_year` VARCHAR(100) NULL,\n" +
                    "  `stask_type` VARCHAR(100) NULL,\n" +
                    "  `sallary` DOUBLE NULL,\n" +
                    "  `users_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  CONSTRAINT `fk_tasks_users1`\n" +
                    "    FOREIGN KEY (`users_id`)\n" +
                    "    REFERENCES `vasiliuk`.`users` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("INSERT INTO `vasiliuk`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');\n");
            statement.executeUpdate("INSERT INTO `vasiliuk`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');\n");
            statement.executeUpdate("INSERT INTO `vasiliuk`.`roles` (`id`, `role`) VALUES (DEFAULT, 'moderator');\n");
            statement.executeUpdate("INSERT INTO `vasiliuk`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');\n");
            statement.executeUpdate("INSERT INTO `vasiliuk`.`users` (`id`, `login`, `password`, `email`, `phone`, `roles_id`) VALUES (DEFAULT, 'admin', 'admin', 'kostja100pro@gmail.com', '+375297326543', 1);\n");
            statement.executeUpdate("INSERT INTO `vasiliuk`.`users` (`id`, `login`, `password`, `email`, `phone`, `roles_id`) VALUES (DEFAULT, 'nikolaj', 'jalokin', 'nikolajab@mail.ru', '+375335897326', 2);\n");
            statement.executeUpdate("INSERT INTO `vasiliuk`.`users` (`id`, `login`, `password`, `email`, `phone`, `roles_id`) VALUES (DEFAULT, 'dinis', 'sinid', 'dinis228@gmail.com', '+375442417438', 2);\n");
            statement.executeUpdate("INSERT INTO `vasiliuk`.`users` (`id`, `login`, `password`, `email`, `phone`, `roles_id`) VALUES (DEFAULT, 'moderator1', 'rotaredom1', 'moderator1@gmail.com', '+375297634920', 3);\n");
            statement.executeUpdate("INSERT INTO `vasiliuk`.`users` (`id`, `login`, `password`, `email`, `phone`, `roles_id`) VALUES (DEFAULT, 'moderator2', 'rotaredom2', 'moderator2@gmail.com', '+375297634921', 3);\n");
            statement.executeUpdate("INSERT INTO `vasiliuk`.`users` (`id`, `login`, `password`, `email`, `phone`, `roles_id`) VALUES (DEFAULT, 'user1', '0000', 'test1@yandex.ru', '+375297634900', 4);\n");
            statement.executeUpdate("INSERT INTO `vasiliuk`.`users` (`id`, `login`, `password`, `email`, `phone`, `roles_id`) VALUES (DEFAULT, 'user2', '0000', 'test2@yandex.ru', '+375297634900', 4);\n");
            statement.executeUpdate("INSERT INTO `vasiliuk`.`users` (`id`, `login`, `password`, `email`, `phone`, `roles_id`) VALUES (DEFAULT, 'maksim', 'miskam', 'maksim1997@mail.ru', '+375335356226', 2);\n");
            statement.executeUpdate("INSERT INTO `vasiliuk`.`tasks` (`id`, `task_type`, `tag`, `grp_project`, `date_year`, `stask_type`, `sallary`, `users_id`) VALUES (DEFAULT, 'classic', 'Exercises', 'group one', '2019', 'Repeated', 4395, 2);\n");
            statement.executeUpdate("INSERT INTO `vasiliuk`.`tasks` (`id`, `task_type`, `tag`, `grp_project`, `date_year`, `stask_type`, `sallary`, `users_id`) VALUES (DEFAULT, 'repeated', 'School', 'group best', '2018', 'Classic', 26470, 2);\n");
            statement.executeUpdate("INSERT INTO `vasiliuk`.`tasks` (`id`, `task_type`, `tag`, `grp_project`, `date_year`, `stask_type`, `sallary`, `users_id`) VALUES (DEFAULT, 'nowtime', 'Work', 'group last', '2019', 'Nowtime', 799, 3);\n");
            statement.executeUpdate("INSERT INTO `vasiliuk`.`tasks` (`id`, `task_type`, `tag`, `grp_project`, `date_year`, `stask_type`, `sallary`, `users_id`) VALUES (DEFAULT, 'classic', 'Travel', 'group context', '2020', 'Classic', 3602, 8);\n");
            statement.executeUpdate("INSERT INTO `vasiliuk`.`tasks` (`id`, `task_type`, `tag`, `grp_project`, `date_year`, `stask_type`, `sallary`, `users_id`) VALUES (DEFAULT, 'repeated', 'Troubles', 'group java', '2017', 'Nowtime', 13636, 8);\n");
        }

    }
}
