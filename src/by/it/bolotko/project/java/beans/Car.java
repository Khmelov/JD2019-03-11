package by.it.bolotko.project.java.beans;

public class Car {

    private long id;
    private String car_type;
    private String fuel_type;
    private String mark;
    private String model;
    private String price;
    private String year_of_issue;
    private long users_id;

    public Car() {
    }

    public Car(long id, String car_type, String fuel_type, String mark, String model, String price, String year_of_issue, long users_id) {
        this.id = id;
        this.car_type = car_type;
        this.fuel_type = fuel_type;
        this.mark = mark;
        this.model = model;
        this.price = price;
        this.year_of_issue = year_of_issue;
        this.users_id = users_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCar_type() {
        return car_type;
    }

    public void setCar_type(String car_type) {
        this.car_type = car_type;
    }

    public String getFuel_type() {
        return fuel_type;
    }

    public void setFuel_type(String fuel_type) {
        this.fuel_type = fuel_type;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getYear_of_issue() {
        return year_of_issue;
    }

    public void setYear_of_issue(String year_of_issue) {
        this.year_of_issue = year_of_issue;
    }

    public long getUsers_id() {
        return users_id;
    }

    public void setUsers_id(long users_id) {
        this.users_id = users_id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", car_type='" + car_type + '\'' +
                ", fuel_type='" + fuel_type + '\'' +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", price='" + price + '\'' +
                ", year_of_issue='" + year_of_issue + '\'' +
                ", users_id=" + users_id +
                '}';
    }
}
