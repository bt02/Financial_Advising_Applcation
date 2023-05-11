package GUI;

import Finances.Budget;
import Finances.NetWorth;
import Finances.RentvsBuy;
import Loans.AutoLoan;
import Loans.HomeLoan;
import Loans.Loan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BudgetGUI extends JFrame {

     JTextField travelField;
     JTextField diningField;
     JPanel mainPanel;
     JPanel contentPanel;
     JLabel incomeTitle;
     JLabel incomeLabel;
     JTextField otherIncomeField;
     JTextField incomeField;
     JLabel otherIncomeLabel;
     JLabel expensesField;
     JLabel needsLabel;
     JTextField mortgageField;
     JTextField homeInsuranceField;
     JTextField autoInsuranceField;
     JLabel mortgageLabel;
     JLabel homeInsuranceLabel;
     JLabel autoInsuranceLabel;
     JTextField healthInsuranceField;
     JTextField utilitiesField;
     JTextField groceriesField;
     JLabel healthInsuranceLabel;
     JLabel utilitiesLabel;
     JLabel groceriesLabel;
     JTextField gasolineField;
     JTextField phoneBillField;
     JTextField needsOtherField;
     JLabel gasolineLabel;
     JLabel phoneBillLabel;
     JLabel needsOtherLabel;
     JLabel wantsLabel;
     JTextField clothingField;
     JLabel clothingLabel;
     JLabel diningLabel;
     JLabel travelLabel;
     JTextField membershipsField;
     JTextField streamingServicesField;
     JTextField wantsOtherField;
     JLabel membershipsLabel;
     JLabel streamingServicesLabel;
     JLabel wantsOtherLabel;
     JLabel financesLabel;
     JLabel savingsLabel;
     JLabel retirementLabel;
     JLabel savingsOtherLabel;
     JTextField savingsOtherField;
     JTextField retirementField;
     JTextField savingsField;
     JLabel ccPaymentsLabel;
     JLabel loanPaymentsLabel;
     JLabel debtsOtherLabel;
     JTextField ccPaymentsField;
     JTextField loanPaymentsField;
     JTextField debtsOtherField;
     JPanel summeryPanel;
     JTextField needsTotalField;
     JTextField fiftyField;
     JLabel needsTotalLabel;
     JLabel wantsTotalLabel;
     JLabel financeTotalLabel;
     JButton calculateButton;
     JLabel fiftyLabel;
     JLabel thirtyLabel;
     JLabel twentyLabel;
     JTextField wantsTotalField;
     JTextField financesTotalField;
     JTextField thirtyField;
     JTextField twentyField;
    private JComboBox comboBox;


    public BudgetGUI(){
        Budget budget = new Budget();
        setVisible(true);
        setContentPane(mainPanel);
        pack();



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
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox.getSelectedItem() == "Net Worth") {
                    close();
                    new NetWorthGUI(new NetWorth());
                }
                else if (comboBox.getSelectedItem() == "Rent vs Buy") {
                    close();
                    new RentvsBuyGUI(new RentvsBuy());
                }else {
                    close();
                    new LoanGUI(new AutoLoan(), new HomeLoan(), new Loan());
                }

            }
        });

    }
    public void close(){
        WindowEvent closeWindow = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }


}
