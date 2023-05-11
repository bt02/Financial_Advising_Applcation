//Extends loan -- adds home buying variables and calculates affordable price
package Loans;

public class HomeLoan extends Loan {
    double yearlyIncome = 0;
    double housePrice = 0;

    //Getters and setters
    public double getHousePrice(){
        return housePrice;
    }
    public void setHousePrice(double housePrice){
        this.housePrice = housePrice;
    }
    public double getYearlyIncome(){
        return yearlyIncome;
    }
    public void setYearlyIncome(double yearlyIncome){
        this.yearlyIncome = yearlyIncome;
    }

    //Calculates affordable house price
    public double calculateAffordability(double income, int loanTerm, double interest, double payment, double down) {

        // Check if the preferred payment is less than or equal to the maximum payment
        if (payment <= (income / 12) * 0.28) {
            // Calculate the maximum loan amount for the mortgage
            double r = interest / 100 / 12;
            int n = loanTerm * 12;
            double loan = payment * (Math.pow(1 + r, n) - 1) / (r * Math.pow(1 + r, n));

            // Calculate the maximum house price by adding the down payment amount to the loan amount
            double house = loan + down;

            // Return the house price
            return house;

        } else {
            // If the preferred payment is more than the maximum payment, return -1 as an error code
            return -1;
        }
    }
}
