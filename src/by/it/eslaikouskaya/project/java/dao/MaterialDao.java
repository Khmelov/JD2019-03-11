package by.it.eslaikouskaya.project.java.dao;

import by.it.eslaikouskaya.project.java.beans.Material;
import by.it.eslaikouskaya.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MaterialDao extends AbstractDao<Material> {
	@Override
	public boolean create(Material material) throws SQLException {
		String sql = String.format(Locale.ENGLISH,
				"INSERT INTO " +
						"`materials`(`name`, `price`, `grades_ID`) " +
						"VALUES ('%s','%d','%d')",
				material.getName(), material.getPrice(), material.getGrades_ID()
		);
		long id = executeCreate(sql);
		if (id > 0)
			material.setID(id);
		return id > 0;
	}

	@Override
	public boolean update(Material material) throws SQLException {
		String sql = String.format(Locale.ENGLISH,
				"UPDATE `materials` " +
						"SET `name`='%s',`price`='%s'," +
						"`grades_ID`=%d WHERE `id`=%d",
				material.getName(), material.getPrice(), material.getGrades_ID(), material.getID()
		);
		return executeUpdate(sql);
	}

	@Override
	public boolean delete(Material material) throws SQLException {
		String sql = String.format(Locale.ENGLISH, "DELETE FROM `materials` WHERE `id`=%d", material.getID());
		return executeUpdate(sql);
	}

	@Override
	public List<Material> getAll(String where) throws SQLException {
		List<Material> materials = new ArrayList<>();
		String sql = String.format(Locale.ENGLISH,
				"SELECT * FROM `materials` %s", where
		);

		try (
				Connection connection = ConnectionCreator.get();
				Statement statement = connection.createStatement();
		) {
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Material material = new Material(
						resultSet.getLong("ID"),
						resultSet.getString("name"),
						resultSet.getInt("price"),
						resultSet.getLong("grades_ID")
				);

				materials.add(material);
			}
		}
		return materials;
	}

	@Override
	public Material read(long id) throws SQLException {
		String where = String.format(" WHERE `id`='%d' LIMIT 0,1", id);
		List<Material> materials = getAll(where);
		if (materials.size() == 1)
			return materials.get(0);
		else
			return null;
	}

	@Override
	public List<Material> getAll() throws SQLException {
		return getAll("");
	}
}