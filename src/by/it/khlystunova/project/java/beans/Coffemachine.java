package by.it.khlystunova.project.java.beans;

public class Coffemachine {

    private long id;
    private String name;
    private String firm;
    private String power;
    private String size;
    private double weight;
    private String waterContainer;
    private String beansContainer;
    private String color;
    private double price;

    public Coffemachine() {
    }

    public Coffemachine(long id, String name, String firm, String power, String size, double weight, String waterContainer, String beansContainer, String color, double price) {
        this.id = id;
        this.name = name;
        this.firm = firm;
        this.power = power;
        this.size = size;
        this.weight = weight;
        this.waterContainer = waterContainer;
        this.beansContainer = beansContainer;
        this.color = color;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFirm() {
        return firm;
    }

    public String getPower() {
        return power;
    }

    public String getSize() {
        return size;
    }

    public double getWeight() {
        return weight;
    }

    public String getWaterContainer() {
        return waterContainer;
    }

    public String getBeansContainer() {
        return beansContainer;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


    public void setWaterContainer(String waterContainer) {
        this.waterContainer = waterContainer;
    }

    public void setBeansContainer(String beansContainer) {
        this.beansContainer = beansContainer;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Coffemachine{" +
                "id=" + id +"\n"+
                ", name='" + name + '\'' +"\n"+
                ", firm='" + firm + '\'' +"\n"+
                ", power='" + power + '\'' +"\n"+
                ", size='" + size + '\'' +"\n"+
                ", weight=" + weight +"\n"+
                ", waterContainer='" + waterContainer + '\'' +"\n"+
                ", beansContainer='" + beansContainer + '\'' +"\n"+
                ", color='" + color + '\'' +"\n"+
                ", price=" + price +"\n"+
                '}';
    }
}
