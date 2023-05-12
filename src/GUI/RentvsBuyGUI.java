//GUI to display renting vs buying calculations
package GUI;

import Finances.NetWorth;
import Finances.RentvsBuy;
import Graphs.LineChart;
import Loans.AutoLoan;
import Loans.HomeLoan;
import Loans.Loan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class RentvsBuyGUI extends JFrame{
    //GUI variables
     JComboBox comboBox;
     JPanel contentPanel;
     JPanel mainPanel;
     JPanel outputPanel;
     JTextField housePriceField;
     JComboBox loanTermComboBox;
     JTextField rentField;
     JTextField aprField;
     JLabel housePriceLabel;
     JLabel downPaymentLabel;
     JTextField downPaymentField;
     JLabel aprLabel;
     JLabel loanTermLabel;
     JLabel rentLabel;
     JComboBox yearComboBox;
     JTextField totalBuyField;
     JTextField totalRentField;
     JLabel yearLabel;
     JLabel totalBuyLabel;
     JLabel totalRentLabel;
     JTextField totalGainField;
     JPanel linePanel;
     JLabel totalGainLabel;
     JButton calculateButton;
     //Line chart placeholders
    static double[] rentTotal = new double[]{1};  //Series 1 y values
    static double[] buyTotal = new double[]{1}; //Series 2 y values
    static int[] x = new int[]{1}; //Shared x values
    RentvsBuy RvB;
    public RentvsBuyGUI(RentvsBuy RvB){
        //GUI set up
        this.RvB = RvB;
        setVisible(true);
        setContentPane(mainPanel);
        pack();
        //Set GUI fields
        housePriceField.setText(String.valueOf(RvB.getPurchasePrice()));
        downPaymentField.setText(String.valueOf(RvB.getDownPayment()));
        aprField.setText(String.valueOf(RvB.getApr()));
        rentField.setText(String.valueOf(RvB.getRent()));

        if(RvB.getLoanTerm() == 15){
            loanTermComboBox.removeAllItems();
            loanTermComboBox.addItem("15");
            loanTermComboBox.addItem("30");

            yearComboBox.addItem("    ");
            for (int i = 1; i < 16; i++) {
                yearComboBox.addItem(i);
            }

        }else {
            loanTermComboBox.removeAllItems();
            loanTermComboBox.addItem("30");
            loanTermComboBox.addItem("15");

            yearComboBox.addItem("    ");
            for (int i = 1; i < 31; i++) {
                yearComboBox.addItem(i);
            }

        }
        //Changes current GUI window
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(comboBox.getSelectedItem() == "Budget Worksheet"){
                    close();;
                    new BudgetGUI();
                }
                else if (comboBox.getSelectedItem() == "Net Worth") {
                    close();
                    new NetWorthGUI(new NetWorth());
                }else {
                    close();
                    new LoanGUI(new AutoLoan(), new HomeLoan(), new Loan());
                }
            }
        });
        //Get loan term from GUI combo-box
        loanTermComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (loanTermComboBox.getSelectedItem() == "15") {
                    RvB.setApr(15);
                } else {
                    RvB.setApr(30);
                }
            }
        });
        //Calculates renting vs buying
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Set RentvsBuy variables
                RvB.setPurchasePrice(Double.parseDouble(housePriceField.getText()));
                RvB.setDownPayment(Double.parseDouble(downPaymentField.getText()));
                RvB.setApr(Double.parseDouble(aprField.getText()));
                RvB.setLoanTerm(Integer.parseInt((String) loanTermComboBox.getSelectedItem()));
                RvB.setRent(Double.parseDouble(rentField.getText()));
                RvB.setLoanAmount(RvB.getPurchasePrice() - RvB.getDownPayment());

                x = new int[RvB.getLoanTerm()];
                for (int i = 0; i < x.length; i++) {
                    x[i] = i+1;
                }
                //Calculate totals
                rentTotal = RvB.calculateRentCosts(RvB.getLoanTerm(), RvB.getRent());
                buyTotal = RvB.calculateBuyCosts(RvB.getPurchasePrice(), RvB.getDownPayment(), RvB.getApr(), RvB.getLoanTerm());
                //Open new GUI with updated information
                close();
                new RentvsBuyGUI(RvB);
            }
        });
        //Calculates cost at specific year and compares
        yearComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Get index of array from the year selected
                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                int year = (int) yearComboBox.getSelectedItem();
                double b =(buyTotal[year-1]);
                double r = (rentTotal[year-1]);
                totalBuyField.setText(String.valueOf(Double.parseDouble(decimalFormat.format(b))));
                totalRentField.setText(String.valueOf(Double.parseDouble(decimalFormat.format(r))));
                //Compare values
                if(r <= b){
                    totalGainLabel.setText("Rent Gain");
                    totalGainField.setText(String.valueOf(Double.parseDouble(decimalFormat.format(b-r))));
                }else {
                    totalGainLabel.setText("Buy Gain");
                    totalGainField.setText(String.valueOf(Double.parseDouble(decimalFormat.format(r-b))));
                }
            }
        });
    }
    //Closes current window
    public void close(){
        WindowEvent closeWindow = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    //Create custom line chart
    private void createUIComponents() {
        LineChart line = new LineChart("Rent", "Buy", x, "Years", rentTotal, buyTotal, "Cost");
        linePanel = line.createChartPanel("Rent vs Buy", "Rent", "Buy", x, rentTotal, buyTotal);
    }
}

