package GUI;

import Finances.NetWorth;
import Finances.RentvsBuy;
import Graphs.LineChart;
import Loans.AutoLoan;
import Loans.HomeLoan;
import Loans.PersonalLoan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;

public class LoanGUI extends JFrame {
    private JComboBox comboBox;
    private JTabbedPane mainLoanPane;
    private JPanel mainPanel;
    private JPanel homeLoanPanel;
    private JPanel autoLoanPanel;
    private JPanel personalPanel;
    private JPanel homeContentPanel;
    private JPanel homeOutputPanel;
    private JTextField homeYearlyIncomeField;
    private JTextField homeDownPaymentField;
    private JTextField homeMortgageField;
    private JTextField homeAprField;
    private JComboBox homeLoanTermComboBox;
    private JTextField homePriceField;
    private JTextField homeTotalInterestField;
    private JTextField homeTotalPaymentsField;
    private JPanel homeLinePanel;
    private JLabel homeYearlyIncomeLabel;
    private JLabel homeDownPaymentLabel;
    private JLabel homeMortgageLabel;
    private JLabel homeAprLabel;
    private JLabel HomeLoanTermLabel;
    private JLabel homePriceLabel;
    private JLabel homeTotalInterestLabel;
    private JLabel homeTotalPaymentsLabel;
    private JTextField homeLoanAmountField;
    private JLabel homeLoanAmountLabel;
    private JButton homeCalculateButton;
    private JPanel autoContenPanel;
    private JPanel autoOutputPanel;
    private JLabel vehiclePriceLabel;
    private JTextField vehiclePriceField;
    private JTextField vehicleDownPaymentField;
    private JLabel vehicleDownPaymentLabel;
    private JLabel vehicleTradeLabel;
    private JTextField vehicleTradeField;
    private JLabel vehicleOwedLabe;
    private JTextField vehicleOwedField;
    private JLabel vehicleAprLabel;
    private JTextField vehicleAprField;
    private JLabel vehicleLoanTermLabel;
    private JTextField vehicleLoanTermField;
    private JButton vehicleCalculate;
    private JPanel vehicleLinePanel;
    private JLabel vehiclePaymentLabel;
    private JTextField vehiclePaymentField;
    private JLabel vehicleLoanAmountLabel;
    private JTextField vehicleLoanAmountField;
    private JLabel vehicleTotalInterstLabel;
    private JTextField vehicleTotalInterestField;
    private JLabel vehicleTotalPaymentsLabel;
    private JTextField vehicleTotalPaymentsField;
    private JPanel personalContentPanel;
    private JPanel personalOutputPanel;
    private JPanel personalLinePanel;
    private JLabel personalPaymentLabel;
    private JTextField personalPaymentField;
    private JTextField personalLaonAmountField;
    private JLabel personalTotalInterestLabel;
    private JTextField personalTotalInterstField;
    private JLabel personalTotalPaymentsLabel;
    private JTextField personalTotalPaymentsField;
    private JLabel personalLoanAmountLabel;
    private JTextField personalLoanAmountField;
    private JLabel personalAprLabel;
    private JTextField personalAprField;
    private JLabel personalLoanTermLabel;
    private JTextField personalLoanTermField;
    private JButton peronalCalculateButton;

    AutoLoan auto;
    HomeLoan home;
    PersonalLoan personal;
    static int[] paymentNumber1 = new int[]{1};
    static double[] principalPayment1 = new double[]{1};
    static double[] interestPayment1 = new double[]{1};
    static int[] paymentNumber2 = new int[]{1};
    static double[] principalPayment2 = new double[]{1};
    static double[] interestPayment2 = new double[]{1};
    static int[] paymentNumber3 = new int[]{1};
    static double[] principalPayment3 = new double[]{1};
    static double[] interestPayment3 = new double[]{1};
    double amortization[][];
    int[] pay;
    double[] princ;
    double[] inter;

    public LoanGUI(AutoLoan auto, HomeLoan home, PersonalLoan personal){
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        this.auto = auto;
        this.home = home;
        this.personal = personal;

        setContentPane(mainPanel);
        setVisible(true);
        pack();
        if (personal.getSelectedIndex() == 1){
            mainLoanPane.setSelectedIndex(2);
        } else if (home.getSelectedIndex() == 1) {
            mainLoanPane.setSelectedIndex(1);
        }else{
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
        homeMortgageField.setText(String.valueOf(home.getMonthlyMortgage()));
        homeAprField.setText(String.valueOf(home.getInterestRate()));
        if (home.getLoanTerm() == 15){
            homeLoanTermComboBox.removeAllItems();
            homeLoanTermComboBox.addItem("15");
            homeLoanTermComboBox.addItem("30");
        }else{
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
        personalTotalInterstField.setText(decimalFormat.format(personal.getTotalInterest()));
        personalTotalPaymentsField.setText(decimalFormat.format(personal.getTotalPayment()));


        //Auto loan calculate button
        vehicleCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                auto.setVehiclePrice(Double.parseDouble(vehiclePriceField.getText()));
                auto.setDownPayment(Double.parseDouble(vehicleDownPaymentField.getText()));
                auto.setTradInValue(Double.parseDouble(vehicleTradeField.getText()));
                auto.setAmountOwed(Double.parseDouble(vehicleOwedField.getText()));
                auto.setInterestRate(Double.parseDouble(vehicleAprField.getText()));
                auto.setLoanTerm(Integer.parseInt(vehicleLoanTermField.getText()));
                auto.setLoanAmount(auto.getCarLoanAmount(auto.getVehiclePrice(), auto.getTradInValue(),auto.getDownPayment(), auto.getAmountOwed()));
                double monthlyPayment = auto.calculateMonthlyPayment(auto.getLoanTerm(),
                                auto.getInterestRate(), auto.getLoanAmount());
                auto.setMonthlyPayment(monthlyPayment);

                amortization = auto.calculateAmortization(auto.getLoanAmount(),auto.getInterestRate(), auto.getLoanTerm(), monthlyPayment, "Months");

                pay  = new int[amortization.length];
                princ = new double[amortization.length];
                inter = new double[amortization.length];

                double interTotal = 0;

                for (int i = 0; i < amortization.length; i++) {
                    pay[i] = (int) amortization[i][0];
                    princ[i] = amortization[i][1];
                    inter[i] = amortization[i][2];

                    if (i==0){
                        interTotal = inter[i];
                    }else{
                        interTotal += inter[i];
                    }
                }
                auto.setTotalInterest(interTotal);
                auto.setTotalPayment(auto.getLoanAmount() + interTotal);

                paymentNumber1 = pay;
                principalPayment1 = princ;
                interestPayment1 = inter;
                home.setSelectedIndex(0);
                personal.setSelectedIndex(0);
                close();
                new LoanGUI(LoanGUI.this.auto, LoanGUI.this.home, LoanGUI.this.personal);
            }
        });
        //Home loan calculate button
        homeCalculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                home.setYearlyIncome(Double.parseDouble(homeYearlyIncomeField.getText()));
                home.setDownPayment(Double.parseDouble(homeDownPaymentField.getText()));
                home.setMonthlyMortgage(Double.parseDouble(homeMortgageField.getText()));
                home.setInterestRate(Double.parseDouble(homeAprField.getText()));
                if (homeLoanTermComboBox.getSelectedItem() == "15"){
                    home.setLoanTerm(15);
                }else{
                    home.setLoanTerm(30);
                }
                home.setHousePrice(home.calculateAffordability(home.getYearlyIncome(), home.getDownPayment(), home.getInterestRate(),
                        home.getLoanTerm(), home.getMonthlyMortgage()));
                home.setLoanAmount(home.getHousePrice() - home.getDownPayment());

                amortization = home.calculateAmortization(home.getLoanAmount(), home.getInterestRate(), home.getLoanTerm(),
                        home.getMonthlyPayment(), "Years");

                pay  = new int[amortization.length];
                princ = new double[amortization.length];
                inter = new double[amortization.length];

                double interTotal = 0;

                for (int i = 0; i < amortization.length; i++) {
                    pay[i] = (int) amortization[i][0];
                    princ[i] = amortization[i][1];
                    inter[i] = amortization[i][2];

                    if (i==0){
                        interTotal = inter[i];
                    }else{
                        interTotal += inter[i];
                    }
                }
                home.setTotalPayment(home.getHousePrice() + interTotal);
                home.setTotalInterest(interTotal);
                paymentNumber2 = pay;
                principalPayment2 = princ;
                interestPayment2 = inter;

                home.setSelectedIndex(1);
                personal.setSelectedIndex(0);

                close();
                new LoanGUI(LoanGUI.this.auto, LoanGUI.this.home, LoanGUI.this.personal);
            }
        });
        peronalCalculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                personal.setLoanAmount(Double.parseDouble(personalLoanAmountField.getText()));
                personal.setInterestRate(Double.parseDouble(personalAprField.getText()));
                personal.setLoanTerm(Integer.parseInt(personalLoanTermField.getText()));
                double monthly = personal.calculateMonthlyPayment(personal.getLoanAmount(), personal.getInterestRate(), personal.getLoanTerm());
                personal.setMonthlyPayment(monthly);
                amortization = personal.calculateAmortization(personal.getLoanAmount(), personal.getInterestRate(), personal.getLoanTerm(), personal.getMonthlyPayment(), "Months");

                pay  = new int[amortization.length];
                princ = new double[amortization.length];
                inter = new double[amortization.length];

                double interTotal = 0;

                for (int i = 0; i < amortization.length; i++) {
                    pay[i] = (int) amortization[i][0];
                    princ[i] = amortization[i][1];
                    inter[i] = amortization[i][2];

                    if (i==0){
                        interTotal = inter[i];
                    }else{
                        interTotal += inter[i];
                    }
                }
                personal.setTotalPayment(personal.getLoanAmount() + interTotal);
                personal.setTotalInterest(interTotal);
                paymentNumber3 = pay;
                principalPayment3 = princ;
                interestPayment3 = inter;

                home.setSelectedIndex(0);
                personal.setSelectedIndex(1);

                close();
                new LoanGUI(LoanGUI.this.auto, LoanGUI.this.home, LoanGUI.this.personal);

            }
        });
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(comboBox.getSelectedItem() == "Budget Worksheet"){
                    close();;
                    new BudgetGUI();
                }
                else if (comboBox.getSelectedItem() == "Rent vs Buy") {
                    close();
                    new RentvsBuyGUI(new RentvsBuy());
                }else{
                    close();
                    new NetWorthGUI(new NetWorth());
                }
            }
        });
    }
    public void close(){
        WindowEvent closeWindow = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }

    private void createUIComponents() {
        LineChart autoLine = new LineChart("Principal", "Interest", paymentNumber1,
                "Month Number", principalPayment1, interestPayment1,"Cost" );
        vehicleLinePanel = autoLine.createChartPanel("Amortization", "Principal", "Interest", paymentNumber1, principalPayment1, interestPayment1);

        LineChart homeLine = new LineChart("Principal", "Interest", paymentNumber2,
                "Month Number", principalPayment2, interestPayment2,"Cost" );
        homeLinePanel = autoLine.createChartPanel("Amortization", "Principal", "Interest", paymentNumber2, principalPayment2, interestPayment2);

        LineChart personalLine = new LineChart("Principal", "Interest", paymentNumber3,
                "Month Number", principalPayment3, interestPayment3,"Cost" );
        personalLinePanel = autoLine.createChartPanel("Amortization", "Principal", "Interest", paymentNumber3, principalPayment3, interestPayment3);


    }


    public static void main(String[] args) {
        new LoanGUI(new AutoLoan(), new HomeLoan(), new PersonalLoan());
    }
}


