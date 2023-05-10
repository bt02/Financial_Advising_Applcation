package Loans;

import java.text.DecimalFormat;
import java.util.Objects;

public class Loan {
    double loanAmount = 0;
    double interestRate = 0;
    int loanTerm = 0;
    double downPayment = 0;
    double monthlyPayment = 0;
    double totalInterest = 0;
    double totalPayment = 0;
    int selectedIndex = 0;

    public int getSelectedIndex(){
        return selectedIndex;
    }
    public void setSelectedIndex(int selectedIndex){
        this.selectedIndex = selectedIndex;
    }
    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public double getTotalInterest() {
        return totalInterest;
    }

    public void setTotalInterest(double totalInterest) {
        this.totalInterest = totalInterest;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }
    public double getDownPayment(){
        return downPayment;
    }
    public void setDownPayment(double downPayment){
        this.downPayment = downPayment;
    }
    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(int loanTerm) {
        this.loanTerm = loanTerm;
    }

    public double[][] calculateAmortization(double principal, double interestRate, int loanTerm, double monthlyPayment, String unit) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        int numberOfPayments;
        if (Objects.equals(unit,"Months")){
             numberOfPayments = loanTerm;
        }else {
            numberOfPayments = loanTerm *12;
        }
        // Convert interest rate to decimal and calculate monthly interest rate
        double monthlyInterestRate = interestRate / 100 / 12;

        // Calculate number of payments


        // Create an array to store the amortization schedule
        double[][] amortizationSchedule = new double[numberOfPayments][4];

        // Calculate amortization schedule
        double remainingBalance = principal;

        for (int paymentNumber = 1; paymentNumber <= numberOfPayments; paymentNumber++) {
            double interestPayment = remainingBalance * monthlyInterestRate;
            double principalPayment = monthlyPayment - interestPayment;

            remainingBalance -= principalPayment;

            // Store the values in the amortization schedule array
            amortizationSchedule[paymentNumber - 1][0] = paymentNumber;
            amortizationSchedule[paymentNumber - 1][1] = principalPayment;
            amortizationSchedule[paymentNumber - 1][2] = interestPayment;
            amortizationSchedule[paymentNumber - 1][3] = remainingBalance;
        }

        return amortizationSchedule;
    }
}

