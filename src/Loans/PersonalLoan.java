package Loans;

public class PersonalLoan extends Loan {
   // double loanAmount =0;
 //   double interestRate = 0;
  //  double loanTerm = 0;
    public static double calculateMonthlyPayment(double loanAmount, double interestRate, int loanTerm) {
        // Convert the interest rate from percentage to decimal
        double monthlyInterestRate = interestRate / 100 / 12;

        // Calculate the number of monthly payments
        int numberOfPayments = loanTerm * 12;

        // Calculate the monthly payment
        double monthlyPayment = (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));

        return monthlyPayment;
    }
}
