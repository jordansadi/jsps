package us.jordan.model;

public class Item {
    private int productNumber;
    private String name;
    private double price;

    public Item(int productNumber, String name, double price) {
        this.productNumber = productNumber;
        this.name = name;
        this.price = price;
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

    public void setProductNumber(int pn) { productNumber = pn; }
    public void setName(String n) { name = n; }
    public void setPrice(double p) { price = p; }
}