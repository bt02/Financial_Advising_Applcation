package Finances;

import java.util.Arrays;

public class RentVsBuyCalculator {
    public static void main(String[] args) {
        double rentAmount = 1000; // Monthly rent amount in dollars
        double buyingPrice = 200000; // House buying price in dollars
        double downPayment = 40000; // Down payment amount in dollars
        double interestRate = 4.5; // Mortgage interest rate in percentage
        int loanTerm = 30; // Loan term in years
        double annualAppreciationRate = 2.5; // Annual house appreciation rate in percentage
        int stayYears = 5; // Number of years to stay in the house

        double[] rentCosts = calculateRentCosts(rentAmount, loanTerm);
        double[] buyCosts = calculateBuyCosts(buyingPrice, downPayment, interestRate, loanTerm, annualAppreciationRate);

        // Print the cost of renting and buying for each year
        System.out.println(Arrays.toString(rentCosts));
        System.out.println(Arrays.toString(buyCosts));
    }

    public static double[] calculateRentCosts(double rentAmount, int loanTerm) {
        double[] rentCosts = new double[loanTerm];

        for (int year = 0; year < loanTerm; year++) {
            rentCosts[year] = rentAmount * 12 * (year + 1);
            //add interest of invested money
        }

        return rentCosts;
    }

    public static double[] calculateBuyCosts(double buyingPrice, double downPayment, double interestRate, int loanTerm, double annualAppreciationRate) {
        double[] buyCosts = new double[loanTerm]; // Create an array to store the value at each year during the loan term

        double loanAmount = buyingPrice - downPayment; // Calculate the loan amount by subtracting the down payment from the buying price
        int months = loanTerm * 12; // Convert the loan term from years to months
        double monthlyInterestRate = interestRate / 100 / 12; // Calculate the monthly interest rate
        double monthlyPayment = (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -months)); // Calculate the fixed monthly payment using the loan amount, interest rate, and loan term

        double remainingLoanAmount = loanAmount; // Initialize the remaining loan amount as the total loan amount
        double equity = downPayment; // Initialize the equity as the down payment
        double totalAppreciation = buyingPrice * (annualAppreciationRate / 100); // Calculate the total appreciation based on the annual appreciation rate and the buying price

        for (int year = 0; year < loanTerm; year++) {
            double interestPaid = remainingLoanAmount * monthlyInterestRate; // Calculate the interest paid for the current year
            double principalPaid = monthlyPayment - interestPaid; // Calculate the principal paid for the current year

            remainingLoanAmount -= principalPaid; // Update the remaining loan amount by subtracting the principal paid
            equity += principalPaid; // Update the equity by adding the principal paid
            buyCosts[year] = equity + totalAppreciation; // Calculate and store the buy cost for the current year, which is the sum of equity and total appreciation
        }

        return buyCosts; // Return the array containing the value at each year during the loan term
    }
}
