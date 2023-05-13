package model;

public class Order {

    private int number;  //id comanda
    private int idClient; //id client
    private int codProdus; // id produs
    private int cantitate;
    private int price;

    public Order(){

    }

    /**
     * @param number
     * @param idClient
     * @param codProdus
     * @param cantitate
     * @param price
     */
    public Order(int number, int idClient, int codProdus, int cantitate, int price){

        this.number=number;
        this.idClient=idClient;
        this.codProdus=codProdus;
        this.cantitate=cantitate;
        this.price=price;
    }

}
