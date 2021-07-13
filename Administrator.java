package Elements;

public class Administrator {
    private String ID;
    private String password;

    public Administrator(String ID, String password) {
        this.ID = ID;
        this.password = password;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "ID='" + ID + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
