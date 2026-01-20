/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apple_store;

/**
 *
 * @author FOTZS41
 */
import java.time.LocalDateTime;

public class StockTransaction {
    private String transactionId;
    private Product product;
    private int quantity;
    private String transactionType; // IN / OUT
    private LocalDateTime transactionDate;

    public StockTransaction(String transactionId, Product product,
                            int quantity, String transactionType) {
        this.transactionId = transactionId;
        this.product = product;
        this.quantity = quantity;
        this.transactionType = transactionType;
        this.transactionDate = LocalDateTime.now();
    }
}
