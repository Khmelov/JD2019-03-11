package by.it.narushevich.project.java;

import by.it.narushevich.project.java.beans.User;
import by.it.narushevich.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.List;

public class CmdDeleteUser extends Cmd {

    @Override
    Cmd execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getDao();
        long user_id = 0;
        String userName = req.getRemoteUser();
        String where = String.format("WHERE login='%s'",userName);
        List<User> users = dao.user.getAll(where);
        Iterator<User> it = users.iterator();
        if (it.hasNext()){
            user_id = it.next().getId();
        }
        User user = dao.user.read(user_id);
        boolean delete = dao.user.delete(user);
        if (delete)
            return Actions.INDEX.command;
        else
            return null;
    }
}
