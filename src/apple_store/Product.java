/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apple_store;

/**
 *
 * @author FOTZS41
 */
public class Product {
    private String productId;
    private String productName;
    private double price;
    private int quantity;
    private String description;
    private Category category;
    private Suppiler supplier;

    public Product(String productId, String productName, double price, int quantity,
                   String description, Category category, Suppiler supplier) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.category = category;
        this.supplier = supplier;
    }

    // Getter & Setter
    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public Category getCategory() { return category; }

    public void setPrice(double price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public void displayInfo() {
        System.out.println(productId + " - " + productName + " - $" + price);
    }
}

