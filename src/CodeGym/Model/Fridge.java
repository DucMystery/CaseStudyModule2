package CodeGym.Model;

public class Fridge extends Product {
    @Override
    public String toString() {
        return "ID : "+getId()+" , Name : "+getName()+" , Brand : "+getBrand()+" , Capacity : "+getCapacity()+" , Price : " +getPrice()+"  , Description : "+getDescription();
    }


    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    private double capacity;
    private final String F ="200";

    public Fridge(){};

    public Fridge(String id, String name, String brand, double capacity, double price , String description){
        this.id = F+id;
        this.name =name;
        this.brand = brand;
        this.capacity =capacity;
        this.price =price;
        this.description = description;
    }
    public String getId(){
        return id;
    }

    public double getCapacity() {
        return capacity;
    }

    public Fridge setCapacity(double capacity) {
        this.capacity = capacity;
        return this;
    }
}
