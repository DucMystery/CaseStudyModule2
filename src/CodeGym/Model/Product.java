package CodeGym.Model;

public abstract class Product {

    protected String id;
    protected String name;
    protected String brand;
    protected double price;
    protected String description;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public abstract void setName(String name);
    public abstract void setPrice(double price);
    public abstract void setBrand(String brand);
    public abstract void setDescription(String description);

    @Override
    public String toString() {
        return "ID : "+getId()+" , Name : "+getName()+" , Brand : "+getBrand()+" , Price : " +getPrice()+" , Description : "+getDescription();
    }
}
