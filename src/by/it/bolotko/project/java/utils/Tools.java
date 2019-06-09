package by.it.bolotko.project.java.utils;

import by.it.bolotko.project.java.beans.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Tools {
    public static User findUserInSession(HttpServletRequest req) {
        Object oUser = req.getSession().getAttribute("user");
        if (oUser == null)
            return null;
        return (User) oUser;
    }

    public static void CreateImage(HttpServletRequest req, String filename) {
        try {
            Part photo = req.getPart("photo");
            String path = req.getServletContext().getRealPath("/images") + "/" + filename;
            try (
                    InputStream inputStream = photo.getInputStream();
                    OutputStream outputStream = new FileOutputStream(path)
            ) {
                byte[] buffer = new byte[100000];
                while (inputStream.available() > 0) {
                    int size = inputStream.read(buffer);
                    outputStream.write(buffer, 0, size);
                }
            }

        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

}
