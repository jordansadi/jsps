package us.matt.model;

public class Item {
    private int productNumber;
    private String name;
    private double price;
    private String description;

    public Item(int productNumber, String name, double price, String description) {
        this.productNumber = productNumber;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
