package by.it.pileiko.jd03_03.beans;

public class Car {

    private long id;
    private String brand;
    private String model;
    private int engine;
    private double price;
    private int year;
    private String description;
    private long users_ID;

    public Car() {
    }

    public Car(long id, String brand, String model, int engine, double price, int year, String description, long users_ID)
       {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.engine = engine;
        this.price = price;
        this.year = year;
        this.description = description;
        this.users_ID = users_ID;
    }
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public int getEngine() { return engine; }
    public void setEngine(int engine) { this.engine = engine; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public long getUsersId() {return users_ID; }
    public void setUsersId(long users_ID) { this.users_ID = users_ID; }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", engine=" + engine +
                ", price=" + price +
                ", year=" + year +
                ", description='" + description + '\'' +
                ", users_ID=" + users_ID +
                '}';
    }
}




