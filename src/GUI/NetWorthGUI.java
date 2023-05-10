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

public class NetWorthGUI extends JFrame{
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
        this.netWorth = netWorth;

        setContentPane(mainPanel);
        setVisible(true);
        pack();

        ageField.setText(String.valueOf(this.netWorth.getCurrentAge()));
        retirementAgeField.setText(String.valueOf(this.netWorth.getRetirementAge()));
        savingsField.setText(String.valueOf(this.netWorth.getSavings()));
        interestField.setText(String.valueOf(this.netWorth.getInterest()));
        futureField.setText(String.valueOf(this.netWorth.getFutureBalance()));
        contributionsField.setText(String.valueOf(this.netWorth.getMonthlyContributions()));


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
                    new LoanGUI(new AutoLoan(), new HomeLoan(), new PersonalLoan());
                }

            }
        });


        calculateButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                NetWorthGUI.this.netWorth.setCurrentAge(Integer.parseInt(ageField.getText()));
                NetWorthGUI.this.netWorth.setRetirementAge(Integer.parseInt(retirementAgeField.getText()));
                NetWorthGUI.this.netWorth.setSavings(Double.parseDouble(savingsField.getText()));
                NetWorthGUI.this.netWorth.setInterest(Double.parseDouble(interestField.getText()));
                NetWorthGUI.this.netWorth.setMonthlyContributions(Double.parseDouble(contributionsField.getText()));

                //Create array of ages over time
                x = new int[NetWorthGUI.this.netWorth.getRetirementAge() - NetWorthGUI.this.netWorth.getCurrentAge()];
                for (int i = 0; i < x.length; i++) {
                    x[i] = i + NetWorthGUI.this.netWorth.getCurrentAge() + 1;

                }
                //Calculate net worth amount per year
                y = NetWorthGUI.this.netWorth.getCompoundInterest(NetWorthGUI.this.netWorth.getSavings(), NetWorthGUI.this.netWorth.getInterest()/100,
                        NetWorthGUI.this.netWorth.getCurrentAge(), NetWorthGUI.this.netWorth.getRetirementAge(), 12, NetWorthGUI.this.netWorth.getMonthlyContributions());
                NetWorthGUI.this.netWorth.setFutureBalance(((double) Math.round(y[y.length - 1] * 100) /100));
                close();
                new NetWorthGUI(NetWorthGUI.this.netWorth);
            }
        });
    }
    public void close(){
        WindowEvent closeWindow = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }

    private void createUIComponents() {
            //Create line graph
        LineChart line = new LineChart("Net Worth", x, "Years", y, "Money");
        linePanel = line.createChartPanel("Net Worth",x, y);
    }
}
