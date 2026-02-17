package FileReader;

public class Sale {

    private  final String id;
    private final String name;
    private int price;
    private int quantity;

    public Sale(String id, String name, int price, int quantity){
        this.id=id;
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }


    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }

    public int getQuantity(){
        return quantity;
    }

    public int getTotalAmount(){
        return price*quantity;
    }
}
