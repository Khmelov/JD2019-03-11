package by.it.eslaikouskaya.jd03_03;

import by.it.eslaikouskaya.jd03_03.beans.*;
import by.it.eslaikouskaya.jd03_03.dao.Dao;

import java.sql.SQLException;

public class Runner {
	public static void main(String[] args) throws SQLException {
		Dao dao = Dao.getDao();

		User user = new User(0, "Ivanov", "qwerty", "ivan@ya.ru", 2);
		dao.user.create(user);
		user = dao.user.read(user.getID());
		System.out.println(user);
		user.setLogin("LLLLLLLLLLLLLLLLLLLLL");
		dao.user.update(user);
		user = dao.user.read(user.getID());
		System.out.println(user);
		dao.user.delete(user);

		Role role = new Role(0, "Manager");
		dao.role.create(role);
		role = dao.role.read(role.getID());
		System.out.println(role);
		role.setRole("Менеджер среднего звена");
		dao.role.update(role);
		role = dao.role.read(role.getID());
		System.out.println(role);
		dao.role.delete(role);

		Material material = new Material(0, "Уголок", 15, 3);
		dao.material.create(material);
		material = dao.material.read(material.getID());
		System.out.println(material);
		material.setPrice(13);
		dao.material.update(material);
		material = dao.material.read(material.getID());
		System.out.println(material);
		dao.material.delete(material);

		Purchase purchase = new Purchase(0, 2, 5, 10);
		dao.purchase.create(purchase);
		purchase = dao.purchase.read(purchase.getID());
		System.out.println(purchase);
		purchase.setMaterials_ID(15);
		dao.purchase.update(purchase);
		purchase = dao.purchase.read(purchase.getID());
		System.out.println(purchase);
		dao.purchase.delete(purchase);

		Grade grade = new Grade(0, "Душ", 2);
		dao.grade.create(grade);
		grade = dao.grade.read(grade.getID());
		System.out.println(grade);
		grade.setCategories_ID(1);
		dao.grade.update(grade);
		grade = dao.grade.read(grade.getID());
		System.out.println(grade);
		dao.grade.delete(grade);

		Category category = new Category(0, "Полы");
		dao.category.create(category);
		category = dao.category.read(category.getID());
		System.out.println(category);
		category.setCategory("Стены");
		dao.category.update(category);
		category = dao.category.read(category.getID());
		System.out.println(category);
		dao.category.delete(category);
	}
}