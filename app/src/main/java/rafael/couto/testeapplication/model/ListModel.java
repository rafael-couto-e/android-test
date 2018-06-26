package rafael.couto.testeapplication.model;

/**
 * Created by rafael.couto on 26/06/2018.
 */

public class ListModel {
    private String name;
    private String age;

    public ListModel() {
    }

    public ListModel(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListModel listModel = (ListModel) o;

        return (name != null ? name.equals(listModel.name) : listModel.name == null) && (age != null ? age.equals(listModel.age) : listModel.age == null);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ListModel{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
