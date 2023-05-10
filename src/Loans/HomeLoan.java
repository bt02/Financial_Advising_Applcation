package Loans;

public class HomeLoan extends Loan {
    double yearlyIncome = 0;
  //  double downPayment = 0;
  //  double interestRate = 0;
  //  int loanTerm = 0;
    double monthlyMortgage = 0;


    public double calculateAffordability(double yearlyIncome, double downPayment, double interestRate, int loanTerm, double monthlyMortgage) {
        double monthlyInterestRate = interestRate / 100 / 12;
        int loanMonths = loanTerm * 12;

        double loanAmount = (monthlyMortgage / monthlyInterestRate) * (1 - Math.pow(1 + monthlyInterestRate, -loanMonths));

        return loanAmount + downPayment;
    }
}
