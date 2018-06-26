package rafael.couto.testeapplication.model;

/**
 * Created by rafael.couto on 08/06/2018.
 */

public class User {
    private String name;
    private String surname;
    private int age;
    private String address;
    private boolean newsletter;
    private String gender;
    private String devices;
    private boolean married;

    public User(String name, String surname, int age, String address, boolean newsletter, String gender, String devices, boolean married) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
        this.newsletter = newsletter;
        this.gender = gender;
        this.devices = devices;
        this.married = married;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isNewsletter() {
        return newsletter;
    }

    public void setNewsletter(boolean newsletter) {
        this.newsletter = newsletter;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDevices() {
        return devices;
    }

    public void setDevices(String devices) {
        this.devices = devices;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", newsletter=" + newsletter +
                ", gender='" + gender + '\'' +
                ", devices=" + devices +
                ", married=" + married +
                '}';
    }
}
