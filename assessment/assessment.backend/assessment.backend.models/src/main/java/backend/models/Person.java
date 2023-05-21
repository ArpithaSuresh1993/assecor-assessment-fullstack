package backend.models;

import java.util.Objects;

/**
 * Person class (Probably can be used later for DB connections)
 */
public class Person {

    private int id;
    private String name;
    private String lastname;
    private String zipcode;
    private String city;
    private Color color;

    public int getId() {
        return id;
    }

    public void setId(int aId) {
        id = aId;
    }

    public String getName() {
        return name;
    }

    public void setName(String aName) {
        name = aName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String aLastname) {
        lastname = aLastname;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String aZipcode) {
        zipcode = aZipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String aCity) {
        city = aCity;
    }

    public Color getColour() {
        return color;
    }

    public void setColour(Color aColor) {
        color = aColor;
    }

    @Override
    public boolean equals(Object aO) {
        if (this == aO) return true;
        if (!(aO instanceof Person)) return false;
        Person person = (Person) aO;
        return getId() == person.getId() && Objects.equals(getName(), person.getName()) && Objects.equals(getLastname(), person.getLastname()) && Objects.equals(getZipcode(), person.getZipcode()) && Objects.equals(getCity(), person.getCity()) && color == person.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getLastname(), getZipcode(), getCity(), getColour());
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", city='" + city + '\'' +
                ", color=" + color +
                '}';
    }
}
