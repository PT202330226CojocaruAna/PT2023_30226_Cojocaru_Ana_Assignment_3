package presentation;

import businessLayer.ClientBLL;
import businessLayer.ProductBLL;
import model.Client;
import model.Product;
import start.Reflection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ProductFrame extends JFrame {

    private JButton add, edit, delete, all, back;
    private JButton bDel;
    private JTextField codProdusDelete, name, price, cantitate;
    private JTextField codProdusNew, nameNew, priceNew, cantitateNew;
    private JTextArea status;

    /**
     * creeaza fereastra pentru produse, adaugare, eliminare, editare, vizualizare
     */
    public ProductFrame() {
        super("PRODUCTS");
            add = new JButton("ADD NEW PRODUCT");
            edit = new JButton("EDIT PRODUCT");
            delete = new JButton("DELETE PRODUCT");
            all = new JButton("ALL PRODUCTS");
            back = new JButton("back");
            bDel = new JButton("REMOVE");

            codProdusDelete = new JTextField(20);
            name = new JTextField(20);
            price = new JTextField(20);
            cantitate = new JTextField(20);
            status = new JTextArea(5, 20);

            codProdusNew = new JTextField(20);
            nameNew = new JTextField(20);
            priceNew = new JTextField(20);
            cantitateNew = new JTextField(20);


            JLabel idLabel = new JLabel("   Cod Produs:");
            JLabel nameLabel = new JLabel("   Nume:");
            JLabel priceLabel = new JLabel("   Pret:");
            JLabel cantLabel = new JLabel("   Cantitate:");
            JLabel statusLabel = new JLabel("    Status:");

            JPanel buttonPanel = new JPanel(new GridLayout(2, 2));
            buttonPanel.add(add);
            buttonPanel.add(edit);
            buttonPanel.add(delete);
            buttonPanel.add(all);

            Dimension buttonSize = new Dimension(300, 50);
            add.setPreferredSize(buttonSize);
            edit.setPreferredSize(buttonSize);
            delete.setPreferredSize(buttonSize);
            all.setPreferredSize(buttonSize);

            add.setBackground(Color.PINK);
            edit.setBackground(Color.PINK);
            delete.setBackground(Color.PINK);
            all.setBackground(Color.PINK);

            status.setEditable(false);
            ProductBLL productBLL = new ProductBLL();

            JPanel fieldPanel = new JPanel(new GridLayout(2, 2));
            /*fieldPanel.add(idLabel);
            fieldPanel.add(codProdus);*/
          /*  fieldPanel.add(nameLabel);
            fieldPanel.add(name);
            fieldPanel.add(priceLabel);
            fieldPanel.add(price);
            fieldPanel.add(cantLabel);
            fieldPanel.add(cantitate);*/

            JPanel statusPanel = new JPanel();
            statusPanel.add(statusLabel);
            statusPanel.add(status);

            JPanel backPanel = new JPanel();
            statusPanel.add(back);
            back.setBackground(Color.PINK);

            back.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e2) {
                    dispose();
                }
            });
            add.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource() == add) {
                        JFrame frameP = new JFrame("ADD PRODUCT");
                        JPanel fieldsssP = new JPanel(new GridLayout(6, 2,5,5));
                        JPanel butonP = new JPanel(new FlowLayout());

                        fieldsssP.add(nameLabel);
                        fieldsssP.add(name);
                        fieldsssP.add(priceLabel);
                        fieldsssP.add(price);
                        fieldsssP.add(cantLabel);
                        fieldsssP.add(cantitate);
                        JButton b = new JButton("ADD");
                        butonP.add(b);
                        //butonP.add(back);
                        b.setBackground(Color.PINK);
                        back.setBackground(Color.PINK);

                        back.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e2) {
                                frameP.dispose();
                            }
                        });

                        Dimension buttonSize2 = new Dimension(200, 50);
                        b.setPreferredSize(buttonSize2);
                        b.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try{
                                    Product cl = new Product(name.getText(), Integer.parseInt(price.getText()), Integer.parseInt(cantitate.getText()));
                                    productBLL.insertProduct(cl);
                                    status.setText("PRODUS INSERAT");
                                    //id.setText("");
                                    name.setText("");
                                    price.setText("");
                                    cantitate.setText("");
                                    frameP.dispose();
                                }catch(IllegalArgumentException e9){
                                    status.setText("PRODUS NEINSERAT");
                                    frameP.dispose();
                                }
                            }
                        });


                        JPanel mainPanel = new JPanel(new BorderLayout());
                        mainPanel.add(fieldsssP, BorderLayout.CENTER);
                        mainPanel.add(butonP, BorderLayout.SOUTH);
                        frameP.add(mainPanel);
                        // frame.setLayout(new GridLayout(6,2));
           /*         frame.add(id);
                    frame.add(name);
                    frame.add(address);
                    frame.add(email);
                    frame.add(age);*/
                        //frame.add(b);
                        frameP.setSize(500, 400);
                        frameP.setLocationRelativeTo(null);
                        frameP.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        //frame.setResizable(false);
                        frameP.setVisible(true);
                    }
                }

       /*             Client cl = new Client(Integer.parseInt(id.getText()), name.getText(), address.getText(), email.getText(), Integer.parseInt(age.getText()));
                    clientBLL.insertClient(cl);
                }*/
            });
            edit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource() == edit) {
                        JFrame frameEdit = new JFrame("EDIT PRODUCT");
                        JPanel fieldsEdit = new JPanel(new GridLayout(6, 2,5,5));
                        JPanel butonEdit = new JPanel(new FlowLayout());

                        fieldsEdit.add(idLabel);
                        fieldsEdit.add(codProdusNew);
                        fieldsEdit.add(nameNew);
                        fieldsEdit.add(nameLabel);
                        fieldsEdit.add(nameNew);
                        fieldsEdit.add(priceLabel);
                        fieldsEdit.add(priceNew);
                        fieldsEdit.add(cantLabel);
                        fieldsEdit.add(cantitateNew);
                        JButton b = new JButton("EDIT");
                        butonEdit.add(b);
                       // butonEdit.add(back);
                        b.setBackground(Color.PINK);
                        back.setBackground(Color.PINK);

                        back.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e2) {
                                frameEdit.dispose();
                            }
                        });

                        Dimension buttonSize2 = new Dimension(200, 50);
                        b.setPreferredSize(buttonSize2);
                        b.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try{
                                    ProductBLL produsBLL = new ProductBLL();
                                    Product pr = new Product(Integer.parseInt(codProdusNew.getText()),nameNew.getText(), Double.parseDouble(priceNew.getText()), Integer.parseInt(cantitateNew.getText()));
                                    produsBLL.updateProductByCod(pr, pr.getCodProdus());
                                    status.setText("PRODUS EDITAT");
                                    //id.setText("");
                                    name.setText("");
                                    price.setText("");
                                    cantitate.setText("");
                                    frameEdit.dispose();
                                }catch(IllegalArgumentException e9){
                                    status.setText("PRODUS NEEDITAT");
                                    frameEdit.dispose();
                                }
                            }
                        });


                        JPanel mainPanel = new JPanel(new BorderLayout());
                        mainPanel.add(fieldsEdit, BorderLayout.CENTER);
                        mainPanel.add(butonEdit, BorderLayout.SOUTH);
                        frameEdit.add(mainPanel);
                        frameEdit.setSize(500, 400);
                        frameEdit.setLocationRelativeTo(null);
                        frameEdit.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        frameEdit.setVisible(true);
                    }
                }
            });
            delete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == delete) {
                        JFrame frameDelete = new JFrame("REMOVE PRODUCT");
                        JPanel fieldDelete = new JPanel(new GridLayout(6, 2, 5, 5));
                        JPanel butonDelete = new JPanel(new FlowLayout());

                        JTextField idDelete1 = new JTextField(20);

                        fieldDelete.add(idLabel);
                        fieldDelete.add(idDelete1);

                        JButton b = new JButton("REMOVE");
                        butonDelete.add(bDel);
                        bDel.setBackground(Color.PINK);
                        bDel.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try {
                                    ProductBLL bl = new ProductBLL();
                                    System.out.println(Integer.parseInt(idDelete1.getText()));
                                    bl.deleteProduct(Integer.parseInt(idDelete1.getText()));
                                    status.setText("PRODUS STERS");
                                    frameDelete.dispose();
                                } catch (NumberFormatException e9) {
                                    status.setText("STERGERE ESUATA");
                                    frameDelete.dispose();
                                }
                            }
                        });


                        JPanel mainPanel = new JPanel(new BorderLayout());
                        mainPanel.add(fieldDelete, BorderLayout.CENTER);
                        mainPanel.add(butonDelete, BorderLayout.SOUTH);
                        frameDelete.add(mainPanel);

                        frameDelete.setSize(500, 400);
                        frameDelete.setLocationRelativeTo(null);
                        frameDelete.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        //frame.setResizable(false);
                        frameDelete.setVisible(true);
                    }
                }

            });
            all.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e2) {

                    JFrame frame = new JFrame("View products");
                    ProductBLL productBLL = new ProductBLL();
                    java.util.List<Product> cls = productBLL.findAllProducts();
                    List<String> fieldsList = Reflection.getFields(cls.get(0));
                    String[] fields = new String[fieldsList.size()];
                    int i = 0;
                    for (String field : fieldsList) {
                        fields[i++] = field;
                    }

                    Object[][] data = new Object[cls.size()][fieldsList.size()];
                    i = 0;
                    for (Product prod : cls) {
                        //ArrayList<Object> obj = Reflection.getValues(prod);
                        List<Object> obj = Reflection.getValues(prod);
                        int j = 0;
                        for (Object o : obj) {
                            data[i][j++] = o;
                        }
                        i++;
                    }
                    JTable table = new JTable(data, fields);
                    JScrollPane scrollPane = new JScrollPane(table);
                    frame.add(scrollPane);

                    JPanel backPanel = new JPanel();
                    statusPanel.add(back);
                    back.setBackground(Color.PINK);
                    //  frame.add(backPanel);

                    Dimension buttonSize = new Dimension(25, 25);
                    back.setPreferredSize(buttonSize);
                    // frame.add(back);

                    frame.setVisible(true);
                    frame.setSize(800, 200);
                    frame.setLocationRelativeTo(null);
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }
            });

            JPanel mainPanel = new JPanel(new BorderLayout());
            mainPanel.add(buttonPanel, BorderLayout.NORTH);
            mainPanel.add(fieldPanel, BorderLayout.CENTER);
            mainPanel.add(statusPanel, BorderLayout.SOUTH);
            mainPanel.add(backPanel, BorderLayout.WEST);

            add(mainPanel);

            setSize(500, 400);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);
        }
    }
