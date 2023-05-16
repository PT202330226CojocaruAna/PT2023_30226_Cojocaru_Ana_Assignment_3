package presentation;

import businessLayer.ClientBLL;
import model.Client;
import start.Reflection;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
/**
 *
 */
public class ClientFrame extends JFrame {

    private JButton add,edit,delete,all,back;
    private JTextField id,name,address,email,age;
    private JTextField idNew,nameNew,addressNew,emailNew,ageNew;
    private JTextArea status;

    /**
     * creeaza ClientFrame si executa operatiile aferente clientilor
     */
    public ClientFrame(){
        super("CLIENTS");

        add = new JButton("ADD NEW CLIENT");
        edit = new JButton("EDIT CLIENT");
        delete = new JButton("DELETE CLIENT");
        all = new JButton("ALL CLIENTS");
        back = new JButton("back");

        ClientBLL clientBLL = new ClientBLL();

        id = new JTextField(20);
        name = new JTextField(20);
        address = new JTextField(20);
        email = new JTextField(20);
        age = new JTextField(20);
        status = new JTextArea(5, 20);

        idNew = new JTextField(20);
        nameNew = new JTextField(20);
        addressNew = new JTextField(20);
        emailNew = new JTextField(20);
        ageNew = new JTextField(20);

        JLabel idLabel = new JLabel("    ID:");
        JLabel nameLabel = new JLabel("   Name:");
        JLabel addressLabel = new JLabel("   Address:");
        JLabel emailLabel = new JLabel("   Email:");
        JLabel ageLabel = new JLabel("    Age:");
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

        JPanel fieldPanel = new JPanel(new GridLayout(2, 2));
/*        fieldPanel.add(idLabel);
        fieldPanel.add(id);
        fieldPanel.add(nameLabel);
        fieldPanel.add(name);
        fieldPanel.add(addressLabel);
        fieldPanel.add(address);
        fieldPanel.add(emailLabel);
        fieldPanel.add(email);
        fieldPanel.add(ageLabel);
        fieldPanel.add(age);*/

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
                    JFrame frame = new JFrame("ADD CLIENT");
                    JPanel fieldsss = new JPanel(new GridLayout(6, 2,5,5));
                    JPanel buton = new JPanel(new FlowLayout());

                    /*JTextField t2 = new JTextField("Name: ");
                  //  t2.setFont(new Font("Consolas", Font.PLAIN, 20));
                    t2.setPreferredSize(new Dimension(400, 30));

                    JTextField t3 = new JTextField("Address: ");
                   // t3.setFont(new Font("Consolas", Font.PLAIN, 20));
                    t3.setPreferredSize(new Dimension(400, 30));

                    JTextField t4 = new JTextField("Email: ");
                   // t4.setFont(new Font("Consolas", Font.PLAIN, 20));
                    t4.setPreferredSize(new Dimension(400, 30));

                    JTextField t5 = new JTextField("Age: ");
                  //  t5.setFont(new Font("Consolas", Font.PLAIN, 20));
                    t5.setPreferredSize(new Dimension(400, 30));

                    JButton b = new JButton("ADD");
                   // b.setFont(new Font("Consolas", Font.PLAIN, 15));
                    b.setBackground(Color.PINK);
                    b.setPreferredSize(new Dimension(100, 40));
                    //b.setBorder(BorderFactory.createLineBorder(Color.black));*/

                   // fieldsss.add(idLabel);
                   // fieldsss.add(id);
                    fieldsss.add(nameLabel);
                    fieldsss.add(name);
                    fieldsss.add(addressLabel);
                    fieldsss.add(address);
                    fieldsss.add(emailLabel);
                    fieldsss.add(email);
                    fieldsss.add(ageLabel);
                    fieldsss.add(age);
                    JButton b = new JButton("ADD");
                    buton.add(b);
                    //buton.add(back);
                    b.setBackground(Color.PINK);
                    b.setBackground(Color.PINK);
                    back.setBackground(Color.PINK);

                    back.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e2) {
                            frame.dispose();
                        }
                    });

                    Dimension buttonSize2 = new Dimension(200, 50);
                    b.setPreferredSize(buttonSize2);
                    b.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                           try{
                               Client cl = new Client(name.getText(), address.getText(), email.getText(), Integer.parseInt(age.getText()));
                               clientBLL.insertClient(cl);
                               status.setText("CLIENT INSERAT");
                               //id.setText("");
                               name.setText("");
                               address.setText("");
                               email.setText("");
                               age.setText("");
                               frame.dispose();
                           }catch(IllegalArgumentException e9){
                               status.setText("CLIENT NEINSERAT");
                               frame.dispose();
                           }
                        }
                    });


                    JPanel mainPanel = new JPanel(new BorderLayout());
                    mainPanel.add(fieldsss, BorderLayout.CENTER);
                    mainPanel.add(buton, BorderLayout.SOUTH);
                    frame.add(mainPanel);
                   // frame.setLayout(new GridLayout(6,2));
           /*         frame.add(id);
                    frame.add(name);
                    frame.add(address);
                    frame.add(email);
                    frame.add(age);*/
                    //frame.add(b);
                    frame.setSize(500, 400);
                    frame.setLocationRelativeTo(null);
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    //frame.setResizable(false);
                    frame.setVisible(true);
                }
            }

       /*             Client cl = new Client(Integer.parseInt(id.getText()), name.getText(), address.getText(), email.getText(), Integer.parseInt(age.getText()));
                    clientBLL.insertClient(cl);
                }*/
        });
        edit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e2) {
                if(e2.getSource() == edit) {
                    JFrame frameEdit = new JFrame("EDIT CLIENT");
                    JPanel fieldEdit = new JPanel(new GridLayout(6, 2,5,5));
                    JPanel butonEdit = new JPanel(new FlowLayout());

                    fieldEdit.add(idLabel);
                    fieldEdit.add(idNew);
                    fieldEdit.add(nameLabel);
                    fieldEdit.add(nameNew);
                    fieldEdit.add(addressLabel);
                    fieldEdit.add(addressNew);
                    fieldEdit.add(emailLabel);
                    fieldEdit.add(emailNew);
                    fieldEdit.add(ageLabel);
                    fieldEdit.add(ageNew);
                    JButton bEdit = new JButton("EDIT");
                    butonEdit.add(bEdit);
                    //buton.add(back);
                    bEdit.setBackground(Color.PINK);
                    bEdit.setBackground(Color.PINK);
                    back.setBackground(Color.PINK);

                    Dimension buttonSize2 = new Dimension(200, 50);
                    bEdit.setPreferredSize(buttonSize2);
                    bEdit.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                ClientBLL clientBLL = new ClientBLL();
                                Client cl = new Client(Integer.parseInt(idNew.getText()),nameNew.getText(), addressNew.getText(), emailNew.getText(), Integer.parseInt(ageNew.getText()));
                                clientBLL.updateClientById(cl, cl.getId());
                                status.setText("CLIENT EDITAT");
                                //id.setText("");
                                nameNew.setText("");
                                addressNew.setText("");
                                emailNew.setText("");
                                ageNew.setText("");
                                frameEdit.dispose();
                            }catch(IllegalArgumentException e9){
                                status.setText("EDITARE ESUATA");
                                frameEdit.dispose();
                            }
                        }
                    });

                    JPanel mainPanelEdit = new JPanel(new BorderLayout());
                    mainPanelEdit.add(fieldEdit, BorderLayout.CENTER);
                    mainPanelEdit.add(butonEdit, BorderLayout.SOUTH);
                    frameEdit.add(mainPanelEdit);
                    frameEdit.setSize(500, 400);
                    frameEdit.setLocationRelativeTo(null);
                    frameEdit.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    //frame.setResizable(false);
                    frameEdit.setVisible(true);
                }
            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == delete) {
                    JFrame frameDelete = new JFrame("REMOVE CLIENT");
                    JPanel fieldDelete = new JPanel(new GridLayout(6, 2,5,5));
                    JPanel butonDelete = new JPanel(new FlowLayout());

                    JTextField idDelete = new JTextField(20);

                    fieldDelete.add(idLabel);
                    fieldDelete.add(idDelete);

                    JButton b = new JButton("REMOVE");
                    butonDelete.add(b);
                   // butonDelete.add(back);
                    b.setBackground(Color.PINK);

                    Dimension buttonSize2 = new Dimension(200, 50);
                    b.setPreferredSize(buttonSize2);

                    b.setBackground(Color.PINK);
                    back.setBackground(Color.PINK);

                    back.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e2) {
                            frameDelete.dispose();
                        }
                    });
                    b.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                //Client cl = new Client(name.getText(), address.getText(), email.getText(), Integer.parseInt(age.getText()));
                                clientBLL.deleteClientById(Integer.parseInt(idDelete.getText()));
                                status.setText("CLIENT STERS");
                                frameDelete.dispose();
                            }catch(NumberFormatException e9){
                                status.setText("STERGERE ESUATA");
                                frameDelete.dispose();
                            }
                        }
                    });


                    JPanel mainPanel = new JPanel(new BorderLayout());
                    mainPanel.add(fieldDelete, BorderLayout.CENTER);
                    mainPanel.add(butonDelete, BorderLayout.SOUTH);
                    frameDelete.add(mainPanel);
                    // frame.setLayout(new GridLayout(6,2));
           /*         frame.add(id);
                    frame.add(name);
                    frame.add(address);
                    frame.add(email);
                    frame.add(age);*/
                    //frame.add(b);
                    frameDelete.setSize(500, 400);
                    frameDelete.setLocationRelativeTo(null);
                    frameDelete.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    //frame.setResizable(false);
                    frameDelete.setVisible(true);
                }
            }

       /*             Client cl = new Client(Integer.parseInt(id.getText()), name.getText(), address.getText(), email.getText(), Integer.parseInt(age.getText()));
                    clientBLL.insertClient(cl);
                }*/
        });
        all.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e2) {

                JFrame frame = new JFrame("View clients");
                ClientBLL clientBLL = new ClientBLL();
                List<Client> cls = clientBLL.findAllClients();
                List<String> fieldsList = Reflection.getFields(cls.get(0));
                String[] fields = new String[fieldsList.size()];
                int i = 0;
                for (String field : fieldsList) {
                    //fields[++i] = field;
                    fields[i++] = field;
                }

                Object[][] data = new Object[cls.size()][fieldsList.size()];
                i = 0;
                for (Client client : cls) {
                    //ArrayList<Object> obj = Reflection.getValues(client);
                    List<Object> obj = Reflection.getValues(client);
                    int j = 0;
                    for (Object o : obj) {
                        data[i][j] = o;
                        j++;
                    }
                    i++;
                }
                JTable table = new JTable(data,fields);
                JScrollPane scrollPane = new JScrollPane(table);
                frame.add(scrollPane);

                JPanel backPanel = new JPanel();
                statusPanel.add(back);
                back.setBackground(Color.PINK);
              //  frame.add(backPanel);

                Dimension buttonSize = new Dimension(15, 15);
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
