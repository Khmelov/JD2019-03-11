package by.it.khlystunova.project.java.beans;

public class Firm {
    private long id;
    private String firm;

    public Firm() {
    }

    public Firm(long id, String firm) {
        this.id = id;
        this.firm = firm;
    }

    public long getId() {
        return id;
    }

    public String getFirm() {
        return firm;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    @Override
    public String toString() {
        return "Firm{" +
                "id=" + id +
                ", firm='" + firm + '\'' +
                '}';
    }
}
