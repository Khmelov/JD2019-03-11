package by.it.narushevich.jd03_03.dao;

import by.it.narushevich.jd03_03.connect.ConnectionCreator;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UniversalDao<TYPE> implements InterfaceDao<TYPE> {

    private TYPE bean;
    private String table;
    private Field[] fields;

    public UniversalDao(TYPE bean, String sqlTableName) {
        this.bean = bean;
        this.table = sqlTableName;
        this.fields = bean.getClass().getDeclaredFields();
    }

    public List<TYPE> getAll(String condition) throws SQLException {
        List<TYPE> beans = new ArrayList<>();
        String sql = String.format("SELECT * FROM %s %s ;",table,condition);
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                TYPE newBean = newBean();
                for (int i = 1; i < fields.length + 1; i++) {
                    Field field = fields[i - 1];
                    field.setAccessible(true);
                    try {
                        if (field.getType().equals(Boolean.class)|| field.getType().equals(boolean.class))
                            field.set(newBean, resultSet.getBoolean(field.getName()));
                        if (field.getType().equals(Byte.class)|| field.getType().equals(byte.class))
                            field.set(newBean, resultSet.getByte(field.getName()));
                        if (field.getType().equals(Short.class)|| field.getType().equals(short.class))
                            field.set(newBean, resultSet.getShort(field.getName()));
                        if (field.getType().equals(Integer.class)|| field.getType().equals(int.class))
                            field.set(newBean, resultSet.getInt(field.getName()));
                        if (field.getType().equals(Long.class) || field.getType().equals(long.class))
                            field.set(newBean, resultSet.getLong(field.getName()));
                        if (field.getType().equals(Float.class)|| field.getType().equals(float.class))
                            field.set(newBean, resultSet.getFloat(field.getName()));
                        if (field.getType().equals(Double.class)|| field.getType().equals(double.class))
                            field.set(newBean, resultSet.getDouble(field.getName()));
                        if (field.getType().equals(String.class))
                            field.set(newBean, resultSet.getString(field.getName()));
                        if (field.getType().equals(Date.class))
                            field.set(newBean, resultSet.getDate(field.getName()));
                    } catch (IllegalArgumentException | IllegalAccessException | SQLException e) {
                        e.printStackTrace();
                    }
                }
                beans.add(newBean);
            }
        }
        return beans;
    }

    public TYPE read(long id) throws SQLException {
        String sql = String.format("WHERE id=%d LIMIT 0,1",id);
        List<TYPE> beans = getAll(sql);
        if (beans.size() > 0) {
            return beans.get(0);
        } else
            return null;
    }

    @Override
    public List<TYPE> getAll() throws SQLException {
        return getAll("");
    }

    public boolean update(TYPE bean) throws SQLException {
        StringBuilder sql = new StringBuilder("UPDATE ").append(table).append(" SET ");
        try {
            for (int i = 1; i < fields.length; i++) {
                Field field = fields[i];
                field.setAccessible(true);
                sql.append(field.getName()).append('=').
                        append('\'').append(field.get(bean)).append('\'');
                if (i!=fields.length-1) sql.append(',');
            }
            sql.append(" WHERE ").append(fields[0].getName()).append('=').
                    append('\'').append(fields[0].get(bean)).append('\'');
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return (0 < executeUpdate(sql.toString()));
    }

    public boolean create(TYPE bean) throws SQLException {
        StringBuilder sql = new StringBuilder("INSERT INTO ").append(table);
        StringBuilder columns = new StringBuilder();
        StringBuilder values = new StringBuilder();
        try {
            for (int i = 1; i < fields.length; i++) {
                Field field = fields[i];
                field.setAccessible(true);
                columns.append(field.getName());
                if (i!=fields.length-1) columns.append(',');

                values.append('\'').append(field.get(bean)).append('\'');
                if (i!=fields.length-1) values.append(',');
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        sql.append(" (").append(columns).append(") VALUES (").append(values).append(')');
        int id = executeUpdate(sql.toString());
        if (id > 0) try {
            fields[0].setAccessible(true);
            fields[0].set(bean, id);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return (id > 0);
    }

    public boolean delete(TYPE bean) throws SQLException {
        StringBuilder sql = new StringBuilder("DELETE FROM ");
        try {
            sql.append(table).append(" WHERE ").append(table).append(".id=").
                    append('\'').append(fields[0].get(bean)).append('\'');
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return (0 < executeUpdate(sql.toString()));
    }

    @SuppressWarnings("unchecked") //class with generic type haven't got constructor, it can't be created by new
    private TYPE newBean() {
        try {
            return (TYPE) bean.getClass().getConstructor().newInstance();
        } catch (InstantiationException | InvocationTargetException |
                NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static int executeUpdate(String sql) throws SQLException {
        int result;
        try (Connection connection = ConnectionCreator.get();
             Statement statement = connection.createStatement()) {
            result = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (result > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next())
                    return generatedKeys.getInt(1);
            }
        }
        return result;
    }
}