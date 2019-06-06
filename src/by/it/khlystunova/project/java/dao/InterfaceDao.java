package by.it.khlystunova.project.java.dao;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDao<TYPE> {

    boolean create(TYPE bean) throws SQLException;
    boolean update(TYPE bean) throws SQLException;
    boolean delete(TYPE bean) throws SQLException;
    List<TYPE> getAll(String where) throws SQLException;
    List<TYPE> getAll() throws SQLException;
    TYPE read(long id) throws SQLException;


}
