package model;

public class Product {

    private int codProdus;
    private String name;
    private double price;
    private int cantitate;

    public Product(){

    }

    public Product(int codProdus, String name, double price, int cantitate){

        this.codProdus=codProdus;
        this.name=name;
        this.price=price;
        this.cantitate=cantitate;

    }

    public Product(String name, double price, int cantitate){

        this.name=name;
        this.price=price;
        this.cantitate=cantitate;

    }
    public String getName() {
        return name;
    }
    public int getCodProdus(){
        return codProdus;
    }
    public void setCodProdus(int codProdus){
        this.codProdus = codProdus;
    }
    public void setName(String name){
        this.name = name;
    }

    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }

    public int getCantitate(){
        return cantitate;
    }
    public void setCantitate(int cantitate){
        this.cantitate = cantitate;
    }

}
