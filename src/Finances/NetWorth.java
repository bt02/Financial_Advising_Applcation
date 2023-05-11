//Store net worth variables and calculates compound interest for NetWorthGUI
package Finances;

public class NetWorth {

    private int currentAge = 0;
    private int retirementAge= 0;
    private double interest = 0;
    private double savings= 0;
    private double futureBalance = 0;
    private double monthlyContributions = 0;

    //Getter and Setters

    public  double getMonthlyContributions(){return monthlyContributions;}
    public void setMonthlyContributions(double monthlyContributions){this.monthlyContributions = monthlyContributions;}

    public double getFutureBalance() {return futureBalance;}
    public void setFutureBalance(double futureBalance) {this.futureBalance = futureBalance;}
    public double getSavings() { return savings;}

    public void setSavings(double savings) { this.savings = savings;}


    public int getCurrentAge() {
        return currentAge;
    }

    public void setCurrentAge(int currentAge) {
        this.currentAge = currentAge;
    }

    public int getRetirementAge() {
        return retirementAge;
    }

    public void setRetirementAge(int retirementAge) {
        this.retirementAge = retirementAge;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    //Calculates compound interest each year for inputted duration

    public double[] getCompoundInterest(double principal, double interestRate, int currentAge, int retirementAge, int compoundPerYear, double monthlyContribution) {
        int years = retirementAge - currentAge;
        double[] amount = new double[years];

        for (int i = 0; i < years; i++) {
            for (int j = 0; j < 12; j++) {
                principal += monthlyContribution;
                principal *= (1 + (interestRate / compoundPerYear));
                amount[i] = principal;
            }
        }
        return amount ;
    }

}
