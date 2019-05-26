package by.it.narushevich.project.java;

import by.it.narushevich.project.java.beans.Material;
import by.it.narushevich.project.java.beans.Teatag;
import by.it.narushevich.project.java.beans.Trademark;
import by.it.narushevich.project.java.beans.User;
import by.it.narushevich.project.java.dao.Dao;
import by.it.narushevich.project.java.util.FormHelper;
import by.it.narushevich.project.java.util.Patterns;
import by.it.narushevich.project.java.util.Validator;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.List;

public class CmdCreateTag extends Cmd {
    @Override
    Cmd execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getDao();
        long trademark_id;
        long material_id = 0;
        long user_id = 0;

        if (FormHelper.isPost(req)) {
            Teatag teatag = new Teatag();
            List<Trademark> trademarks = dao.trademark.getAll(
                    "WHERE trademark='" + req.getParameter("Trademark list") + "'");
            Iterator<Trademark> it = trademarks.iterator();
            if (it.hasNext()) {
                trademark_id = it.next().getId();
            } else {
                Trademark trademark = new Trademark(0,
                        Validator.getString(req, "Trademark", Patterns.TRADEMARK));
                dao.trademark.create(trademark);
                trademark_id = trademark.getId();
            }
            teatag.setTrademark_id(trademark_id);

            List<Material> materials = dao.material.getAll(
                    "WHERE material='" + req.getParameter("Material") + "'");
            Iterator<Material> it2 = materials.iterator();
            if (it2.hasNext()) {
                material_id = it2.next().getId();
            }

            teatag.setMaterial_id(material_id);
            teatag.setSubtitle(
                    Validator.getString(req, "Subtitle", Patterns.SUBTITLE));
            teatag.setWidth(
                    Validator.getInt(req, "Width, mm"));
            teatag.setHeight(
                    Validator.getInt(req, "Height, mm"));
            teatag.setIn_collection_since(
                    Validator.getString(req, "In collection since", Patterns.DATE));
            teatag.setNum_in_catalog(
                    Validator.getString(req, "Number in catalog", Patterns.NUMBER_IN_CATALOG));

            String userName = req.getRemoteUser();
            String where = String.format("WHERE login='%s'", userName);
            List<User> users = dao.user.getAll(where);
            Iterator<User> it3 = users.iterator();
            if (it3.hasNext()) {
                user_id = it3.next().getId();
            }
            teatag.setUser_id(user_id);

            if (dao.teatag.create(teatag)) {
                return Actions.USERCOLLECTION.command;
            }
        }
        return null;
    }
}
