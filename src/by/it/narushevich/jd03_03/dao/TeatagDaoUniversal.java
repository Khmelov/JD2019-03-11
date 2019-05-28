package by.it.narushevich.jd03_03.dao;

import by.it.narushevich.jd03_03.beans.Teatag;

public class TeatagDaoUniversal extends UniversalDao<Teatag> {
    public TeatagDaoUniversal() {
        super(new Teatag(), "teatags");
    }
}
