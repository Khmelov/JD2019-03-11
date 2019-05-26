package by.it.pileiko.jd03_02;

import by.it.pileiko.jd03_02.beans.User;
import by.it.pileiko.jd03_02.crud.UserCRUD;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        User user = new User(0, "Perviy", "parol", "pervy@mail.by", 2);
        UserCRUD userCRUD = new UserCRUD();
        userCRUD.create(user);
        user=userCRUD.read(user.getId());

        System.out.println(user);

    }

}
