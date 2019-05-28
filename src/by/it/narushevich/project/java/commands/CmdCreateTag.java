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

public class CmdCreateTag extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getDao();

        if (FormHelper.isPost(req)) {
            Teatag teatag = new Teatag();

            teatag.setId(0);
            String trademarkName = req.getParameter("trademark list");
            System.out.println(trademarkName);

            if (!trademarkName.equals("")){
                String whereTrademark = String.format("WHERE trademark='%s'", trademarkName);
                Trademark trademark = dao.trademark.getAll(whereTrademark).get(0);
                teatag.setTrademark_id(trademark.getId());
            }
            else{
                String yourTrademark = Validator.getString(
                        req, "trademark", Patterns.TRADEMARK).toUpperCase();

                String whereTrademark = String.format("WHERE trademark='%s'", yourTrademark);
                Trademark trademark = dao.trademark.getAll(whereTrademark).get(0);
                if (trademark != null) {
                    teatag.setTrademark_id(trademark.getId());
                } else {
                    trademark = new Trademark(0, yourTrademark);
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

            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("user");
            teatag.setUser_id(user.getId());

            if (dao.teatag.create(teatag)) {
                return Actions.PROFILE.command;
            }
        }
        return null;
    }
}
