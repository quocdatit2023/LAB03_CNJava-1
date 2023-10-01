package model;

import javax.persistence.*;

@Entity
public class Phone {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic
    @Column(name = "id", nullable = false, length = 255)
    private String id;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "price", nullable = false)
    private int price;
    @Basic
    @Column(name = "color", nullable = false, length = 255)
    private String color;
    @Basic
    @Column(name = "country", nullable = false, length = 255)
    private String country;
    @Basic
    @Column(name = "quantity", nullable = false)
    private int quantity;

    public Phone(String id, String name, int price, String color, String country, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.color = color;
        this.country = country;
        this.quantity = quantity;
    }

    public Phone() {

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", country='" + country + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
