package model;
import businessLayer.BillBLL;
import businessLayer.ClientBLL;
import businessLayer.ProductBLL;
import connection.ConnectionFactory;
import dataAccessLayer.AbstractDAO;
import dataAccessLayer.BillDAO;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.Level;


public record Bill ( int codProdus, int cantitate, double price, int idClient){

    /**
     * @param codProdus de introdus in tabelul Log
     * @param cantitate
     * @param price
     * @param idClient
     */
    public Bill(int codProdus, int cantitate, double price, int idClient) {

        this.idClient = idClient;
        this.codProdus = codProdus;
        this.cantitate = cantitate;
        this.price = price;

       // String message= new String("Clientul cu numele: "+ numeClient);
        String messageA= new String("A cumparat: "+ cantitate+" "+codProdus);
        //String messageB= new String("Total de plata: "+price);

        // Bill bill = new Bill(message,messageA,messageB,messageC);
       // Bill bill = new Bill(numeClient,codProdus,cantitate,price);

        //(new BillDAO()).insert(this);
        //(new BillBLL()).insert();
        Client sss = (new ClientBLL()).findClientById(idClient);
        String ss = sss.getName();

        Product sss1 = (new ProductBLL()).findProductByCod(codProdus);
        String ss1 = sss1.getName();

        try (FileWriter writer = new FileWriter("log.txt", false)) {
            String bill = String.format("----------BILL--------\n");
            String message = String.format("Clientul cu id: %s\nA cumparat: %d %s\nPret/bucata: %.2f\nTotal de plata: %.2f\n", ss, cantitate,ss1, price, price*cantitate);
            writer.write(bill);
            writer.write(message);
            writer.write(System.lineSeparator());
        } catch (IOException e) {
           // LOGGER.log(Level.SEVERE, "Failed to write log message", e);
        }

    }


    /**
     * @param codProdus -
     * @param cantitate-
     * @param price-
     * @param numeClient-
     */
   // public static void calculateBill(String nume, double amount,int quantity, double pret) {
    public static void calculateBill(int codProdus, int cantitate, double price,String numeClient) {
/*
        LOGGER.setLevel(Level.ALL);
        Handler[] handlers = LOGGER.getHandlers();
        for(Handler handler: handlers){
            LOGGER.removeHandler(handler);
        }
        try (Connection conn = DriverManager.getConnection(DBURL,USER,PASS);
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO logs (message) VALUES (?)"
             )) {
            stmt.setString(1, String.format("Clientul cu numele: %s", nume));

            stmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Failed to insert log message", e);
        }

        try (Connection conn = DriverManager.getConnection(DBURL,USER,PASS);
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO logs (messageA) VALUES (?)"
             )) {
            stmt.setString(1, String.format("A cumparat: %d produse", quantity));
            stmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Failed to insert log message", e);
        }

        try (Connection conn = DriverManager.getConnection(DBURL,USER,PASS);
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO logs (messageC) VALUES (?)"
             )) {
            stmt.setString(1, String.format("Total de plata: %.2f", pret));
            stmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Failed to insert log message", e);
        }


        try (FileWriter writer = new FileWriter("log.txt", false)) {
            String bill = String.format("----------BILL--------\n");
            String message = String.format("Clientul cu numele: %s\n A cumparat: %d produse\n Pret/bucata: %.2f\n Total de plata: %.2f\n", nume, quantity, amount, pret);
            writer.write(bill);
            writer.write(message);
            writer.write(System.lineSeparator());
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to write log message", e);
        }*/


    }

    /**
     * @return  id
     */
    public int getIdClient(){
        return idClient;
    }

    /**
     * @return  cod
     */
    public int getCodProdus(){
        return codProdus;
    }

    /**
     * @return  cantitate
     */
    public int getCantitate(){
        return cantitate ;
    }

/*    public double getPrice(){
        return price;
    }*/


    /**
     * @return toString
     */
    public String toString(){
        return "Clientul cu id: "+ idClient+"\nA cumparat: "+ cantitate+" "+codProdus;
    }

}

