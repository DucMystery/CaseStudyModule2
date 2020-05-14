package CodeGym.Manager;

import CodeGym.Model.Fridge;
import CodeGym.Model.Product;
import CodeGym.Model.Television;
import CodeGym.ProductList.ProductList;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class ProductManagerTest {
   public ProductList<Product> products = new ProductList<Product>();
    Product product1 = new Fridge("i1","gtx1","LG",55,3000,"new");
    Product product2 = new Fridge("i2","gtx2","samsung",55,3000,"new");
    Product product3 = new Fridge("i4","gtx12","Panasonic",55,3000,"new");
    Product product4 = new Fridge("i10","gtx11","LG",55,3000,"new");
    Product product5 = new Television("i11","gtx11","LG",55,3000,"new");
    Product product6 = new Television("i13","gtx11","LG",55,3000,"new");
    Product product7 = new Television("i15","gtx11","LG",55,3000,"new");


    @Test
    public void checkIDTest() throws FileNotFoundException {
        products.add(product1);
        ProductManager productManager = new ProductManager(products);

        boolean display = true;
        String id  = "i1";
        assertEquals(true,productManager.checkID(id));


    }

    @Test
    public void checkProductFridgeTest() throws FileNotFoundException {
        Fridge productTest1 = new Fridge("i10","gtx11","LG",55,3000,"new");
        products.add(productTest1);
        ProductManager manager = new ProductManager(products);
        boolean display = true;
        assertEquals(display,manager.checkProductFridge(productTest1));

    }

    @Test
    public void checkProductTVTest() throws FileNotFoundException {
        Television productTest = new Television("i15","gtx11","LG",55,3000,"new");
        products.add(productTest);
        ProductManager manager = new ProductManager(products);
        boolean display  = true;
        assertEquals(display,manager.checkProductTV(productTest));
    }




    @Test
    public void sortPriceUp() {


    }

    @Test
    public void sortPriceDown() {
    }

    @Test
    public void deleteProduct() {
    }

    @Test
    public void displayAll() {
    }

    @Test
    public void findByName() {
    }

    @Test
    public void findByID() {
    }

    public static void main(String[] args) {

    }
}
