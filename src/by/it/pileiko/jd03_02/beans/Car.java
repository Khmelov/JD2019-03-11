package by.it.pileiko.jd03_02.beans;

public class Car {

    private long id;
    private String brand;
    private String model;
    private int engine;
    private double price;
    private int year;
    private String description;
    private long usersID;

    public Car() {
    }

    public Car(long id, String brand, String model, int engine, double price, int year, String description, long usersID)
       {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.engine = engine;
        this.price = price;
        this.year = year;
        this.description = description;
        this.usersID = usersID;
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
    public long getUsersId() {return usersID; }
    public void setUsersId(long usersID) { this.usersID = usersID; }

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
                ", usersID=" + usersID +
                '}';
    }
}




