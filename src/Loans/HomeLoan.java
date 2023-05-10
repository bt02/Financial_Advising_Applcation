package Loans;

public class HomeLoan extends Loan {
    double yearlyIncome = 0;
    double monthlyMortgage = 0;
    double housePrice = 0;

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
    public double getMonthlyMortgage(){
        return monthlyMortgage;
    }
    public void setMonthlyMortgage(double monthlyMortgage){
        this.monthlyMortgage = monthlyMortgage;
    }
    //use yearly income to check dti>?
    public double calculateAffordability(double yearlyIncome, double downPayment, double interestRate, int loanTerm, double monthlyMortgage) {
        double monthlyInterestRate = interestRate / 100 / 12;
        int loanMonths = loanTerm * 12;

        double loanAmount = (monthlyMortgage / monthlyInterestRate) * (1 - Math.pow(1 + monthlyInterestRate, -loanMonths));

        return loanAmount + downPayment;
    }
}
