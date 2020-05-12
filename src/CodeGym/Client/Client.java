package CodeGym.Client;

import CodeGym.Manager.ProductManager;
import CodeGym.Model.Product;
import CodeGym.ProductList.ProductList;

import java.io.FileNotFoundException;
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
        System.out.println("You are : ");
        System.out.println("1. Admin");
        System.out.println("2.Customer");
        int chooseAccount = scanner.nextInt();
        switch (chooseAccount){
            case 1:
                System.out.println("Enter a name :");
                scanner.nextLine();
                String nameAccount = scanner.nextLine();
                if (nameAccount.equals(NAME)|| nameAccount.equals(NAME1)){
                    displayAdmin();
                }else {
                    System.out.println( "does not exist");
                    account();
                }
                break;
            case 2:
                displayCustomer();
            default:
        }
    }

    public void displayAdmin(){
        System.out.println("Select  action:");
        System.out.println("1.Add new product :");
        System.out.println("2.Edit name by ID :");
        System.out.println("3. Edit price by ID :");
        System.out.println("4. Edit description by ID :");
        System.out.println("5. Edit brand by ID :");
        System.out.println("6. Remove product by ID :");
        System.out.println("0. Exit");
        int chooseAdmin = scanner.nextInt();
        switch (chooseAdmin){
            case 1:
                System.out.println("choose type of product :");
                System.out.println("1 . Fridge.");
                System.out.println("2 . Television.");
                System.out.println("0. Exit");
                int chooseType = scanner.nextInt();
                switch (chooseType){
                    case 1:
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
                        productManager.creatFridge(idFridge,nameFridge,brandFridge,capacityFridge,priceFridge,descriptionFridge);
                        productManager.save();
                        System.out.println("Has added new !");
                        displayAdmin();
                        break;
                    case 2:
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
                        double priceTV =scanner.nextDouble();
                        System.out.println("Enter description of TV :");
                        scanner.nextLine();
                        String descriptionTV = scanner.nextLine();
                        productManager.creatTelevision(idTV,nameTV,brandTV,inchTV,priceTV,descriptionTV);
                        productManager.save();
                        System.out.println("Has added new !");
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
            case 3:
            case 4:
            case 5:
            case 6:
            case 0:
        }
    }
    public void displayCustomer(){
        System.out.println("Select action :");
        System.out.println("1.Display all product :");
        System.out.println("2. Find product by name :");
        System.out.println("3. Find product by ID :");
        System.out.println("0.Exit.");
        int chooseCustomer = scanner.nextInt();
        switch (chooseCustomer){
            case 1:
            case 2:
            case 3:
            case 0:
        }
    }
}
