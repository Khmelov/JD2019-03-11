package by.it.eslaikouskaya.project.java;

import by.it.eslaikouskaya.project.java.beans.Grade;
import by.it.eslaikouskaya.project.java.dao.Dao;
import by.it.eslaikouskaya.project.java.utils.FormHelper;
import by.it.eslaikouskaya.project.java.utils.Validator;

import javax.servlet.http.HttpServletRequest;

public class CmdCreateGrade extends Cmd {
	@Override
	public Cmd execute(HttpServletRequest req) throws Exception {

		if (FormHelper.isPost(req)) {
			Grade grade = new Grade(
					0,
					Validator.getString(req, "grade"),
					Validator.getLong(req, "categories_ID")
			);

			Dao dao = Dao.getDao();
			if (dao.grade.create(grade)) {
				return Actions.SHOWGRADES.command;
			}
		}
		return null;
	}
}
