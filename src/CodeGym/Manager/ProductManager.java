package CodeGym.Manager;

import CodeGym.Model.Fridge;
import CodeGym.Model.Product;
import CodeGym.Model.Television;
import CodeGym.ProductList.ProductList;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductManager implements Function {
    public static final String PRODUCT_LIST_TXT = "C:\\Users\\admin\\IdeaProjects\\CaseStudy\\productList.txt";
    private final ProductList<Product> products;
    public final String ID_FRIDGE = "^[I,D]{2}\\s[:]{1}\\s[2]{1}.*$";
    public final String ID_TV = "^[I,D]{2}\\s[:]{1}\\s[1]{1}.*$";
    public final String F = "200";
    public final String T = "100";
    Pattern pattern = Pattern.compile(ID_FRIDGE);
    Pattern pattern1 = Pattern.compile(ID_TV);


    public ProductManager(ProductList<Product> products) throws FileNotFoundException {
        this.products = products;
    }

    public void creatFridge(String id, String name, String brand, double capacity, double price, String description) {
        Product product = new Fridge(id, name, brand, capacity, price, description);
        products.add(product);
    }

    public void creatTelevision(String id, String name, String brand, double inch, double price, String description) {
        Product product = new Television(id, name, brand, inch, price, description);
        products.add(product);
    }
    public boolean checkID(String id){
        for (Product product :products){
            if (checkProductTV(product)){
                product =(Television)product;
                if (product.getId().equalsIgnoreCase((T+id)))
                    return true;
            }
            if (checkProductFridge(product)){
                product =(Fridge)product;
                if (product.getId().equalsIgnoreCase((F+id)))
                    return true;
            }
        }
        return false;
    }

    public boolean checkProductFridge(Product product) {
     Pattern pattern = Pattern.compile(ID_FRIDGE);
        Matcher matcher = pattern.matcher(product.toString());
        if (matcher.matches()) {
            product = (Fridge) product;
            return true;
        }
        return false;
    }

    public boolean checkProductTV(Product product) {
        Pattern pattern = Pattern.compile(ID_TV);
        Matcher matcher = pattern.matcher(product.toString());
        if (matcher.matches()) {
            product = (Television) product;
            return true;
        }
        return false;
    }

    public synchronized void save() {
        try {
            FileOutputStream fout = new FileOutputStream("productList.txt");
            for (Product product : products) {
                if (checkProductTV(product)) {
                    byte[] bytes = product.toString().getBytes();
                    byte[] downLine = "\n".getBytes();
                    fout.write(bytes);
                    fout.write(downLine);
                } else if (checkProductFridge(product)) {
                    byte[] bytes = product.toString().getBytes();
                    byte[] downLine = "\n".getBytes();
                    fout.write(bytes);
                    fout.write(downLine);
                }
            }
            fout.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void read() throws IOException {
//        FileReader reader = new FileReader(PRODUCT_LIST_TXT);
//        BufferedReader br = new BufferedReader(reader);
//        String line;
//        while ((line = br.readLine()) != null) {
//            Matcher matcher = pattern.matcher(line);
//            Matcher matcher1 = pattern1.matcher(line);
//            String[] content = line.split(" ,");
//            if (matcher.matches()) {
//                String idFridge = content[0].substring(8);
//                String nameFridge = content[1].substring(7);
//                String brandFridge = content[2].substring(8);
//                double capacityFridge = Double.parseDouble(content[3].substring(11));
//                double priceFridge = Double.parseDouble(content[4].substring(8));
//                String descriptionFridge = content[5].substring(14);
//                creatFridge(idFridge, nameFridge, brandFridge, capacityFridge, priceFridge, descriptionFridge);
//            } else if (matcher1.matches()) {
//                String idTV = content[0].substring(8);
////                String nameTV = content[1].substring(7);
////                String brandTV = content[2].substring(8);
////                double inchTV = Double.parseDouble(content[3].substring(7));
////                double priceTV = Double.parseDouble(content[4].substring(8));
////                String descriptionTV = content[5].substring(14);
//                creatTelevision(idTV, nameTV, brandTV, inchTV, priceTV, descriptionTV);
//            }
//        }
//        br.close();
//    }

    public void read() throws IOException {
        FileReader reader = new FileReader(PRODUCT_LIST_TXT);
        BufferedReader br = new BufferedReader(reader);
        String line;
        while ((line = br.readLine())!=null){
            Matcher matcher = pattern.matcher(line);
            Matcher matcher1 = pattern1.matcher(line);
            String []content =line.split(" ,");
            if (matcher.matches()){
                creatFridge((content[0].substring(8)),(content[1].substring(7)),(content[2].substring(8)),Double.parseDouble(content[3].substring(11)),Double.parseDouble(content[4].substring(8)),content[5].substring(14));
            }else if (matcher1.matches()){
                creatTelevision((content[0].substring(8)),(content[1].substring(7)),(content[2].substring(8)),Double.parseDouble(content[3].substring(7)),Double.parseDouble(content[4].substring(8)),content[5].substring(14));
            }

        }
        br.close();

    }

    @Override
    public void editNameByID(String id, String newName) {
        for (Product product : products) {
            if (checkProductFridge(product)) {
                if (product.getId().equals(F + id)) {
                    product.setName(newName);
                    return;
                }
            } else if (checkProductTV(product)) {
                if (product.getId().equals(T + id)) {
                    product.setName(newName);
                    return;
                }
            }
        }
    }

    @Override
    public void editBrandByID(String id, String newBrand) {
        for (Product product : products) {
            if (checkProductFridge(product)) {
                if (product.getId().equals(F + id)) {
                    product.setBrand(newBrand);
                    return;
                }
            } else if (checkProductTV(product)) {
                if (product.getId().equals(T + id)) {
                    product.setBrand(newBrand);
                    return;
                }
            }
        }
    }

    @Override
    public void editPriceByID(String id, double newPrice) {
        for (Product product : products) {
            if (checkProductFridge(product)) {
                if (product.getId().equals(F + id)) {
                    product.setPrice(newPrice);
                    return;
                }
            } else if (checkProductTV(product)) {
                if (product.getId().equals(T + id)) {
                    product.setPrice(newPrice);
                    return;
                }
            }
        }
    }

    @Override
    public void editDescriptionByID(String id, String newDescription) {
        for (Product product : products) {
            if (checkProductFridge(product)) {
                if (product.getId().equals(F + id)) {
                    product.setDescription(newDescription);
                    return;
                }
            } else if (checkProductTV(product)) {
                if (product.getId().equals(T + id)) {
                    product.setDescription(newDescription);
                    return;
                }
            }
        }
    }

    @Override
    public void sortPriceUp() {
        for (int i = 0; i < products.size(); i++) {
            Product currentMin = products.get(i);
            int currentMinIndex = i;

            for (int j = i + 1; j < products.size(); j++) {
                if (currentMin.getPrice() > products.get(j).getPrice()) {
                    currentMin = products.get(j);
                    currentMinIndex = j;
                }
            }

            if (currentMinIndex != i) {
                products.set(currentMinIndex, products.get(i));
                products.set(i, currentMin);
            }
        }
        displayAll(products);
    }

    @Override
    public void sortPriceDown() {
        boolean status = true;
        for (int k = 1; k < products.size() && status; k++) {
            status = false;
            for (int i = 0; i < products.size() - k; i++) {
                if (products.get(i).getPrice() < products.get(i + 1).getPrice()) {
                    Product temp = products.get(i);
                    products.set(i, products.get(i + 1));
                    products.set(i + 1, temp);

                    status = true;
                }
            }
        }
        displayAll(products);
    }

    public void deleteProduct(String id) {
        for (Product product : products) {
            if (checkProductTV(product)){
                product = (Television)product;
                if (product.getId().equals(T+id)){
                    products.remove(product);
                    return;
                }
            }
            if (checkProductFridge(product)){
                product = (Fridge)product;
                if (product.getId().equals(F+id)){
                    products.remove(product);
                    return;
                }
            }
        }
    }

    public void displayAll(ProductList<Product> products){
        for (Product product :products){
           if (checkProductTV(product)){
               System.out.println(product.toString());
           }else if (checkProductFridge(product))
               System.out.println(product.toString());
        }
    }

    public void findByName(String name){
        for (Product product :products){
            if (checkProductTV(product)){
                product = (Television)product;
                if (product.getName().contains(name))
                    System.out.println(product.toString());
            }
            if (checkProductFridge(product)){
                product = (Fridge)product;
                if (product.getName().contains(name))
                    System.out.println(product.toString());
            }
        }
    }
    public void findByID(String id){
        for (Product product : products){
            if (checkProductTV(product)){
                product = (Television)product;
                if (product.getId().contains(id))
                    System.out.println(product.toString());
            }
            if (checkProductFridge(product)){
                product =(Fridge)product;
                if (product.getId().contains(id))
                    System.out.println(product.toString());
            }
        }
    }
    public void findFridge(ProductList<Product> products){
        for (Product product : products){
            if (checkProductFridge(product)){
                System.out.println(product.toString());
            }
        }
    }
    public void findTelevision(ProductList<Product> products){
        for (Product product :products){
            if (checkProductTV(product))
                System.out.println(product.toString());
        }
    }
    public double sumPriceOfProduct(ProductList<Product> products){
        double sum =0;
        for (Product product : products){
            if (checkProductFridge(product)){
                sum+=product.getPrice();
            }else if (checkProductTV(product))
                sum+=product.getPrice();
        }
        return sum;
    }
}
