/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apple_store;

/**
 *
 * @author FOTZS41
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {

    private List<Product> productList = new ArrayList<>();

    /* =========================
       1. ADD PRODUCT (FROM MENU)
       ========================= */
    public void addProductFromInput(Scanner sc) {
        System.out.print("Enter product ID: ");
        String id = sc.nextLine();

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter price: ");
        double price = Double.parseDouble(sc.nextLine());

        System.out.print("Enter quantity: ");
        int quantity = Integer.parseInt(sc.nextLine());

        System.out.print("Enter description: ");
        String description = sc.nextLine();

        System.out.print("Enter category ID: ");
        String categoryId = sc.nextLine();

        Product p = new Product(id, name, price, quantity, description, categoryId);
        productList.add(p);

        System.out.println("✔ Product added successfully!");
    }

    /* =========================
       2. UPDATE PRODUCT
       ========================= */
    public void updateProductFromInput(Scanner sc) {
        System.out.print("Enter product ID to update: ");
        String id = sc.nextLine();

        for (Product p : productList) {
            if (p.getId().equals(id)) {

                System.out.print("New name: ");
                p.setName(sc.nextLine());

                System.out.print("New price: ");
                p.setPrice(Double.parseDouble(sc.nextLine()));

                System.out.print("New quantity: ");
                p.setQuantity(Integer.parseInt(sc.nextLine()));

                System.out.print("New description: ");
                p.setDescription(sc.nextLine());

                System.out.print("New category ID: ");
                p.setCategoryId(sc.nextLine());

                System.out.println("Product updated!");
                return;
            }
        }
        System.out.println("Product not found!");
    }

    /* =========================
       3. DELETE PRODUCT
       ========================= */
    public void deleteProductFromInput(Scanner sc) {
        System.out.print("Enter product ID to delete: ");
        String id = sc.nextLine();

        for (Product p : productList) {
            if (p.getId().equals(id)) {
                productList.remove(p);
                System.out.println("Product deleted!");
                return;
            }
        }
        System.out.println("Product not found!");
    }

    /* =========================
       4. DISPLAY ALL PRODUCTS
       ========================= */
    public void displayAllProducts() {
        if (productList.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        for (Product p : productList) {
            System.out.println("----------------------");
            System.out.println("ID: " + p.getId());
            System.out.println("Name: " + p.getName());
            System.out.println("Price: " + p.getPrice());
            System.out.println("Quantity: " + p.getQuantity());
            System.out.println("Description: " + p.getDescription());
            System.out.println("Category ID: " + p.getCategoryId());
        }
        System.out.println("----------------------");
    }

    /* =========================
       5. CHECK STOCK
       ========================= */
    public void checkStockFromInput(Scanner sc) {
        System.out.print("Enter product ID: ");
        String id = sc.nextLine();

        for (Product p : productList) {
            if (p.getId().equals(id)) {
                if (p.getQuantity() > 0) {
                    System.out.println("In stock: " + p.getQuantity());
                } else {
                    System.out.println("Out of stock!");
                }
                return;
            }
        }
        System.out.println("Product not found!");
    }

    /* =========================
       OPTIONAL: GET ALL PRODUCTS
       ========================= */
    public List<Product> getAllProducts() {
        return productList;
    }
}
