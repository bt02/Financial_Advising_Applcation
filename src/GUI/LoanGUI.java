package GUI;

import Loans.AutoLoan;
import Loans.HomeLoan;
import Loans.PersonalLoan;

import javax.swing.*;

public class LoanGUI extends JFrame {
    private JComboBox comboBox;
    private JTabbedPane mainLoanPane;
    private JPanel mainPanel;
    private JPanel homeLoanPanel;
    private JPanel autoLoanPanel;
    private JPanel personalPanel;
    private JPanel homeContentPanel;
    private JPanel homeOutputPanel;
    private JTextField yearlyIncomeField;
    private JTextField homeDownPaymentField;
    private JTextField mortgageField;
    private JTextField homeAprField;
    private JComboBox homeLoanTermComboBox;
    private JTextField housePriceField;
    private JTextField homeTotalAprField;
    private JTextField homeTotalPaymentField;
    private JPanel homeLinePanel;
    private JLabel yearlyIncomeLabel;
    private JLabel homeDownPaymentLabel;
    private JLabel mortgageLabel;
    private JLabel homeAprLabel;
    private JLabel HomeLoanTermLabel;
    private JLabel housePriceLabel;
    private JLabel homeTotalAprLabel;
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
    private JLabel vehicleTotalAprLabel;
    private JTextField vehicleTotalAprField;
    private JLabel vehicleTotalPaymentsLabel;
    private JTextField vehicleTotalPaymentsField;
    private JPanel personalContentPanel;
    private JPanel personalOutputPanel;
    private JPanel personalLinePanel;
    private JLabel personalPaymentLabel;
    private JTextField personalPaymentField;
    private JLabel personalLaonAmountLabel;
    private JTextField personalLaonAmountField;
    private JLabel personalTotalAprLabel;
    private JTextField personalTotalAprField;
    private JLabel personalTotalPaymentsLabel;
    private JTextField personalTotalPaymentsField;
    private JLabel personalLoanAmountLabel;
    private JTextField personalLoanAmountField;
    private JLabel personalAprLabel;
    private JTextField personalAprField;
    private JLabel personalLoanTermLabel;
    private JTextField personalLoanTermField;

    AutoLoan auto;
    HomeLoan home;
    PersonalLoan personal;

    public LoanGUI(AutoLoan auto, HomeLoan home, PersonalLoan personal){
        this.auto = auto;
        this.home = home;
        this.personal = personal;

        setContentPane(mainPanel);
        setVisible(true);
        pack();
        //Set auto variables
        auto.setVehiclePrice(Double.parseDouble(vehiclePriceField.getText()));
        auto.setDownPayment(Double.parseDouble(vehicleDownPaymentField.getText()));
        auto.setTradInValue(Double.parseDouble(vehicleTradeField.getText()));
        auto.setAmountOwed(Double.parseDouble(vehicleOwedField.getText()));
        auto.setLoanTerm(Integer.parseInt(vehicleLoanTermField.getText()));
        auto.setLoanAmount(auto.getLoanAmount(auto.getVehiclePrice(), auto.getTradInValue(),auto.getDownPayment(), auto.getAmountOwed()));

        //Set home variables
        home.setDownPayment(Double.parseDouble(homeDownPaymentField.getText()));



    }

    public static void main(String[] args) {
        new LoanGUI(new AutoLoan(), new HomeLoan(), new PersonalLoan());
    }

    private void createUIComponents() {
     //   LineChart homeLine = new LineChart("Net Worth", x, "Years", y, "Money");
      //  homeLinePanel = homeLine.createChartPanel(homeLine.getSeries1(), homeLine.getxS1Values(), homeLine.getyS1Values());
    }
}
