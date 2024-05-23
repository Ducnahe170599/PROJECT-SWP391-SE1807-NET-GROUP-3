package model;

import java.math.BigDecimal;

/**
 *
 * @author Admin
 */
public class Packages {

    /**
     * @param args the command line arguments
     */
    private int id;
    private String name;
    private String description;
    private double price;
    private double salePrice;
    private int duration;

    public Packages() {
    }

    public Packages(int id, String name, String description, double price, double salePrice, int duration) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.salePrice = salePrice;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Packages{" + "id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", salePrice=" + salePrice + ", duration=" + duration + '}';
    }

    
}
