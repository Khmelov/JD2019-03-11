package by.it.pileiko.jd03_02.beans;

public class User {

    private long id;
    private String lodin;
    private String password;
    private String email;
    private long rolesId;  //  нарушен код ковекшин

    public User(long id, String lodin, String password, String email, long rolesId) {
        this.id = id;
        this.lodin = lodin;
        this.password = password;
        this.email = email;
        this.rolesId = rolesId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLodin() {
        return lodin;
    }

    public void setLodin(String lodin) {
        this.lodin = lodin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getRolesId() {
        return rolesId;
    }

    public void setRolesId(long rolesId) {
        this.rolesId = rolesId;
    }

    public User() {


    }
}
