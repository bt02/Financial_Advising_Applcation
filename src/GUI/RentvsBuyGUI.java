package GUI;

import Finances.NetWorth;
import Finances.RentvsBuy;
import Graphs.LineChart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RentvsBuyGUI extends JFrame{
    private JComboBox comboBox;
    private JPanel contentPanel;
    private JPanel mainPanel;
    private JPanel outputPanel;
    private JTextField housePriceField;
    private JComboBox loanTermComboBox;
    private JTextField rentField;
    private JTextField aprField;
    private JLabel housePriceLabel;
    private JLabel downPaymentLabel;
    private JTextField downPaymentField;
    private JLabel aprLabel;
    private JLabel loanTermLabel;
    private JLabel rentLabel;
    private JComboBox yearComboBox;
    private JTextField totalBuyField;
    private JTextField totalRentField;
    private JLabel yearLabel;
    private JLabel totalBuyLabel;
    private JLabel totalRentLabel;
    private JTextField totalGainField;
    private JPanel linePanel;
    private JLabel totalGainLabel;
    private JButton calculateButton;


    static double[] rentTotal = new double[]{1};  //Series 1 y values
    static double[] buyTotal = new double[]{1}; //Series 2 y values
    static int[] x = new int[]{1}; //Shared x values


    RentvsBuy RvB;
    public RentvsBuyGUI(RentvsBuy RvB){
        this.RvB = RvB;
        setVisible(true);
        setContentPane(mainPanel);
        pack();

        housePriceField.setText(String.valueOf(RvB.gethousePrice()));
        downPaymentField.setText(String.valueOf(RvB.getDownPayment()));
        aprField.setText(String.valueOf(RvB.getApr()));
        rentField.setText(String.valueOf(RvB.getRent()));

        if(RvB.getLoanTerm() == 15){
            loanTermComboBox.removeAllItems();
            loanTermComboBox.addItem("15");
            loanTermComboBox.addItem("30");

        }else {
            loanTermComboBox.removeAllItems();
            loanTermComboBox.addItem("30");
            loanTermComboBox.addItem("15");
        }

        yearComboBox.addItem("    ");
        for (int i = 1; i < 31; i++) {
            yearComboBox.addItem(i);
        }

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(comboBox.getSelectedItem() == "Budget Worksheet"){
                    close();;
                    new BudgetGUI();
                }
                if (comboBox.getSelectedItem() == "Net Worth") {
                    close();
                    new NetWorthGUI(new NetWorth());
                }
            }
        });
        loanTermComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(loanTermComboBox.getSelectedItem() == "30"){
                    yearComboBox.removeAllItems();
                    yearComboBox.addItem("    ");
                    for (int i = 1; i <31; i++) {
                        yearComboBox.addItem(i);

                    }
                }else{
                    yearComboBox.removeAllItems();
                    yearComboBox.addItem("    ");
                    for (int i = 1; i < 16; i++) {
                        yearComboBox.addItem(i);
                    }
                }


            }
        });

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //NetWorthGUI.this.netWorth.setCurrentAge(Integer.parseInt(ageField.getText()));
                RentvsBuyGUI.this.RvB.sethousePrice(Double.parseDouble(housePriceField.getText()));
                RentvsBuyGUI.this.RvB.setDownPayment(Double.parseDouble(downPaymentField.getText()));
                RentvsBuyGUI.this.RvB.setApr(Double.parseDouble(aprField.getText()));
                RentvsBuyGUI.this.RvB.setLoanTerm(Integer.parseInt((String) loanTermComboBox.getSelectedItem()));
                RentvsBuyGUI.this.RvB.setRent(Double.parseDouble(rentField.getText()));

                //Calculations
                RentvsBuyGUI.this.RvB.setMonthlyMortgage(RvB.calculateMonthlyPayment(RvB.getLoanAmount(), RvB.getApr(), RvB.getLoanTerm()));
                RentvsBuyGUI.this.RvB.setLoanAmount(RvB.gethousePrice() - RvB.getDownPayment());
                RentvsBuyGUI.this.RvB.setCompoundInterestMoney(RvB.calculateCompoundInterest(RvB.getDownPayment(), 6, RvB.getLoanTerm(),12));
                RentvsBuyGUI.this.RvB.setCompoundInterestHouse(RvB.calculateCompoundInterest(RvB.getLoanAmount(), 3, RvB.getLoanTerm()));
                RentvsBuyGUI.this.RvB.setAmortization(RvB.calculateAnnualAmortization(RvB.getLoanAmount(), RvB.getApr(), RvB.getLoanTerm(), RvB.gethousePrice()));


                x = new int[RentvsBuyGUI.this.RvB.getLoanTerm()];
                for (int i = 0; i < x.length; i++) {
                    x[i] = i+1;
                }
                rentTotal = RentvsBuyGUI.this.RvB.rentCost(RvB.getCompoundInterestMoney(), RvB.getLoanTerm(), RvB.getDownPayment(), RvB.getRent());
                buyTotal = RentvsBuyGUI.this.RvB.houseCost(RvB.getMonthlyMortgage(), RvB.getDownPayment(), RvB.getLoanAmount(),
                        RvB.getLoanTerm(), 3,RvB.gethousePrice(), RvB.getAmortization());

                close();
                new RentvsBuyGUI(RentvsBuyGUI.this.RvB);
            }
        });
        yearComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int year = (int) yearComboBox.getSelectedItem();
                double b =(buyTotal[year-1]);
                double r = (rentTotal[year-1]);
                totalBuyField.setText(String.valueOf(b));
                totalRentField.setText(String.valueOf(r));

                if(r <= b){
                    totalGainLabel.setText("Rent Gain");
                    totalGainField.setText(String.valueOf(b-r));
                }else {
                    totalGainLabel.setText("Buy Gain");
                    totalGainField.setText(String.valueOf(r-b));
                }
            }
        });
    }

    public void close(){
        WindowEvent closeWindow = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }

    private void createUIComponents() {
        LineChart line = new LineChart("Rent", "Buy", x, x, "Years", rentTotal, buyTotal, "Cost");
        linePanel = line.createChartPanel("Rent vs Buy", "Rent", "Buy", x,x, rentTotal, buyTotal);

    }

    public static void main(String[] args) {
        RentvsBuyGUI r = new RentvsBuyGUI(new RentvsBuy());



    }
}

