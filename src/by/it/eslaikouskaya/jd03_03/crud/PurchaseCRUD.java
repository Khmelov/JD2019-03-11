package by.it.eslaikouskaya.jd03_03.crud;

import by.it.eslaikouskaya.jd03_03.beans.Purchase;
import by.it.eslaikouskaya.jd03_03.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class PurchaseCRUD {

	public boolean create(Purchase purchase) throws SQLException {
		String sql = String.format(Locale.ENGLISH,
				"INSERT INTO " +
						"`purchases`(`users_ID`, `materials_ID`, `Number`) " +
						"VALUES ('%d','%d','%d')",
				purchase.getUsers_ID(), purchase.getMaterials_ID(), purchase.getNumber());

		try (
				Connection connection = ConnectionCreator.get();
				Statement statement = connection.createStatement()
		) {
			int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			if (count == 1) {
				ResultSet generatedKeys = statement.getGeneratedKeys();
				if (generatedKeys.next()) {
					purchase.setID(generatedKeys.getLong(1));
					return true;
				}
			}
		}
		return false;
	}

	public Purchase read(long id) throws SQLException {
		String sql = String.format(Locale.ENGLISH,
				"SELECT * FROM `purchases` WHERE `id`=%d", id
		);

		try (
				Connection connection = ConnectionCreator.get();
				Statement statement = connection.createStatement()
		) {
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {

				return new Purchase(
						resultSet.getLong("ID"),
						resultSet.getLong("users_ID"),
						resultSet.getLong("materials_ID"),
						resultSet.getInt("Number")
				);
			}
		}
		return null;
	}


	public boolean update(Purchase purchase) throws SQLException {
		String sql = String.format(Locale.ENGLISH,
				"UPDATE `purchases` " +
						"SET `users_ID`='%d',`materials_ID`='%d'," +
						"`Number`='%d' WHERE `id`=%d",
				purchase.getUsers_ID(), purchase.getMaterials_ID(), purchase.getNumber(), purchase.getID()
		);

		try (
				Connection connection = ConnectionCreator.get();
				Statement statement = connection.createStatement()
		) {
			return (1 == statement.executeUpdate(sql));
		}
	}

	public boolean delete(Purchase purchase) throws SQLException {
		String sql = String.format(Locale.ENGLISH, "DELETE FROM `purchases` WHERE `id`=%d", purchase.getID());
		try (
				Connection connection = ConnectionCreator.get();
				Statement statement = connection.createStatement()
		) {
			return (1 == statement.executeUpdate(sql));
		}
	}

}