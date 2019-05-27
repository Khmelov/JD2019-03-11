package by.it.narushevich.project.java.dao;

import by.it.narushevich.project.java.beans.Teatag;

public class TeatagDaoUniversal extends UniversalDao<Teatag> {
    public TeatagDaoUniversal() {
        super(new Teatag(), "teatags");
    }
}
