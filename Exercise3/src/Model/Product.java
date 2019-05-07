package Model;

public class Product {
    private String name;
    private Integer price;
    private Integer quantity;

    public Product(){
        name = null;
        price = 0;
        quantity = 0;
    }

    public Product(String name, Integer price, Integer quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName(){
        return name;
    }
    public void setName(String newName){
        this.name = newName;
    }

    public Integer getPrice(){
        return price;
    }
    public void setPrice(Integer newPrice){
        this.price = newPrice;
    }

    public Integer getQuantity(){
        return quantity;
    }

    public void setQuantity(Integer newQuantity){
        this.quantity = newQuantity;
    }

    public String toString(){
        return name + "," + price + "," + quantity +"\n";
    }
}
