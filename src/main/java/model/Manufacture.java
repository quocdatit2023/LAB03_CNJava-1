package model;

//import jakarta.persistence.*;

import javax.persistence.*;

@Entity
public class Manufacture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private String id;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "location", nullable = false, length = 255)
    private String location;
    @Basic
    @Column(name = "employee", nullable = false)
    private int employee;

    public Manufacture(String id, String name, String location, Integer employee) {
        this.id = id;
        this.name = name;
        this.employee = employee;
        this.location = location;
    }

    public Manufacture() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Manufacture{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", employee=" + employee +
                '}';
    }
    private String country;

    // Constructor, getters, setters, and other methods

    public boolean isBasedInUS() {
        return "US".equalsIgnoreCase(country);
    }

}
