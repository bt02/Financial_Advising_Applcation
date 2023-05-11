//Extends Loan -- Adds specific auto information and car loan amounts
package Loans;

public class AutoLoan extends Loan {

    double vehiclePrice = 0;
    double tradInValue = 0;
    double amountOwed = 0;

    //Getters and setters
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

    //Calculate car loan amount
    public double getCarLoanAmount(double vehiclePrice, double tradeInValue, double downPayment, double amountOwedAtTradeIn){
       return  (vehiclePrice - tradeInValue - downPayment) + amountOwedAtTradeIn;
    }
}
