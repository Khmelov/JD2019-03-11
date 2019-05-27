package by.it.eslaikouskaya.project.java.dao;

import by.it.eslaikouskaya.project.java.beans.Grade;
import by.it.eslaikouskaya.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GradeDao extends AbstractDao<Grade> {
	@Override
	public boolean create(Grade grade) throws SQLException {
		String sql = String.format(Locale.ENGLISH,
				"INSERT INTO " +
						"`grades`(`grade`, `categories_ID`) " +
						"VALUES ('%s',%d)",
				grade.getGrade(), grade.getCategories_ID()
		);
		long id = executeCreate(sql);
		if (id > 0)
			grade.setID(id);
		return id > 0;
	}

	@Override
	public boolean update(Grade grade) throws SQLException {
		String sql = String.format(Locale.ENGLISH,
				"UPDATE `grades` " +
						"SET `grade`='%s',`categories_ID`='%d'" +
						" WHERE `id`=%d",
				grade.getGrade(), grade.getCategories_ID(), grade.getID());
		return executeUpdate(sql);
	}

	@Override
	public boolean delete(Grade grade) throws SQLException {
		String sql = String.format(Locale.ENGLISH, "DELETE FROM `grades` WHERE `id`=%d", grade.getID());
		return executeUpdate(sql);
	}

	@Override
	public List<Grade> getAll(String where) throws SQLException {
		List<Grade> grades = new ArrayList<>();
		String sql = String.format(Locale.ENGLISH,
				"SELECT * FROM `grades` %s", where
		);

		try (
				Connection connection = ConnectionCreator.get();
				Statement statement = connection.createStatement();
		) {
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Grade grade = new Grade(
						resultSet.getLong("ID"),
						resultSet.getString("grade"),
						resultSet.getLong("categories_ID")
				);
				grades.add(grade);
			}
		}
		return grades;
	}

	@Override
	public Grade read(long id) throws SQLException {
		String where = String.format(" WHERE `id`='%d' LIMIT 0,1", id);
		List<Grade> grades = getAll(where);
		if (grades.size() == 1)
			return grades.get(0);
		else
			return null;
	}

	@Override
	public List<Grade> getAll() throws SQLException {
		return getAll("");
	}
}
