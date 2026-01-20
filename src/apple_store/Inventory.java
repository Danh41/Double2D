/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apple_store;

/**
 *
 * @author FOTZS41
 */
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Integer> stockMap = new HashMap<>();

    public void updateStock(String productId, int quantity) {
        stockMap.put(productId, quantity);
    }

    public int getStock(String productId) {
        return stockMap.getOrDefault(productId, 0);
    }
}

