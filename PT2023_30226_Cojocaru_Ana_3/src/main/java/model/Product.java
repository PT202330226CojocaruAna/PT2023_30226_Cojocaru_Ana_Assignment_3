package model;

public class Product {

    private int codProdus;
    private String name;
    private double price;
    private int cantitate;

    /**
     *
     */
    public Product(){

    }

    /**
     * @param codProdus cod produs
     * @param name nume
     * @param price pret
     * @param cantitate cantitate
     */
    public Product(int codProdus, String name, double price, int cantitate){

        this.codProdus=codProdus;
        this.name=name;
        this.price=price;
        this.cantitate=cantitate;

    }

    /**
     * @param name numele
     * @param price pret
     * @param cantitate cantitate
     */
    public Product(String name, double price, int cantitate){

        this.name=name;
        this.price=price;
        this.cantitate=cantitate;

    }

    /**
     * @return returneaza numele
     */
    public String getName() {
        return name;
    }

    /**
     * @return get cod
     */
    public int getCodProdus(){
        return codProdus;
    }

    /**
     * @param codProdus seteaza cod
     */
    public void setCodProdus(int codProdus){
        this.codProdus = codProdus;
    }

    /**
     * @param name seteaza numele
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * @return pret
     */
    public double getPrice(){
        return price;
    }

    /**
     * @param price seteaza pret
     */
    public void setPrice(double price){
        this.price = price;
    }

    /**
     * @return returenaza cantitatea
     */
    public int getCantitate(){
        return cantitate;
    }

    /**
     * @param cantitate seteaza cantitatea
     */
    public void setCantitate(int cantitate){
        this.cantitate = cantitate;
    }

}
