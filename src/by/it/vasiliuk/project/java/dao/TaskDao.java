package by.it.vasiliuk.project.java.dao;


import by.it.vasiliuk.project.java.beans.Task;
import by.it.vasiliuk.project.java.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TaskDao extends AbstractDao<Task>{
    @Override
    public boolean create(Task task) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO " +
                        "`tasks`(`task_type`, `stask_type`, `tag`, `grp_project`, `sallary`, `date_year`, `users_id`) " +
                        "VALUES ('%s','%s','%s','%s','%s','%s',%d)",
                task.gettask_type(), task.getstask_type(), task.gettag(), task.getgrp_project(), task.getsallary(), task.getdate_year(), task.getUsers_id()
        );
        long id = executeCreate(sql);
        if (id > 0)
            task.setId(id);
        return id > 0;
    }

    @Override
    public boolean update(Task task) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `tasks` " +
                        "SET `task_type`='%s',`stask_type`='%s'," +
                        "`tag`='%s',`grp_project`='%s',`sallary`='%s',`date_year`='%s',`users_id`=%d WHERE `id`=%d",
                task.gettask_type(), task.getstask_type(),
                task.gettag(), task.getgrp_project(),
                task.getsallary(), task.getdate_year(),
                task.getUsers_id(), task.getId()
        );
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(Task task) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "DELETE FROM `tasks` WHERE `id`=%d", task.getId());
        return executeUpdate(sql);
    }

    @Override
    public List<Task> getAll(String where) throws SQLException {
        List<Task> tasks = new ArrayList<>();
        String sql = String.format(Locale.ENGLISH,
                "SELECT * FROM `tasks` %s", where
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Task task = new Task(
                        resultSet.getLong("id"),
                        resultSet.getString("task_type"),
                        resultSet.getString("stask_type"),
                        resultSet.getString("tag"),
                        resultSet.getString("grp_project"),
                        resultSet.getString("sallary"),
                        resultSet.getString("date_year"),
                        resultSet.getLong("users_id")
                );
                tasks.add(task);
            }
        }
        return tasks;
    }

    @Override
    public Task read(long id) throws SQLException {
        String where = String.format(" WHERE `id`=%d LIMIT 0,1", id);
        List<Task> tasks = getAll(where);
        if (tasks.size() == 1)
            return tasks.get(0);
        else
            return null;
    }

    @Override
    public List<Task> getAll() throws SQLException {
        return getAll("");
    }
}

