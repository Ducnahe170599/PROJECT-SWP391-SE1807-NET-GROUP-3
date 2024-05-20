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
    private int accessDuration;
    private BigDecimal price;
    private BigDecimal salePrice;
    private String description;

    public Packages() {
    }

    public Packages(int id, String name, int accessDuration, BigDecimal price, BigDecimal salePrice, String description) {
        this.id = id;
        this.name = name;
        this.accessDuration = accessDuration;
        this.price = price;
        this.salePrice = salePrice;
        this.description = description;
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

    public int getAccessDuration() {
        return accessDuration;
    }

    public void setAccessDuration(int accessDuration) {
        this.accessDuration = accessDuration;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Package{" + "id=" + id + ", name=" + name + ", accessDuration=" + accessDuration + ", price=" + price + ", salePrice=" + salePrice + ", description=" + description + '}';
    }
    
}
