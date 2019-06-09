package by.it.narushevich.project.java.commands;

import by.it.narushevich.project.java.beans.Material;
import by.it.narushevich.project.java.beans.Teatag;
import by.it.narushevich.project.java.beans.Trademark;
import by.it.narushevich.project.java.beans.User;
import by.it.narushevich.project.java.dao.Dao;
import by.it.narushevich.project.java.util.FormHelper;
import by.it.narushevich.project.java.util.Tools;
import by.it.narushevich.project.java.util.Patterns;
import by.it.narushevich.project.java.util.Validator;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class CmdCreateTag extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws SQLException {

        User user = Tools.isUserInSession(req);
        if (user == null)
            return Actions.LOGIN.command;

        Dao dao = Dao.getDao();

        if (FormHelper.isPost(req)) {
            Teatag teatag = new Teatag();

            teatag.setId(0);
            String trademarkName = req.getParameter("trademark list");

            if (!trademarkName.equals("")){
                String whereTrademark = String.format("WHERE trademark='%s'", trademarkName);
                Trademark trademark = dao.trademark.getAll(whereTrademark).get(0);
                teatag.setTrademark_id(trademark.getId());
            }
            else{
                String yourTrademark = Validator.getString(
                        req, "trademark", Patterns.TRADEMARK).toUpperCase();

                String whereTrademark = String.format("WHERE trademark='%s'", yourTrademark);
                if (!dao.trademark.getAll(whereTrademark).isEmpty()) {
                    teatag.setTrademark_id(dao.trademark.getAll(whereTrademark).get(0).getId());
                } else {
                    Trademark trademark = new Trademark(0, yourTrademark);
                    dao.trademark.create(trademark);
                    teatag.setTrademark_id(trademark.getId());
                }
            }

            teatag.setSubtitle(
                    Validator.getString(req, "subtitle", Patterns.SUBTITLE));

            String whereMaterial = String.format("WHERE material='%s'", req.getParameter("material"));
            Material material = dao.material.getAll(whereMaterial).get(0);
            teatag.setMaterial_id(material.getId());

            teatag.setWidth(
                    Validator.getDouble(req, "width"));
            teatag.setHeight(
                    Validator.getDouble(req, "height"));
            teatag.setIn_collection_since(
                    Validator.getDate(req, "in collection"));
            teatag.setNum_in_catalog(
                    Validator.getString(req, "number in catalog", Patterns.NUMBER_IN_CATALOG));

            teatag.setUser_id(user.getId());

            Tools.uploadImage(req, teatag);

            if (dao.teatag.create(teatag)) {
                return Actions.PROFILE.command;
            }
        }
        return null;
    }


}
