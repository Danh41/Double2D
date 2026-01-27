package apple_store;

import java.util.Scanner;

public class SystemManager {

    private String version = "v1.0.2";
    private boolean isDataLoaded = false;

    private ProductManager productManager;
    private CategoryManager categoryManager;
    private Inventory inventory;
    private SearchService searchService;
    private FilterService filterService;
    private PriceManager priceManager;

    private Scanner scanner;

    public SystemManager() {
        scanner = new Scanner(System.in);

        productManager = new ProductManager();
        categoryManager = new CategoryManager();
        inventory = new Inventory();
        searchService = new SearchService();
        filterService = new FilterService();
        priceManager = new PriceManager();
    }

    // ================= SYSTEM START =================
    public void start() {
        initSystem();

        int choice;
        do {
            displayMainMenu();
            choice = readInt();
            handleUserChoice(choice);
        } while (choice != 0);
    }

    // ================= MAIN MENU =================
    public void displayMainMenu() {
        System.out.println("\n====== APPLE STORE MANAGEMENT SYSTEM ======");
        System.out.println("1. Product Management");
        System.out.println("2. Category Management");
        System.out.println("3. Inventory Management");
        System.out.println("4. Search Products");
        System.out.println("5. Filter Products");
        System.out.println("6. Price Management");
        System.out.println("7. System Information");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    public void handleUserChoice(int choice) {
        switch (choice) {
            case 1:
                productMenu();
                break;
            case 2:
                categoryMenu();
                break;
            case 3:
                inventoryMenu();
                break;
            case 4:
                searchMenu();
                break;
            case 5:
                filterMenu();
                break;
            case 6:
                priceMenu();
                break;
            case 7:
                showSystemStatus();
                break;
            case 0:
                exitSystem();
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    // ================= PRODUCT MENU =================
    private void productMenu() {
        int choice;
        do {
            System.out.println("\n--- PRODUCT MANAGEMENT ---");
            System.out.println("1. Add product");
            System.out.println("2. Update product");
            System.out.println("3. Delete product");
            System.out.println("4. View all products");
            System.out.println("5. Check stock availability");
            System.out.println("0. Back");
            System.out.print("Choose: ");

            choice = readInt();

            switch (choice) {
                case 1:
                    productManager.addProductFromInput(scanner);
                    break;
                case 2:
                    productManager.updateProductFromInput(scanner);
                    break;
                case 3:
                    productManager.deleteProductFromInput(scanner);
                    break;
                case 4:
                    productManager.displayAllProducts();
                    break;
                case 5:
                    productManager.checkStockFromInput(scanner);
                    break;
            }
        } while (choice != 0);
    }

    // ================= CATEGORY MENU =================
    private void categoryMenu() {
        int choice;
        do {
            System.out.println("\n--- CATEGORY MANAGEMENT ---");
            System.out.println("1. Add category");
            System.out.println("2. View all categories");
            System.out.println("3. View products by category");
            System.out.println("0. Back");
            System.out.print("Choose: ");

            choice = readInt();

            switch (choice) {
                case 1:
                    categoryManager.addCategoryFromInput(scanner);
                    break;
                case 2:
                    categoryManager.displayAllCategories();
                    break;
                case 3:
                    categoryManager.viewProductsByCategory(scanner, productManager);
                    break;
            }
        } while (choice != 0);
    }

    // ================= INVENTORY MENU =================
    private void inventoryMenu() {
        int choice;
        do {
            System.out.println("\n--- INVENTORY MANAGEMENT ---");
            System.out.println("1. Update stock quantity (IN / OUT)");
            System.out.println("2. View low stock products");
            System.out.println("0. Back");
            System.out.print("Choose: ");

            choice = readInt();

            switch (choice) {
                case 1:
                    inventory.updateQuantityFromInput(scanner);
                    break;
                case 2:
                    inventory.displayLowStockProducts();
                    break;
            }
        } while (choice != 0);
    }

    // ================= SEARCH MENU =================
    private void searchMenu() {
        int choice;
        do {
            System.out.println("\n--- SEARCH PRODUCTS ---");
            System.out.println("1. Search by name");
            System.out.println("2. Search by ID");
            System.out.println("0. Back");
            System.out.print("Choose: ");

            choice = readInt();

            switch (choice) {
                case 1:
                    searchService.searchByNameFromInput(scanner, productManager);
                    break;
                case 2:
                    searchService.searchByIdFromInput(scanner, productManager);
                    break;
            }
        } while (choice != 0);
    }

    // ================= FILTER MENU =================
    private void filterMenu() {
        int choice;
        do {
            System.out.println("\n--- FILTER PRODUCTS ---");
            System.out.println("1. Filter by price range");
            System.out.println("2. Filter by stock status");
            System.out.println("0. Back");
            System.out.print("Choose: ");

            choice = readInt();

            switch (choice) {
                case 1:
                    filterService.filterByPriceRangeFromInput(scanner, productManager);
                    break;
                case 2:
                    filterService.filterByStatusFromInput(scanner, productManager);
                    break;
            }
        } while (choice != 0);
    }

    // ================= PRICE MENU =================
    private void priceMenu() {
        int choice;
        do {
            System.out.println("\n--- PRICE MANAGEMENT ---");
            System.out.println("1. Apply mass price update");
            System.out.println("2. Set promotional price");
            System.out.println("0. Back");
            System.out.print("Choose: ");

            choice = readInt();

            switch (choice) {
                case 1:
                    priceManager.applyMassPriceUpdateFromInput(scanner, productManager);
                    break;
                case 2:
                    priceManager.setPromotionalPriceFromInput(scanner, productManager);
                    break;
            }
        } while (choice != 0);
    }

    // ================= SYSTEM =================
    public void initSystem() {
        System.out.println("Initializing system...");
        isDataLoaded = true;
    }

    public void showSystemStatus() {
        System.out.println("\n--- SYSTEM STATUS ---");
        System.out.println("Version: " + version);
        System.out.println("Data loaded: " + isDataLoaded);
        System.out.println("Total products: " + productManager.getTotalProducts());
    }

    public void exitSystem() {
        System.out.println("Exiting system...");
        System.out.println("Thank you for using Apple Store Management System!");
    }

    // ================= UTIL =================
    private int readInt() {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("Please enter a number: ");
        }
        return scanner.nextInt();
    }
}
