package GUI;

import Finances.Budget;

import javax.swing.*;
import java.awt.event.*;

public class BudgetGUI extends JFrame {

    private JTextField travelField;
    private JTextField diningField;
    private JPanel mainPanel;
    private JLabel mainTitle;
    private JPanel contentPanel;
    private JLabel incomeTitle;
    private JLabel incomeLabel;
    private JTextField otherIncomeField;
    private JTextField incomeField;
    private JLabel otherIncomeLabel;
    private JLabel expensesField;
    private JLabel needsLabel;
    private JTextField mortgageField;
    private JTextField homeInsuranceField;
    private JTextField autoInsuranceField;
    private JLabel mortgageLabel;
    private JLabel homeInsuranceLabel;
    private JLabel autoInsuranceLabel;
    private JTextField healthInsuranceField;
    private JTextField utilitiesField;
    private JTextField groceriesField;
    private JLabel healInsuranceLabel;
    private JLabel utilitiesLabel;
    private JLabel groceriesLabel;
    private JTextField gasolineField;
    private JTextField phoneBillField;
    private JTextField needsOtherField;
    private JLabel gasolineLabel;
    private JLabel phoneBillLabel;
    private JLabel needsOtherLabel;
    private JLabel wantsLabel;
    private JTextField clothingField;
    private JLabel clothingLabel;
    private JLabel diningLabel;
    private JLabel travelLabel;
    private JTextField membershipsField;
    private JTextField streamingServicesField;
    private JTextField wantsOtherField;
    private JLabel membershipsLabel;
    private JLabel streamingServicesLabel;
    private JLabel wantsOtherLabel;
    private JLabel financesLabel;
    private JLabel savingsLabel;
    private JLabel retirementLabel;
    private JLabel savingsOtherLabel;
    private JTextField savingsOtherField;
    private JTextField retirementField;
    private JTextField savingsField;
    private JLabel ccPaymentsLabel;
    private JLabel loanPaymentsLabel;
    private JLabel debtsOtherLabel;
    private JTextField ccPaymentsField;
    private JTextField loanPaymentsField;
    private JTextField debtsOtherField;
    private JPanel summeryPanel;
    private JTextField needsTotalField;
    private JTextField fiftyField;
    private JLabel needsTotalLabel;
    private JLabel wantsTotalLabel;
    private JLabel financeTotalLabel;
    private JButton calculateButton;
    private JLabel fiftyLabel;
    private JLabel thirtyLabel;
    private JLabel twentyLabel;
    private JTextField wantsTotalField;
    private JTextField financesTotalField;
    private JTextField thirtyField;
    private JTextField twentyField;
    private JTextField totalField;
    private JButton submitButton;

    public BudgetGUI(){
        Budget budget = new Budget();
        setVisible(true);

        setContentPane(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();


        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); //Windows Look and feel
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // budget.setDining(Double.parseDouble(diningField.getText()));
                //Set income Value
                budget.setIncome(Double.parseDouble(incomeField.getText()));
                budget.setOtherIncome(Double.parseDouble(otherIncomeField.getText()));
                //Set needs values
                budget.setRentMortgage(Double.parseDouble(mortgageField.getText()));
                budget.setHomeInsurance(Double.parseDouble(homeInsuranceField.getText()));
                budget.setAutoInsurance(Double.parseDouble(autoInsuranceField.getText()));
                budget.setHealthInsurance(Double.parseDouble(homeInsuranceField.getText()));
                budget.setUtilities(Double.parseDouble(utilitiesField.getText()));
                budget.setGroceries(Double.parseDouble(groceriesField.getText()));
                budget.setGasoline(Double.parseDouble(gasolineField.getText()));
                budget.setPhoneBill(Double.parseDouble(gasolineField.getText()));
                budget.setNeedsOther(Double.parseDouble(needsOtherField.getText()));
                //Set wants values
                budget.setClothing(Double.parseDouble(clothingField.getText()));
                budget.setDining(Double.parseDouble(diningField.getText()));
                budget.setTravel(Double.parseDouble(travelField.getText()));
                budget.setMemberships(Double.parseDouble(membershipsField.getText()));
                budget.setStreamingServices(Double.parseDouble(streamingServicesField.getText()));
                budget.setWantsOther(Double.parseDouble(wantsOtherField.getText()));
                //Set finance values
                budget.setSavings(Double.parseDouble(savingsField.getText()));
                budget.setRetirement(Double.parseDouble(retirementField.getText()));
                budget.setSavingsOther(Double.parseDouble(savingsOtherField.getText()));
                budget.setCcPayments(Double.parseDouble(ccPaymentsField.getText()));
                budget.setLoanPayments(Double.parseDouble(loanPaymentsField.getText()));
                budget.setDebtsOther(Double.parseDouble(debtsOtherField.getText()));
                //Calculate totals
                needsTotalField.setText(String.valueOf(budget.getTotalNeeds()));
                wantsTotalField.setText(String.valueOf(budget.getTotalWants()));
                financesTotalField.setText(String.valueOf(budget.getTotalFinance()));
                //50/30/20 comparison
                fiftyField.setText(String.valueOf(budget.getIncome()*0.50));
                thirtyField.setText(String.valueOf(budget.getIncome()*0.30));
                twentyField.setText(String.valueOf(budget.getIncome()*0.20));

            }
        });
    }

}
