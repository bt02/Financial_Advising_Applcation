//Store variables for renting and buying -- Calculates cost to rent and buy
package Finances;

public class RentvsBuy {
    private double purchasePrice = 0;
    private double downPayment = 0;
    private double loanAmount = 0;
    private double apr = 0;
    private int loanTerm = 0;
    private double rent =0;

    //getters and setters
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

    //Calculates cost to rent each year
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
    //Calculates cost to byt each year
    public double[] calculateBuyCosts(double purchasePrice, double downPayment, double interestRate, int loanTerm) {
        double loanAmount = purchasePrice - downPayment;
        double totalInterest = 0;
        int numYears = loanTerm;
        double[] yearlyCosts = new double[numYears];
        double yearlyCost;
        double monthlyPayment;
        //Calculate monthly payment
        if (loanAmount / purchasePrice > .80) {
            monthlyPayment = (loanAmount * interestRate / 100 / 12) / (1 - Math.pow(1 + interestRate / 100 / 12, -loanTerm * 12));  //Added PMI and Taxes
        //    monthlyPayment += (monthlyPayment * 0.1) + (monthlyPayment * 0.13); //Added PMI Taxes
        } else {
            monthlyPayment = (loanAmount * interestRate / 100 / 12) / (1 - Math.pow(1 + interestRate / 100 / 12, -loanTerm * 12));
        //    monthlyPayment += (monthlyPayment * 0.1);//Added Taxes
        }
        //Calculate yearly cost
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
}

