package model;

public class Orders {

    private int number;  //id comanda
    private int idClient; //id client
    private int codProdus; // id produs
    private int cantitate;
    private double price;

    public Orders(){

    }

    /**
     * @param number
     * @param idClient
     * @param codProdus
     * @param cantitate
     * @param price
     */
    public Orders(int number, int idClient, int codProdus, int cantitate, double price){

        this.number=number;
        this.idClient=idClient;
        this.codProdus=codProdus;
        this.cantitate=cantitate;
        this.price=price;
    }

    public Orders(int idClient, int codProdus, int cantitate, double price){

        this.idClient=idClient;
        this.codProdus=codProdus;
        this.cantitate=cantitate;
        this.price=price;
    }

}
