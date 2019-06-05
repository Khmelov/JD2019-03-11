package by.it.akhmelev.project08.java.dao;


import by.it.akhmelev.project08.java.beans.Ad;

/**
 * instance in singleton
 */
@SuppressWarnings("all")
public class AdDao extends UniversalDAO<Ad> {
    public AdDao() {
        super(new Ad(), "ads");
    }
}
