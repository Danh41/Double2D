/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apple_store;

/**
 *
 * @author FOTZS41
 */
import java.util.*;

public class SearchService {
    private List<Product> lastSearchResults = new ArrayList<>();

    public List<Product> searchByName(List<Product> products, String name) {
        lastSearchResults.clear();
        for (Product p : products) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                lastSearchResults.add(p);
            }
        }
        return lastSearchResults;
    }

    public Product searchById(List<Product> products, String id) {
        for (Product p : products) {
            if (p.getId().equals(id)) return p;
        }
        return null;
    }
}

