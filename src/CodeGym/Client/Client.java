package CodeGym.Client;

import CodeGym.Manager.ProductManager;
import CodeGym.Model.Product;
import CodeGym.ProductList.ProductList;

import java.io.IOException;
import java.util.Scanner;

public class Client {
    Scanner scanner = new Scanner(System.in);
    private static final String NAME = "Admin";
    private static final String NAME1 = "Mystery1309";

    public final ProductList<Product> products;
    public final ProductManager productManager;

    public Client() throws IOException {
        this.products = new ProductList<>();
        this.productManager = new ProductManager(products);
         productManager.read();
    }

    public void account(){
        chooseLogIn();
        int chooseAccount = scanner.nextInt();
        switch (chooseAccount){
            case 1:
                logInAccountAdmin();
                break;
            case 2:
                displayCustomer();
            default:
                System.out.println("Enter 1 to 2 :");
                account();
        }
    }

    public void logInAccountAdmin() {
        System.out.println("Enter a name :");
        scanner.nextLine();
        String nameAccount = scanner.nextLine();
        if (nameAccount.equals(NAME)|| nameAccount.equals(NAME1)){
            displayAdmin();
        }else {
            System.out.println( "does not exist");
            account();
        }
    }

    public void chooseLogIn() {
        System.out.println("You are : ");
        System.out.println("1. Admin");
        System.out.println("2.Customer");
    }

    public void displayAdmin(){
        chooseAction();
        int chooseAdmin = scanner.nextInt();
        switch (chooseAdmin){
            case 1:
                chooseTyeProduct();
                int chooseType = scanner.nextInt();
                switch (chooseType){
                    case 1:
                        addNewFridge();
                        displayAdmin();
                        break;
                    case 2:
                        addProductTV();
                        displayAdmin();
                        break;
                    case 0:
                        productManager.save();
                        System.exit(0);
                    default:
                        System.out.println("Enter 0 to 2 :");
                        displayAdmin();
                        break;
                }
            case 2:
                changeMethodProduct();
                break;
            case 3:
                changePriceOfProduct();
                displayAdmin();
                break;
            case 4:
                changeDescriptionOfProduct();
                displayAdmin();
                break;
            case 5:
                changeBrandOfProduct();
                displayAdmin();
                break;
            case 6:
                deleteProduct();
                displayAdmin();
                break;
            case 7:
                account();
                break;

            case 0:
                productManager.save();
                System.exit(0);
            default:
                System.out.println("Enter 0 to 6 :");
                displayAdmin();
                break;
        }
    }

    public void deleteProduct() {
        System.out.println("Enter a ID :");
        scanner.nextLine();
        String idRemove = scanner.nextLine();
        if (productManager.checkID(idRemove)){
            productManager.deleteProduct(idRemove);
            productManager.save();
            System.out.println("deleted product !");
        }else {
            System.out.println("ID does not exist !");
        }
    }

    public void changeBrandOfProduct() {
        System.out.println("Enter a ID :");
        scanner.nextLine();
        String idBrand = scanner.nextLine();
        System.out.println("Enter a new brand of product :");
        String newBrand = scanner.nextLine();
        if (productManager.checkID(idBrand)){
            productManager.editBrandByID(idBrand,newBrand);
            productManager.save();
            System.out.println("Saved changes !");
        }else {
            System.out.println("ID does not exist !");
        }
    }

    public void changeDescriptionOfProduct() {
        System.out.println("Enter a ID :");
        scanner.nextLine();
        String idDescription = scanner.nextLine();
        System.out.println("Enter a new description of product :");
        String newDescription = scanner.nextLine();
        if (productManager.checkID(idDescription)){
            productManager.editDescriptionByID(idDescription,newDescription);
            productManager.save();
            System.out.println("Saved changes !");
        }else {
            System.out.println("ID does not exist !");
        }
    }

    public void changePriceOfProduct() {
        System.out.println("Enter a ID :");
        scanner.nextLine();
        String idPrice = scanner.nextLine();
        System.out.println("Enter a new price of product :");
        double newPrice = scanner.nextInt();
        if (productManager.checkID(idPrice)){
            productManager.editPriceByID(idPrice,newPrice);
            productManager.save();
            System.out.println("Saved changes !");
        }else {
            System.out.println("ID does not exist !");
        }
    }

    public void addNewFridge() {
        System.out.println("Enter ID of Fridge :");
        scanner.nextLine();
        String idFridge = scanner.nextLine();
        System.out.println("Enter name of Fridge :");
        String nameFridge = scanner.nextLine();
        System.out.println("Enter brand of Fridge :");
        String brandFridge = scanner.nextLine();
        System.out.println("Enter capacity of Fridge :");
        double capacityFridge = scanner.nextDouble();
        System.out.println("Enter price of Fridge :");
        double priceFridge =scanner.nextDouble();
        System.out.println("Enter description of Fridge :");
        scanner.nextLine();
        String descriptionFridge = scanner.nextLine();
        if (productManager.checkID(idFridge)){
            System.out.println("ID already exist !");
        }else {
            productManager.creatFridge(idFridge,nameFridge,brandFridge,capacityFridge,priceFridge,descriptionFridge);
            productManager.save();
        }
    }

    public void chooseAction() {
        System.out.println("******MENU***********");
        System.out.println("Select  action:");
        System.out.println("1.Add new product :");
        System.out.println("2.Edit name by ID :");
        System.out.println("3. Edit price by ID :");
        System.out.println("4. Edit description by ID :");
        System.out.println("5. Edit brand by ID :");
        System.out.println("6. Remove product by ID :");
        System.out.println("7. Log out :");
        System.out.println("0. Exit");
    }

    public void chooseTyeProduct() {
        System.out.println("choose type of product :");
        System.out.println("1 . Fridge.");
        System.out.println("2 . Television.");
        System.out.println("0. Exit");
    }

    public void addProductTV() {
        System.out.println("Enter ID of TV :");
        scanner.nextLine();
        String idTV = scanner.nextLine();
        System.out.println("Enter name of TV :");
        String nameTV = scanner.nextLine();
        System.out.println("Enter brand of TV :");
        String brandTV = scanner.nextLine();
        System.out.println("Enter inch of TV :");
        double inchTV = scanner.nextDouble();
        System.out.println("Enter price of TV :");
        double priceTV =scanner.nextInt();
        System.out.println("Enter description of TV :");
        scanner.nextLine();
        String descriptionTV = scanner.nextLine();
        if (productManager.checkID(idTV)==true){
            System.out.println("ID already exist");
        }else {
            productManager.creatTelevision(idTV,nameTV,brandTV,inchTV,priceTV,descriptionTV);
            productManager.save();
            System.out.println("Has added new !");
        }
    }

    private void changeMethodProduct() {
        System.out.println("Enter a ID :");
        scanner.nextLine();
        String idName = scanner.nextLine();
        System.out.println("Enter a new name of product :");
        String newName = scanner.nextLine();
        productManager.editNameByID(idName,newName);
        productManager.save();
        System.out.println("Saved changes !");
        displayAdmin();
    }

    public void displayCustomer(){
        System.out.println("************MENU******************");
        System.out.println("Select action :");
        System.out.println("1.Display all product :");
        System.out.println("2. View product price down to up :");
        System.out.println("3. View product price up to down  :");
        System.out.println("4.Find product by name :");
        System.out.println("5. Find product by ID :");
        System.out.println("6. Find by types of product :");
        System.out.println("7. Sum the price of products :");
        System.out.println("8. Log out :");
        System.out.println("0.Exit.");
        int chooseCustomer = scanner.nextInt();
        switch (chooseCustomer){
            case 1:
                productManager.displayAll(products);
                displayCustomer();
                break;
            case 2:
                productManager.sortPriceUp();
                displayCustomer();
                break;
            case 3:
                productManager.sortPriceDown();
                displayCustomer();
                break;
            case 4:
                System.out.println("Enter the name of the product to search :");
                scanner.nextLine();
                String nameFind = scanner.nextLine();
                productManager.findByName(nameFind);
                displayCustomer();
                break;
            case 5:
                System.out.println("Enter the ID of the product to search :");
                scanner.nextLine();
                String idFind = scanner.nextLine();
                productManager.findByID(idFind);
                displayCustomer();
                break;
            case 6:
                findByTypeProduct();
                break;
            case 7:
                System.out.println("Sum the price of products is :"+productManager.sumPriceOfProduct(products)+" $");
                displayCustomer();
                break;
            case 8:
                account();
                break;
            case 0:
                productManager.save();
                System.exit(0);
            default:
                System.out.println("Enter 0 to 5 :");
                displayCustomer();
                break;
        }
    }

    public void findByTypeProduct() {
        System.out.println("Choose product :");
        System.out.println("1. Fridge .");
        System.out.println("2. Television .");
        int chooseTypeProduct = scanner.nextInt();
        switch (chooseTypeProduct){
            case 1:
                productManager.findFridge(products);
                displayCustomer();
                break;
            case 2:
                productManager.findTelevision(products);
                displayCustomer();
                break;
            default:
                System.out.println("Choose 1 or 2 :");
                findByTypeProduct();
        }
    }
}
