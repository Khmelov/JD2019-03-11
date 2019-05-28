package by.it.eslaikouskaya.project.java;

import by.it.eslaikouskaya.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdResetDB extends Cmd {
	@Override
	Cmd execute(HttpServletRequest req) throws Exception {
		Dao dao = Dao.getDao();
		dao.resetDataBase();
		return Actions.INDEX.command;
	}
}
