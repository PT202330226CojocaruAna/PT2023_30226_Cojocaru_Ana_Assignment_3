package model;
import connection.ConnectionFactory;

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


public record Bill(int orderId, double amount, LocalDateTime createdTime){
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/schooldb";
    private static final String USER = "root";
    private static final String PASS = "octombrie";

    private static final Logger LOGGER = Logger.getLogger(Bill.class.getName());

    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException e12){
            LOGGER.log(Level.SEVERE,"failed",e12);
        }
    }

    /**
     * @param nume numele cumparatorului
     * @param amount
     * @param quantity
     * @param pret pret/bucata
     */
    public static void calculateBill(String nume, double amount,int quantity, double pret) {

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
            stmt.setString(1, String.format(" A cumparat: %d produse", quantity));
            stmt.setString(1, String.format("Pret/bucata: %.2f", amount));
            stmt.setString(1, String.format("Total de plata: %.2f", pret));
            stmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Failed to insert log message", e);
        }

        try (FileWriter writer = new FileWriter("log.txt", false)) {
            String bill = String.format("----------BILL-------\n");
            String message = String.format("Clientul cu numele: %s\n A cumparat: %d produse\n Pret/bucata: %.2f\n Total de plata: %.2f\n", nume, quantity, amount, pret);
            writer.write(bill);
            writer.write(message);
            writer.write(System.lineSeparator());
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to write log message", e);
        }
    }
}

