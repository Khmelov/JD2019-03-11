package by.it.eslaikouskaya.project.java.dao;

import by.it.eslaikouskaya.project.java.beans.Purchase;
import by.it.eslaikouskaya.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PurchaseDao extends AbstractDao<Purchase> {
	@Override
	public boolean create(Purchase purchase) throws SQLException {
		String sql = String.format(Locale.ENGLISH,
				"INSERT INTO " +
						"`purchases`(`users_ID`, `materials_ID`, `number`) " +
						"VALUES ('%d','%d',%d)",
				purchase.getUsers_ID(), purchase.getMaterials_ID(), purchase.getNumber()
		);
		long id = executeCreate(sql);
		if (id > 0)
			purchase.setID(id);
		return id > 0;
	}

	@Override
	public boolean update(Purchase purchase) throws SQLException {
		String sql = String.format(Locale.ENGLISH,
				"UPDATE `purchases` " +
						"SET `users_ID`='%d',`materials_ID`='%d'," +
						"`number`=%d WHERE `id`=%d",
				purchase.getUsers_ID(), purchase.getMaterials_ID(), purchase.getNumber(), purchase.getID());
		return executeUpdate(sql);
	}

	@Override
	public boolean delete(Purchase purchase) throws SQLException {
		String sql = String.format(Locale.ENGLISH, "DELETE FROM `purchases` WHERE `id`=%d", purchase.getID());
		return executeUpdate(sql);
	}

	@Override
	public List<Purchase> getAll(String where) throws SQLException {
		List<Purchase> purchases = new ArrayList<>();
		String sql = String.format(Locale.ENGLISH,
				"SELECT * FROM `purchases` %s", where
		);

		try (
				Connection connection = ConnectionCreator.get();
				Statement statement = connection.createStatement();
		) {
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Purchase purchase = new Purchase(
						resultSet.getLong("ID"),
						resultSet.getLong("users_ID"),
						resultSet.getInt("materials_ID"),
						resultSet.getInt("number")
				);

				purchases.add(purchase);
			}
		}
		return purchases;
	}

	@Override
	public Purchase read(long id) throws SQLException {
		String where = String.format(" WHERE `id`='%d' LIMIT 0,1", id);
		List<Purchase> purchases = getAll(where);
		if (purchases.size() == 1)
			return purchases.get(0);
		else
			return null;
	}

	@Override
	public List<Purchase> getAll() throws SQLException {
		return getAll("");
	}
}