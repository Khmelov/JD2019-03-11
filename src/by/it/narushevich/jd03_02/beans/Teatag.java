package by.it.narushevich.jd03_02.beans;

import java.util.Date;

public class Teatag {

    private long id;
    private long trademark_id;
    private String subtitle;
    private long material_id;
    private double width;
    private double height;
    private Date in_collection_since;
    private String num_in_catalog;
    private long users_id;

    public Teatag() {
    }

    public Teatag(long id, long trademark_id, String subtitle,
                  long material_id, double width, double height,
                  Date in_collection_since, String num_in_catalog, long users_id) {
        this.id = id;
        this.trademark_id = trademark_id;
        this.subtitle = subtitle;
        this.material_id = material_id;
        this.width = width;
        this.height = height;
        this.in_collection_since = in_collection_since;
        this.num_in_catalog = num_in_catalog;
        this.users_id = users_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTrademark_id() {
        return trademark_id;
    }

    public void setTrademark_id(long trademark_id) {
        this.trademark_id = trademark_id;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public long getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(long material_id) {
        this.material_id = material_id;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Date getIn_collection_since() {
        return in_collection_since;
    }

    public void setIn_collection_since(Date in_collection_since) {
        this.in_collection_since = in_collection_since;
    }

    public String getNum_in_catalog() {
        return num_in_catalog;
    }

    public void setNum_in_catalog(String num_in_catalog) {
        this.num_in_catalog = num_in_catalog;
    }

    public long getUsers_id() {
        return users_id;
    }

    public void setUsers_id(long users_id) {
        this.users_id = users_id;
    }

    @Override
    public String toString() {
        return "Teatag{" +
                "id = " + id +
                ", trademark id = " + trademark_id +
                ", subtitle ='" + subtitle + '\'' +
                ", material_id = " + material_id +
                ", width x height = " + width + " x "+ height +
                ", in collection since = " + in_collection_since +
                ", num in catalog = '" + num_in_catalog + '\'' +
                ", users id = " + users_id +
                '}';
    }
}
