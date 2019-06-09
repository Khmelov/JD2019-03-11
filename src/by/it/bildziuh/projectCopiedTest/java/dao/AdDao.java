package by.it.bildziuh.projectCopiedTest.java.dao;


import by.it.bildziuh.projectCopiedTest.java.beans.Ad;

/**
 * instance in singleton
 */
@SuppressWarnings("all")
public class AdDao extends UniversalDAO<Ad> {
    public AdDao() {
        super(new Ad(), "ads");
    }
}
