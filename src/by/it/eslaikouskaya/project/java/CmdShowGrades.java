package by.it.eslaikouskaya.project.java;

import by.it.eslaikouskaya.project.java.beans.Grade;
import by.it.eslaikouskaya.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdShowGrades extends Cmd {
	@Override
	Cmd execute(HttpServletRequest req) throws Exception {
		Dao dao = Dao.getDao();
		List<Grade> grades = dao.grade.getAll();
		req.setAttribute("grades", grades);
		return null;
	}
}
