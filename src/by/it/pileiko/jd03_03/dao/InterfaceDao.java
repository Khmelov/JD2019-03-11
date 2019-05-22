package by.it.pileiko.jd03_03.dao;

import java.sql.SQLException;
import  java.util.List;

public interface InterfaceDao <TYPE> {

    boolean create (TYPE bean) throws SQLException;
    boolean update (TYPE bean) throws SQLException;
    boolean delete (TYPE bean) throws SQLException;



}
