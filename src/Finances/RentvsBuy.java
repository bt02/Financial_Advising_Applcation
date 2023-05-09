package Finances;

import GUI.RentvsBuyGUI;

import java.util.Arrays;

public class RentvsBuy {
    private double purchasePrice = 200_000;
    private double downPayment = 20_000;
    private double loanAmount = 180_000;
    private double apr = 6;
    private int loanTerm = 30;
    private double rent = 800;

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(double downPayment) {
        this.downPayment = downPayment;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getApr() {
        return apr;
    }

    public void setApr(double apr) {
        this.apr = apr;
    }

    public int getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(int loanTerm) {
        this.loanTerm = loanTerm;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public double[] calculateRentCosts(int numYears, double rent) {
        double[] rentCosts = new double[numYears];
        for (int i = 0; i < numYears; i++) {
            if (i == 0) {
                rentCosts[i] = (rent * 13);
                rent += rent * 0.03;
            } else {
                rentCosts[i] = rentCosts[i - 1] + (rent * 12) + (rent * 0.02);
                rent += rent * 0.03;
            }
        }
        return rentCosts;
    }

    public double[] calculateBuyCosts(double purchasePrice, double downPayment, double interestRate, int loanTerm) {
        double loanAmount = purchasePrice - downPayment;
        double totalInterest = 0;
        int numYears = loanTerm;
        double[] yearlyCosts = new double[numYears];
        double yearlyCost;
        double monthlyPayment;
        double taxes;
        if (loanAmount / purchasePrice > .80) {
            monthlyPayment = (loanAmount * interestRate / 100 / 12) / (1 - Math.pow(1 + interestRate / 100 / 12, -loanTerm * 12));  //Added PMI and Taxes
            monthlyPayment += (monthlyPayment * 0.1) + (monthlyPayment * 0.13); //Added PMI Taxes
            taxes = monthlyPayment - (monthlyPayment*0.23);
        } else {
            monthlyPayment = (loanAmount * interestRate / 100 / 12) / (1 - Math.pow(1 + interestRate / 100 / 12, -loanTerm * 12));
            monthlyPayment += (monthlyPayment * 0.1);//Added Taxes
            taxes = monthlyPayment - (monthlyPayment*0.1);
        }

        for (int year = 0; year < numYears; year++) {
            double yearlyInterest = 0;

            for (int month = 0; month < 12; month++) {
                double monthlyInterest = loanAmount * (interestRate / 100 / 12);
                double monthlyPrincipal = monthlyPayment  - monthlyInterest;
                loanAmount -= monthlyPrincipal;
                yearlyInterest += monthlyInterest;
            }

            if (year == 0) {
                yearlyCost = purchasePrice / numYears + yearlyInterest;
                yearlyCosts[year] = yearlyCost;
                totalInterest += yearlyInterest;
            } else {
                yearlyCost = purchasePrice / numYears + yearlyInterest;
                yearlyCosts[year] = yearlyCosts[year - 1] + yearlyCost;
                totalInterest += yearlyInterest;
            }
        }
        return yearlyCosts;
    }

    public static void main(String[] args) {
        RentvsBuy r  = new RentvsBuy();
        double[] a = r.calculateBuyCosts(r.purchasePrice, r.downPayment, r.apr,r.loanTerm);
        //System.out.println(Arrays.toString(a));
    }
}

