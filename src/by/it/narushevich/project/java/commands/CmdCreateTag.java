package by.it.narushevich.project.java.commands;

import by.it.narushevich.project.java.beans.Material;
import by.it.narushevich.project.java.beans.Teatag;
import by.it.narushevich.project.java.beans.Trademark;
import by.it.narushevich.project.java.beans.User;
import by.it.narushevich.project.java.dao.Dao;
import by.it.narushevich.project.java.util.FormHelper;
import by.it.narushevich.project.java.util.Patterns;
import by.it.narushevich.project.java.util.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.List;

public class CmdCreateTag extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getDao();
        long trademark_id;
        long material_id = 0;

        if (FormHelper.isPost(req)) {
            Teatag teatag = new Teatag();

            teatag.setId(0);
            List<Trademark> trademarks = dao.trademark.getAll(
                    "WHERE trademark='" + req.getParameter("Trademark") + "'");
            Iterator<Trademark> it = trademarks.iterator();
            if (it.hasNext()) {
                trademark_id = it.next().getId();
            } else {
                Trademark trademark = new Trademark(0,
                        Validator.getString(req, "trademark", Patterns.TRADEMARK));
                dao.trademark.create(trademark);
                trademark_id = trademark.getId();
            }
            teatag.setTrademark_id(trademark_id);

            List<Material> materials = dao.material.getAll(
                    "WHERE material='" + req.getParameter("material") + "'");
            Iterator<Material> it2 = materials.iterator();
            if (it2.hasNext()) {
                material_id = it2.next().getId();
            }

            teatag.setMaterial_id(material_id);
            teatag.setSubtitle(
                    Validator.getString(req, "subtitle", Patterns.SUBTITLE));
            teatag.setWidth(
                    Validator.getDouble(req, "width"));
            teatag.setHeight(
                    Validator.getDouble(req, "height"));
            teatag.setIn_collection_since(
                    Validator.getDate(req, "in collection"));
            teatag.setNum_in_catalog(
                    Validator.getString(req, "number in catalog", Patterns.NUMBER_IN_CATALOG));

            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("user");
            teatag.setUser_id(user.getId());

            if (dao.teatag.create(teatag)) {
                return Actions.USERCOLLECTION.command;
            }
        }
        return null;
    }
}
