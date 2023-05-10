package Loans;

import java.util.Arrays;

public class AutoLoan extends Loan {

    double vehiclePrice = 0;
    double tradInValue = 0;
    double amountOwed = 0;

    //  double downPayment = 0;
    //  double loanTerm = 0;
    //  double interestRate = 0;

    public double getVehiclePrice() {
        return vehiclePrice;
    }

    public void setVehiclePrice(double vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }

    public double getTradInValue() {
        return tradInValue;
    }

    public void setTradInValue(double tradInValue) {
        this.tradInValue = tradInValue;
    }

    public double getAmountOwed() {
        return amountOwed;
    }

    public void setAmountOwed(double amountOwed) {
        this.amountOwed = amountOwed;
    }

    public double getCarLoanAmount(double vehiclePrice, double tradeInValue, double downPayment, double amountOwedAtTradeIn){
       return  (vehiclePrice - tradeInValue - downPayment) + amountOwedAtTradeIn;
    }
    public double calculateMonthlyPayment(int loanTerm, double interestRate,double loanAmount) {

        // Calculate the monthly interest rate
        double monthlyInterestRate = interestRate / 12 / 100;

        // Calculate the monthly payment

        return (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -loanTerm));
    }
}
