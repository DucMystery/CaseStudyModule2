package CodeGym.Manager;

import CodeGym.Model.Product;
import CodeGym.ProductList.ProductList;

public interface Function {

    void editNameByID(int id, String newName);
    void editBrandByID(int id, String newBrand);
    void editPriceByID(int id, double newPrice);
    void editDescriptionByID(int id, String description);
    ProductList<Product> sortPriceUp();
    ProductList<Product> sortPriceDown();
}
