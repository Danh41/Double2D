# Apple Store Management System – Feature Description


## 1. Product
String id: Mã định danh duy nhất (ví dụ: "IP15PM").

String name: Tên sản phẩm (ví dụ: "iPhone 15 Pro Max").

double price: Giá bán hiện tại.

int quantity: Số lượng tồn kho thực tế.

String description: Mô tả chi tiết kỹ thuật.

String categoryId: Liên kết với danh mục sản phẩm.

- Stores product information such as product ID, name, price, quantity, and description.
- calculateDiscountedPrice(double percentage): gia sau khi giam.
- isStockAvailable(): San pham con hang khong.


## 2. Category (danh muc)
String categoryId: Mã danh mục (ví dụ: "MAC", "IPH").

String categoryName: Tên danh mục (iPhone, MacBook...).

String location: Khu vực trưng bày trong kho hoặc cửa hàng.

- Manages product categories (iPhone, iPad, MacBook, Accessories).
- displayInfo(): thong tin chi tiet danh muc or nha cung cap


## 3. ProductManager
List<Product> productList: Danh sách tập trung toàn bộ sản phẩm để xử lý CRUD.

int totalProducts: Biến đếm tổng số lượng chủng loại sản phẩm hiện có.

- Handles adding, updating, deleting, and displaying products.
- addProduct(Product p): them sp.
- updateProduct(String id, Product newInfo): cap nhat thong tin theo ID.
- deleteProduct(String id): xoa sp.
- getAllProducts(): tra ve danh sach tat ca sp.


## 4. CategoryManager (quan ly danh muc)
Map<String, Category> categories: Sử dụng Map để truy xuất danh mục nhanh hơn qua ID.

List<String> validCategoryNames: Danh sách tên danh mục được phép sử dụng.

- Manages product categories.
- addCategory(Category c): them danh muc moi.
- getProductsByCategory(String categoryId): Lay tat ca sp thuoc 1 danh muc.


## 5. Inventory (kho hang)
Map<String, Integer> stockLevels: Lưu trữ cặp Mã sản phẩm - Số lượng để kiểm tra nhanh.

int lowStockThreshold: Ngưỡng cảnh báo hết hàng (ví dụ: dưới 5 sản phẩm là báo động).

- Tracks and manages product stock quantities.
- updateQuantity(String productId, int amount): Tang giam so luong ton kho.
- getLowStockProducts(int threshold): liet ke sp sap het hang ().


## 6. StockTransaction (dao dich kho)
String transactionId: Mã giao dịch duy nhất.

String productId: Sản phẩm nào đang được xuất/nhập.

String type: Loại giao dịch ("IN" cho nhập kho, "OUT" cho xuất kho).

int quantityChange: Số lượng biến động.

LocalDateTime timestamp: Thời gian chính xác diễn ra giao dịch.

- Records product stock-in and stock-out transactions. (lich su giao dich kho: nhap kho, xuat kho)
- recordTransaction(String type, int qty): Lưu lại vết nhập/xuất kho.
- generateReport(Date reportDate): Xuất báo cáo giao dịch theo ngày.


## 7. SearchService (dich vu tim kiem)
List<Product> lastSearchResults: Lưu lại kết quả của lần tìm kiếm/lọc gần nhất.

- Allows searching products by name, ID, or category.
- searchByName(String name): Tìm kiếm gần đúng theo tên.
- searchById(String id): Tìm kiếm chính xác theo mã.


## 8. FilterService (bo loc)


- Filters products based on price range, quantity, or category.
- filterByPriceRange(double min, double max): Lọc sản phẩm trong tầm giá.
- filterByStatus(boolean inStock): Lọc theo trạng thái còn hàng/hết hàng.

## 9. PriceManager (quan ly gia)
double taxRate: Thuế VAT áp dụng cho giá sản phẩm (thường là 10% tại VN).

String currency: Đơn vị tiền tệ (VNĐ, USD).

- Manages and updates product pricing.
- applyMassPriceUpdate(double ratio): Cập nhật giá đồng loạt (ví dụ: tăng 10% toàn bộ).
- setPromotionalPrice(String id, double promoPrice): Thiết lập giá khuyến mãi tạm thời.


## 10. FileManager (tep tin)
String dataPath: Đường dẫn mặc định đến thư mục lưu trữ file (ví dụ: "C:/data/products.csv").

String backupPath: Đường dẫn thư mục sao lưu.

- Saves and loads product data from files (e.g., TXT, CSV).
- exportToCSV(List<Product> list, String path): Xuất dữ liệu ra file CSV.
- importFromTXT(String path): Đọc dữ liệu từ file văn bản vào hệ thống.


## 11. SystemManager (quan ly he thong)
String version: Phiên bản phần mềm (ví dụ: "v1.0.2").

boolean isDataLoaded: Trạng thái kiểm tra dữ liệu đã được tải lên từ file chưa.

User currentUser: Thông tin người đang vận hành hệ thống (nếu có tính năng đăng nhập).

- Controls system operations such as menus, system exit, and data backup. (luu tru va tai du lieu san pham tu cac dinh dang tep)
- displayMainMenu(): Hiển thị danh sách các tùy chọn chính (Quản lý kho, Tìm kiếm, Báo cáo...).
- handleUserChoice(int choice): Tiếp nhận lựa chọn từ bàn phím và gọi các hàm tương ứng từ ProductManager hoặc Inventory.
- initSystem(): Khởi tạo hệ thống, tự động gọi FileManager để tải dữ liệu cũ từ tệp lên bộ nhớ khi mở ứng dụng.
- backupData(): Thực hiện sao lưu dữ liệu hiện tại ra một tệp dự phòng để tránh mất mát.
- exitSystem(): Thực hiện các thủ tục đóng chương trình (hỏi người dùng có muốn lưu trước khi thoát không và giải phóng bộ nhớ).
- showSystemStatus(): Hiển thị thông tin tổng quan về hệ thống (phiên bản, dung lượng dữ liệu hiện có, trạng thái kết nối tệp).
