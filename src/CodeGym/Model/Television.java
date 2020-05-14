package CodeGym.Model;

public class Television extends Product {
    @Override
    public String toString() {
        return "ID : "+getId()+" , Name : "+getName()+" , Brand : "+getBrand()+" , Inch : "+getInch()+" , Price: "+getPrice()+" , Description : "+getDescription();

}

    @Override
    public void setPrice(double price) {
        this.price =price;
    }

    @Override
    public void setBrand(String brand) {
        this.brand =brand;
    }

    @Override
    public void setDescription(String description) {
        this.description =description;
    }
    private double inch;
    private final String T ="100";

    public Television(){}

    public Television(String id, String name, String brand, double inch, double price, String description){
        this.id = T+id;
        this.name = name;
        this.brand = brand;
        this.inch = inch;
        this.price =price;
        this.description = description;
    }

    public String getId(){
        return id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public double getInch() {
        return inch;
    }

    public Television setInch(double inch) {
        this.inch = inch;
        return this;
    }
}
