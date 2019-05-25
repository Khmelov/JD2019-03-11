package by.it.narushevich.project.java;

import by.it.narushevich.project.java.dao.C_init;
import by.it.narushevich.project.java.dao.Dao;
import by.it.narushevich.project.java.dao.Printer;

import java.sql.SQLException;

public class Runner_Dao {
    public static void main(String[] args) throws SQLException {

        resetDataBase();

        Dao dao = Dao.getDao();

        Printer.print_user_dao(dao);

        Printer.print_role_dao(dao);

        Printer.print_material_dao(dao);

        Printer.print_trademark_dao(dao);

        Printer.print_teatag_dao(dao);
    }

    private static void resetDataBase() throws SQLException {
        C_init.main(new String[]{});
    }
}
