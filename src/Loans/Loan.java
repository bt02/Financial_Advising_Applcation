package Loans;

import java.text.DecimalFormat;

public class Loan {
    double loanAmount = 0;
    double interestRate = 0;
    int loanTerm = 0;
    double downPayment = 0;

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

    public static double[][] calculateAmortization(double principal, double interestRate, int loanTerm, double monthlyPayment) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

        // Convert interest rate to decimal and calculate monthly interest rate
        double monthlyInterestRate = interestRate / 100 / 12;

        // Calculate number of payments
        int numberOfPayments = loanTerm * 12;

        // Create an array to store the amortization schedule
        double[][] amortizationSchedule = new double[numberOfPayments][4];
        // Columns: Payment Number, Principal Payment, Interest Payment, Remaining Balance

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

