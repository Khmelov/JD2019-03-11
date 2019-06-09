package by.it.bildziuh.jd03_03.beans;

public class Message {

    private long id;
    private String text;
    private long users_id;
    private long mods_id;

    public Message() {
    }

    public Message(long id, long users_id, String text, long mods_id) {
        this.id = id;
        this.users_id = users_id;
        this.text = text;
        this.mods_id = mods_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getUsers_id() {
        return users_id;
    }

    public void setUsers_id(long users_id) {
        this.users_id = users_id;
    }

    public long getMods_id() {
        return mods_id;
    }

    public void setMods_id(long mods_id) {
        this.mods_id = mods_id;
    }



    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", users_id=" + users_id +
                ", mods_id=" + mods_id +
                '}';
    }

}
