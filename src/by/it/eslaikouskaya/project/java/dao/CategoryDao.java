package by.it.eslaikouskaya.project.java.dao;

import by.it.eslaikouskaya.project.java.beans.Category;
import by.it.eslaikouskaya.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CategoryDao extends AbstractDao<Category> {
	@Override
	public boolean create(Category category) throws SQLException {
		String sql = String.format(Locale.ENGLISH,
				"INSERT INTO " +
						"`categories`(`category`) " +
						"VALUES ('%s')",
				category.getCategory()
		);
		long id = executeCreate(sql);
		if (id > 0)
			category.setID(id);
		return id > 0;
	}

	@Override
	public boolean update(Category category) throws SQLException {
		String sql = String.format(Locale.ENGLISH,
				"UPDATE `categories` " +
						"SET `category`='%s' WHERE `id`=%d",
				category.getCategory(), category.getID()
		);
		return executeUpdate(sql);
	}

	@Override
	public boolean delete(Category category) throws SQLException {
		String sql = String.format(Locale.ENGLISH, "DELETE FROM `categories` WHERE `id`=%d", category.getID());
		return executeUpdate(sql);
	}

	@Override
	public List<Category> getAll(String where) throws SQLException {
		List<Category> categories = new ArrayList<>();
		String sql = String.format(Locale.ENGLISH,
				"SELECT * FROM `categories` %s", where
		);

		try (
				Connection connection = ConnectionCreator.get();
				Statement statement = connection.createStatement();
		) {
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Category category = new Category(
						resultSet.getLong("ID"),
						resultSet.getString("category")
				);
				categories.add(category);
			}
		}
		return categories;
	}

	@Override
	public Category read(long id) throws SQLException {
		String where = String.format(" WHERE `id`='%d' LIMIT 0,1", id);
		List<Category> roles = getAll(where);
		if (roles.size() == 1)
			return roles.get(0);
		else
			return null;
	}

	@Override
	public List<Category> getAll() throws SQLException {
		return getAll("");
	}


}