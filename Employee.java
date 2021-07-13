package Elements;

import java.sql.Date;

public class Employee {
    private String ID;
    private String password;
    public String name;
    public String sex;
    public int age;
    public Date entry_date;

    public Employee() {
    }

    public Employee(String ID, String password, String name, String sex, int age, Date entry_date) {
        this.ID = ID;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.entry_date = entry_date;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(Date entry_date) {
        this.entry_date = entry_date;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID='" + ID + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", entry_date=" + entry_date +
                '}';
    }
}
