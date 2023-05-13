package presentation;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionListener;

/**
 *
 */
public class MainFrame extends JFrame {

    private JButton clientButton = new JButton("CLIENTS");
    private JButton productButton = new JButton("PRODUCTS");
    private JButton orderButton = new JButton("ORDERS");

    public MainFrame() {
        super("MainFrame");
        clientButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e1) {
                new ClientFrame();
            }
        });
        orderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e3) { new OrderFrame(); }
        });
        productButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e2) {
                new ProductFrame();
            }
        });

        JPanel buttonPanel =new JPanel(new GridLayout(3,3));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        clientButton.setBackground(Color.PINK);
        productButton.setBackground(Color.PINK);
        orderButton.setBackground(Color.PINK);
        buttonPanel.add(clientButton);
        buttonPanel.add(productButton);
        buttonPanel.add(orderButton);

        this.add(buttonPanel);
        setSize(600,400);
        this.setBackground(Color.CYAN);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
