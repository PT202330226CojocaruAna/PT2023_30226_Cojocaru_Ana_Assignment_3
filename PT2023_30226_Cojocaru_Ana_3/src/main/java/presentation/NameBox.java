package presentation;

import businessLayer.ClientBLL;
import model.Client;

import javax.swing.*;
import java.util.List;

public class NameBox extends JPanel{
    private JComboBox nameLabel;
    private JTextField nameField;

    public NameBox() {

        ClientBLL clientBLL1 = new ClientBLL();
        List<Client> cl1 = clientBLL1.findAllClients();
        String[] names = new String[cl1.size()];
        int i = 0;
        for(Client cl: cl1){
            names[i++] = cl.getName();
        }

        nameLabel= new JComboBox(names);
        nameField = new JTextField(20);

        add(nameLabel);
        add(nameField);
    }

    public String getName() {
        return nameField.getText();
    }
}
