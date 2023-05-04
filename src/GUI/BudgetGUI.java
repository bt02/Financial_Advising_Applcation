package GUI;

import Finances.Budget;

import javax.swing.*;
import java.awt.event.*;

public class BudgetGUI extends JFrame {

    private JTextField rentField;
    private JTextField diningField;
    private JPanel mainPanel;
    private JLabel rent;
    private JLabel dining;
    private JTextField totalField;
    private JLabel total;
    private JButton submitButton;

    public BudgetGUI(){
        Budget budget = new Budget();
        setVisible(true);
        setContentPane(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();


        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                budget.setDining(Double.parseDouble(diningField.getText()));
                budget.setRent(Double.parseDouble(rentField.getText()));
                totalField.setText(String.valueOf(budget.getNetSpend()));
            }
        });
    }

}
