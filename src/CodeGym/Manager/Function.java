package CodeGym.Manager;

import CodeGym.Model.Product;
import CodeGym.ProductList.ProductList;

public interface Function {

    void editNameByID(String  id, String newName);
    void editBrandByID(String id, String newBrand);
    void editPriceByID(String id, double newPrice);
    void editDescriptionByID(String id, String description);
    void sortPriceUp();
    void sortPriceDown();
}
