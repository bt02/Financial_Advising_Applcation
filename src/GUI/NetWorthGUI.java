//GUI for displaying net worth over time
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

public class NetWorthGUI extends JFrame{
    //GUI variables
     JPanel mainPanel;
     JComboBox comboBox;
     JPanel contentPanel;
     JPanel linePanel;
     JTextField ageField;
     JLabel ageLabel;
     JTextField retirementAgeField;
     JLabel retirementAgeLabel;
     JTextField savingsField;
     JLabel savingsLabel;
     JTextField contributionsField;
     JLabel contributionsLabel;
     JTextField interestField;
     JLabel interestLabel;
     JButton calculateButton;
     JTextField futureField;
     JLabel futureLabel;

    //Line chart placeholders
    static int[] x = new int[]{1};
    static double[] y = new double[]{1};


    NetWorth netWorth;

    public NetWorthGUI(NetWorth netWorth){
        //GUI set up
        this.netWorth = netWorth;

        setContentPane(mainPanel);
        setVisible(true);
        pack();
        //Set GUI fields form NetWorth GUI
        ageField.setText(String.valueOf(netWorth.getCurrentAge()));
        retirementAgeField.setText(String.valueOf(netWorth.getRetirementAge()));
        savingsField.setText(String.valueOf(netWorth.getSavings()));
        interestField.setText(String.valueOf(netWorth.getInterest()));
        futureField.setText(String.valueOf(netWorth.getFutureBalance()));
        contributionsField.setText(String.valueOf(netWorth.getMonthlyContributions()));

        //Changes GUI window
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
                    new LoanGUI(new AutoLoan(), new HomeLoan(), new Loan());
                }

            }
        });

        //Calculates net worth
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Set NetWorth class variables
                netWorth.setCurrentAge(Integer.parseInt(ageField.getText()));
                netWorth.setRetirementAge(Integer.parseInt(retirementAgeField.getText()));
                netWorth.setSavings(Double.parseDouble(savingsField.getText()));
                netWorth.setInterest(Double.parseDouble(interestField.getText()));
                netWorth.setMonthlyContributions(Double.parseDouble(contributionsField.getText()));

                //Create array of ages over time
                x = new int[netWorth.getRetirementAge() - netWorth.getCurrentAge()];
                for (int i = 0; i < x.length; i++) {
                    x[i] = i + netWorth.getCurrentAge() + 1;

                }
                //Calculate net worth amount per year
                y = netWorth.getCompoundInterest(netWorth.getSavings(), netWorth.getInterest()/100,
                        netWorth.getCurrentAge(), netWorth.getRetirementAge(), 12, netWorth.getMonthlyContributions());
                netWorth.setFutureBalance(((double) Math.round(y[y.length - 1] * 100) /100));
                //Open new GUI with updated information
                close();
                new NetWorthGUI(netWorth);
            }
        });
    }
    //Method to close current window
    public void close(){
        WindowEvent closeWindow = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    //Creates custom line chart
    private void createUIComponents() {
            //Create line graph
        LineChart line = new LineChart("Net Worth", x, "Years", y, "Net Worth");
        linePanel = line.createChartPanel("Net Worth",x, y);
    }
}
