package by.it.vasiliuk.project.java.beans;

public class Task {

    private long id;
    private String task_type;
    private String stask_type;
    private String tag;
    private String grp_project;
    private String sallary;
    private String date_year;
    private long users_id;

    public Task() {
    }

    public Task(long id, String task_type, String stask_type, String tag, String grp_project, String sallary, String date_year, long users_id) {
        this.id = id;
        this.task_type = task_type;
        this.stask_type = stask_type;
        this.tag = tag;
        this.grp_project = grp_project;
        this.sallary = sallary;
        this.date_year = date_year;
        this.users_id = users_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String gettask_type() {
        return task_type;
    }

    public void settask_type(String task_type) {
        this.task_type = task_type;
    }

    public String getstask_type() {
        return stask_type;
    }

    public void setstask_type(String stask_type) {
        this.stask_type = stask_type;
    }

    public String gettag() {
        return tag;
    }

    public void settag(String tag) {
        this.tag = tag;
    }

    public String getgrp_project() {
        return grp_project;
    }

    public void setgrp_project(String grp_project) {
        this.grp_project = grp_project;
    }

    public String getsallary() {
        return sallary;
    }

    public void setsallary(String sallary) {
        this.sallary = sallary;
    }

    public String getdate_year() {
        return date_year;
    }

    public void setdate_year(String date_year) {
        this.date_year = date_year;
    }

    public long getUsers_id() {
        return users_id;
    }

    public void setUsers_id(long users_id) {
        this.users_id = users_id;
    }

    @Override
    public String toString() {
        return "Task(" +
                "id=" + id +
                ", task_type=" + task_type +
                ", stask_type=" + stask_type +
                ", tag=" + tag +
                ", grp_project=" + grp_project +
                ", sallary=" + sallary +
                ", date_year=" + date_year +
                ", users_id=" + users_id +
                ')';
    }
}
