//GUI for loan calculations
package GUI;

import Finances.NetWorth;
import Finances.RentvsBuy;
import Graphs.LineChart;
import Loans.AutoLoan;
import Loans.HomeLoan;
import Loans.Loan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;

public class LoanGUI extends JFrame {
    //GUI variables
     JComboBox comboBox;
     JTabbedPane mainLoanPane;
     JPanel mainPanel;
     JPanel homeLoanPanel;
     JPanel autoLoanPanel;
     JPanel personalPanel;
     JPanel homeContentPanel;
     JPanel homeOutputPanel;
     JTextField homeYearlyIncomeField;
     JTextField homeDownPaymentField;
     JTextField homeMortgageField;
     JTextField homeAprField;
     JComboBox homeLoanTermComboBox;
     JTextField homePriceField;
     JTextField homeTotalInterestField;
     JTextField homeTotalPaymentsField;
     JPanel homeLinePanel;
     JLabel homeYearlyIncomeLabel;
     JLabel homeDownPaymentLabel;
     JLabel homeMortgageLabel;
     JLabel homeAprLabel;
     JLabel HomeLoanTermLabel;
     JLabel homePriceLabel;
     JLabel homeTotalInterestLabel;
     JLabel homeTotalPaymentsLabel;
     JTextField homeLoanAmountField;
     JLabel homeLoanAmountLabel;
     JButton homeCalculateButton;
     JPanel autoContentPanel;
     JPanel autoOutputPanel;
     JLabel vehiclePriceLabel;
     JTextField vehiclePriceField;
     JTextField vehicleDownPaymentField;
     JLabel vehicleDownPaymentLabel;
     JLabel vehicleTradeLabel;
     JTextField vehicleTradeField;
     JLabel vehicleOwedLabel;
     JTextField vehicleOwedField;
     JLabel vehicleAprLabel;
     JTextField vehicleAprField;
     JLabel vehicleLoanTermLabel;
     JTextField vehicleLoanTermField;
     JButton vehicleCalculate;
     JPanel vehicleLinePanel;
     JLabel vehiclePaymentLabel;
     JTextField vehiclePaymentField;
     JLabel vehicleLoanAmountLabel;
     JTextField vehicleLoanAmountField;
     JLabel vehicleTotalInterestLabel;
     JTextField vehicleTotalInterestField;
     JLabel vehicleTotalPaymentsLabel;
     JTextField vehicleTotalPaymentsField;
     JPanel personalContentPanel;
     JPanel personalOutputPanel;
     JPanel personalLinePanel;
     JLabel personalPaymentLabel;
     JTextField personalPaymentField;
     JTextField personalLoanAmountField;
     JLabel personalTotalInterestLabel;
     JTextField personalTotalInterestField;
     JLabel personalTotalPaymentsLabel;
     JTextField personalTotalPaymentsField;
     JLabel personalLoanAmountLabel;
     JLabel personalAprLabel;
     JTextField personalAprField;
     JLabel personalLoanTermLabel;
     JTextField personalLoanTermField;
     JButton personalCalculateButton;
    //Class variables
    AutoLoan auto;
    HomeLoan home;
    Loan personal;
    //Placeholders for creating line chart
    static int[] paymentNumber1 = new int[]{1};
    static double[] principalPayment1 = new double[]{1};
    static double[] interestPayment1 = new double[]{1};
    static int[] paymentNumber2 = new int[]{1};
    static double[] principalPayment2 = new double[]{1};
    static double[] interestPayment2 = new double[]{1};
    static int[] paymentNumber3 = new int[]{1};
    static double[] principalPayment3 = new double[]{1};
    static double[] interestPayment3 = new double[]{1};
    //Placeholder for output calculations
    double[][] amortization;
    int[] mon;
    double[] princ;
    double[] inter;

    public LoanGUI(AutoLoan auto, HomeLoan home, Loan personal) {
        //GUI set up
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        this.auto = auto;
        this.home = home;
        this.personal = personal;

        setContentPane(mainPanel);
        setVisible(true);
        pack();
        //Changes the default tab opened when opening the GUI
        if (personal.getSelectedIndex() == 1) {
            mainLoanPane.setSelectedIndex(2);
        } else if (home.getSelectedIndex() == 1) {
            mainLoanPane.setSelectedIndex(1);
        } else {
            mainLoanPane.setSelectedIndex(0);
        }
        //Set auto variables
        vehiclePriceField.setText(String.valueOf(auto.getVehiclePrice()));
        vehicleDownPaymentField.setText(String.valueOf(auto.getDownPayment()));
        vehicleTradeField.setText(String.valueOf(auto.getTradInValue()));
        vehicleOwedField.setText(String.valueOf(auto.getAmountOwed()));
        vehicleAprField.setText(String.valueOf(auto.getInterestRate()));
        vehicleLoanTermField.setText(String.valueOf(auto.getLoanTerm()));
        //auto calculated variables
        vehiclePaymentField.setText(decimalFormat.format(auto.getMonthlyPayment()));
        vehicleLoanAmountField.setText(decimalFormat.format(auto.getLoanAmount()));
        vehicleTotalInterestField.setText(decimalFormat.format(auto.getTotalInterest()));
        vehicleTotalPaymentsField.setText(decimalFormat.format(auto.getTotalPayment()));

        //Set home variables
        homeYearlyIncomeField.setText(String.valueOf(home.getYearlyIncome()));
        homeDownPaymentField.setText(String.valueOf(home.getDownPayment()));
        homeMortgageField.setText(String.valueOf(home.getMonthlyPayment()));
        homeAprField.setText(String.valueOf(home.getInterestRate()));
        if (home.getLoanTerm() == 15) {
            homeLoanTermComboBox.removeAllItems();
            homeLoanTermComboBox.addItem("15");
            homeLoanTermComboBox.addItem("30");
        } else {
            homeLoanTermComboBox.removeAllItems();
            homeLoanTermComboBox.addItem("30");
            homeLoanTermComboBox.addItem("15");
        }
        homePriceField.setText(decimalFormat.format(home.getHousePrice()));
        homeTotalPaymentsField.setText(decimalFormat.format(home.getTotalPayment()));
        homeLoanAmountField.setText(decimalFormat.format(home.getLoanAmount()));
        homeTotalInterestField.setText(decimalFormat.format(home.getTotalInterest()));

        //Set personal variables
        personalLoanAmountField.setText(String.valueOf(personal.getLoanAmount()));
        personalAprField.setText(String.valueOf(personal.getInterestRate()));
        personalLoanTermField.setText(String.valueOf(personal.getLoanTerm()));
        personalPaymentField.setText(decimalFormat.format(personal.getMonthlyPayment()));
        personalTotalInterestField.setText(decimalFormat.format(personal.getTotalInterest()));
        personalTotalPaymentsField.setText(decimalFormat.format(personal.getTotalPayment()));


        //Auto loan calculate button
        vehicleCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Set GUI variables to AutoLoan class
                auto.setVehiclePrice(Double.parseDouble(vehiclePriceField.getText()));
                auto.setDownPayment(Double.parseDouble(vehicleDownPaymentField.getText()));
                auto.setTradInValue(Double.parseDouble(vehicleTradeField.getText()));
                auto.setAmountOwed(Double.parseDouble(vehicleOwedField.getText()));
                auto.setInterestRate(Double.parseDouble(vehicleAprField.getText()));
                auto.setLoanTerm(Integer.parseInt(vehicleLoanTermField.getText()));
                auto.setLoanAmount(auto.getCarLoanAmount(auto.getVehiclePrice(), auto.getTradInValue(), auto.getDownPayment(), auto.getAmountOwed()));
                double monthlyPayment = auto.calculateMonthlyPayment(auto.getLoanTerm(),
                        auto.getInterestRate(), auto.getLoanAmount());
                auto.setMonthlyPayment(monthlyPayment);

                //Calculate amortization
                amortization = auto.calculateAmortization(auto.getLoanAmount(), auto.getInterestRate(), auto.getLoanTerm(), monthlyPayment, "Months");
                //Break down calculation into single arrays
                mon = new int[amortization.length];
                princ = new double[amortization.length];
                inter = new double[amortization.length];

                double interTotal = 0;

                for (int i = 0; i < amortization.length; i++) {
                    mon[i] = (int) amortization[i][0];
                    princ[i] = amortization[i][1];
                    inter[i] = amortization[i][2];

                    if (i == 0) {
                        interTotal = inter[i];
                    } else {
                        interTotal += inter[i];
                    }
                }
                auto.setTotalInterest(interTotal);
                auto.setTotalPayment(auto.getLoanAmount() + interTotal);
                //Set variables to be used by line chart
                paymentNumber1 = mon;
                principalPayment1 = princ;
                interestPayment1 = inter;
                home.setSelectedIndex(0);
                personal.setSelectedIndex(0);
                //Open new GUI with updated form
                close();
                new LoanGUI(auto, home, personal);
            }
        });
        //Home loan calculate button
        homeCalculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Set variables to HomeLoan class
                home.setYearlyIncome(Double.parseDouble(homeYearlyIncomeField.getText()));
                home.setDownPayment(Double.parseDouble(homeDownPaymentField.getText()));
                home.setMonthlyPayment(Double.parseDouble(homeMortgageField.getText()));
                home.setInterestRate(Double.parseDouble(homeAprField.getText()));
                if (homeLoanTermComboBox.getSelectedItem() == "15") {
                    home.setLoanTerm(15);
                } else {
                    home.setLoanTerm(30);
                }
                home.setHousePrice(home.calculateAffordability(home.getYearlyIncome(), home.getLoanTerm(), home.getInterestRate(),
                        home.getMonthlyPayment(), home.getDownPayment()));

                home.setLoanAmount(home.getHousePrice() - home.getDownPayment());

                //Amortization calculation
                amortization = home.calculateAmortization(home.getLoanAmount(), home.getInterestRate(), home.getLoanTerm(),
                        home.getMonthlyPayment(), "Years");
                //Breakdown of multidimensional array
                mon = new int[amortization.length/12];
                princ = new double[amortization.length/12];
                inter = new double[amortization.length/12];

                double interTotal = 0;
                double[] interHolder = new double[amortization.length]; //placeholder for rolling total
                //Convert amortization months to years
                for (int i = 0; i < amortization.length; i++) {
                    if (i % 12 == 0){
                        mon[i/12] = (int) amortization[i][0] /12 +1;
                        princ[i/12] = amortization[i][1];
                        inter[i/12] = amortization[i][2];
                    }
                    interHolder[i] = amortization[i][2];
                    if (i == 0) {
                        interTotal = interHolder[i];
                    } else {
                        interTotal += interHolder[i];
                    }
                }
                home.setTotalPayment(home.getHousePrice() + interTotal);
                home.setTotalInterest(interTotal);
                //Line chart variables
                paymentNumber2 = mon;
                principalPayment2 = princ;
                interestPayment2 = inter;

                home.setSelectedIndex(1);
                personal.setSelectedIndex(0);
                //Open new GUI with updated form
                close();
                new LoanGUI(auto, home, personal);
            }
        });
        //Personal loan calculate button
        personalCalculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Set variables to base Loan class
                personal.setLoanAmount(Double.parseDouble(personalLoanAmountField.getText()));
                personal.setInterestRate(Double.parseDouble(personalAprField.getText()));
                personal.setLoanTerm(Integer.parseInt(personalLoanTermField.getText()));
                double monthly = personal.calculateMonthlyPayment(personal.getLoanTerm(), personal.getInterestRate(), personal.getLoanAmount());
                personal.setMonthlyPayment(monthly);

                //Amortization calculation
                amortization = personal.calculateAmortization(personal.getLoanAmount(), personal.getInterestRate(), personal.getLoanTerm(), personal.getMonthlyPayment(), "Months");
                //Breakdown of array
                mon = new int[amortization.length];
                princ = new double[amortization.length];
                inter = new double[amortization.length];

                double interTotal = 0;

                for (int i = 0; i < amortization.length; i++) {
                    mon[i] = (int) amortization[i][0];
                    princ[i] = amortization[i][1];
                    inter[i] = amortization[i][2];

                    if (i == 0) {
                        interTotal = inter[i];
                    } else {
                        interTotal += inter[i];
                    }
                }
                personal.setTotalPayment(personal.getLoanAmount() + interTotal);
                personal.setTotalInterest(interTotal);
                //Line chart variables
                paymentNumber3 = mon;
                principalPayment3 = princ;
                interestPayment3 = inter;

                home.setSelectedIndex(0);
                personal.setSelectedIndex(1);
                //Open new updated GUI
                close();
                new LoanGUI(auto, home, personal);

            }
        });
        //Switches between GUI pages
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox.getSelectedItem() == "Budget Worksheet") {
                    close();
                    ;
                    new BudgetGUI();
                } else if (comboBox.getSelectedItem() == "Rent vs Buy") {
                    close();
                    new RentvsBuyGUI(new RentvsBuy());
                } else {
                    close();
                    new NetWorthGUI(new NetWorth());
                }
            }
        });
    }
    //Method to close current window
    public void close() {
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    //Custom line chart creation
     private void createUIComponents() {
        LineChart autoLine = new LineChart("Loan Principal", "Interest", paymentNumber1,
                "Month Number", principalPayment1, interestPayment1, "Cost");
        vehicleLinePanel = autoLine.createChartPanel("Loan Amortization", "Principal", "Interest", paymentNumber1, principalPayment1, interestPayment1);

        LineChart homeLine = new LineChart("Principal", "Interest", paymentNumber2,
                "Month Number", principalPayment2, interestPayment2, "Cost");
        homeLinePanel = autoLine.createChartPanel("Loan Amortization", "Principal", "Interest", paymentNumber2, principalPayment2, interestPayment2);

        LineChart personalLine = new LineChart("Principal", "Interest", paymentNumber3,
                "Month Number", principalPayment3, interestPayment3, "Cost");
        personalLinePanel = autoLine.createChartPanel("Loan Amortization", "Principal", "Interest", paymentNumber3, principalPayment3, interestPayment3);
    }
}


