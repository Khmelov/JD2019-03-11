package by.it.eslaikouskaya.project.java;

import by.it.eslaikouskaya.project.java.beans.Material;
import by.it.eslaikouskaya.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdIndex extends Cmd {
	@Override
	Cmd execute(HttpServletRequest req) throws Exception {
		Dao dao = Dao.getDao();
		List<Material> materials = dao.material.getAll();
		req.setAttribute("materials", materials);
		return null;
	}
}
