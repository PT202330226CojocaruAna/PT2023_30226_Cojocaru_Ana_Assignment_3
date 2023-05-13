package presentation;

import businessLayer.ClientBLL;
import businessLayer.OrderBLL;
import businessLayer.ProductBLL;
import dataAccessLayer.ClientDAO;
import model.Client;
import model.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class OrderFrame extends JFrame{

    private JComboBox clientss, productt;
    private JTextField clientsText, productText;
    private JTextField qText, q;
    private JTextField status, statusText;
    private JButton validate;
    private JButton plasare;
    int quantity =0;
    List<String> lista = new ArrayList<String>();
    public OrderFrame(){
        super("ORDER");
        OrderBLL orderBLL = new OrderBLL();
        ClientBLL clientBLL = new ClientBLL();
        ProductBLL productBLL = new ProductBLL();
        ClientDAO clientDAO = new ClientDAO();
        validate = new JButton("VALIDARE");
        plasare = new JButton("CONFIRMARE");
        statusText = new JTextField("STATUS");
        String[] client222 = {"Client 1", "Client 2", "Client 3"};
        try {
            List<Client> clientList = clientBLL.findAllClients();
         //   List<client> clientList = clientDAO.findAll();
            System.out.println(clientList);
            String[] names = new String[clientList.size()];
            int i = 0;
            for(Client cl:clientList){
                names[i++] = cl.getName();
            }
            clientss = new JComboBox<>(names);
        }catch (NullPointerException | IllegalArgumentException e5) {
            clientss = new JComboBox<>(client222);
        }

       // NameBox nb1 = new NameBox();

        try {
            List<Product> productList = productBLL.findAllProducts();
            //   List<client> clientList = clientDAO.findAll();
            System.out.println(productList);
            String[] namess = new String[productList.size()];
            int i = 0;
            for(Product pr:productList){
                namess[i++] = pr.getName();
            }
            productt = new JComboBox<>(namess);
        }catch (NullPointerException | IllegalArgumentException e5) {
            productt = new JComboBox<>(client222);
        }

        clientsText = new JTextField("SELECT CLIENT");
        clientsText.setEditable(false);
        productText = new JTextField("SELECT PRODUCT");
        productText.setEditable(false);
        qText = new JTextField("INSERT QUANTITY");
        qText.setEditable(false);
        statusText.setEditable(false);
        JTextField q = new JTextField();
        JTextField status = new JTextField();

        JPanel buttonPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonPanel.add(clientsText);
        buttonPanel.add(clientss);
        clientss.setBackground(Color.PINK);
        buttonPanel.add(productText);
        buttonPanel.add(productt);
        productt.setBackground(Color.PINK);
        buttonPanel.add(qText);
        buttonPanel.add(q);
        validate.setBackground(Color.PINK);
        plasare.setBackground(Color.PINK);
        buttonPanel.add(statusText);
        statusText.setEditable(false);
        buttonPanel.add(status);
        status.setEditable(false);
        JPanel buttonPanel1 = new JPanel(new GridLayout(1, 1, 10, 10));
        buttonPanel.add(validate);
        buttonPanel.add(plasare);

        plasare.setEnabled(true);


        validate.addActionListener(new ActionListener() {
            /**
             * @param e1 the event to be processed
             */
            public void actionPerformed(ActionEvent e1) {
                    if(e1.getSource() == validate) {

                        String produs = (String)productt.getSelectedItem(); // produs selectat
                        String clientSelectat = (String)clientss.getSelectedItem(); //client selectat
                        ProductBLL productBLL1 = new ProductBLL(); //random
                        Product product; // produs selectat
                        product = productBLL1.findByName(produs);
                        try{
                            quantity= Integer.parseInt(q.getText()); } // cantitate intorodusa de noi
                        catch(NumberFormatException e10) {}

                        System.out.println(product.getCantitate());
                        System.out.println(quantity);

                        if(product.getCantitate()< quantity){
                            status.setText("UNDER-STOCK. Introduceti alta cantitate");
                        }
                        else{
                            status.setText("VALID");
                            Product prod;
                            prod = productBLL1.findByName(produs);
                            int cod = prod.getCodProdus();
                            int cant = prod.getCantitate();
                            cant -= quantity;
                            prod.setCantitate(cant);
                            productBLL1.updateProductByCod(prod, cod);
                        }
                    }
            }
        });
        plasare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e2) {
                String produs = (String)productt.getSelectedItem(); // produs selectat
                String clientSelectat = (String)clientss.getSelectedItem(); //client selectat
                ProductBLL productBLL1 = new ProductBLL(); //random
                Product product; // produs selectat
                product = productBLL1.findByName(produs);
                try{
                    quantity= Integer.parseInt(q.getText()); } // cantitate intorodusa de noi
                catch(NumberFormatException e10) {}
                String i = clientSelectat;
               // Product pp = productBLL1.findByName(produs);
                double j = product.getPrice();
                double pretFinal = quantity*j;
                model.Bill.calculateBill(i, j,quantity,pretFinal);

                dispose();
            }
        });


/*
        Dimension buttonSize1 = new Dimension(20, 50);
        validate.setPreferredSize(buttonSize1);
        clientsText.setPreferredSize(buttonSize1);
        productText.setPreferredSize(buttonSize1);
        qText.setPreferredSize(buttonSize1);*/

        add(buttonPanel);
        //add(buttonPanel1);
        //add(panelNew);
        //add(buttonPanel2);

        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
