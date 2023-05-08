package Finances;

import GUI.NetWorthGUI;
import GUI.RentvsBuyGUI;

import java.util.Arrays;

public class RentvsBuy {
    private double housePrice = 200_000;
    private double downPayment = 20_000;
    private double loanAmount = 180_000;
    private double apr = 6;
    private int loanTerm = 30;
    private double rent = 800;
    private double monthlyMortgage = 1500;
    private double[] compoundInterestMoney = new double[]{1};
    private double[] compoundInterestHouse = new double[]{1};
    static double[] amortization = new double[]{1};
    static double[] homeEquity = new double[]{1};

    public double gethousePrice() {
        return housePrice;
    }

    public void sethousePrice(double housePrice) {
        this.housePrice = housePrice;
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

    public double getMonthlyMortgage() {
        return monthlyMortgage;
    }

    public void setMonthlyMortgage(double monthlyMortgage) {
        this.monthlyMortgage = monthlyMortgage;
    }

    public double[] getCompoundInterestMoney() {
        return compoundInterestMoney;
    }

    public void setCompoundInterestMoney(double[] compoundInterestMoney) {
        this.compoundInterestMoney = compoundInterestMoney;
    }
    public double[] getCompoundInterestHouse() {
        return compoundInterestMoney;
    }

    public void setCompoundInterestHouse(double[] compoundInterestHouse) {
        this.compoundInterestHouse = compoundInterestHouse;
    }
    public double[] getHomeEquity() {
        return homeEquity;
    }

    public void setHomeEquity(double[] homeEquity) {
        this.homeEquity = homeEquity;
    }

    public double[] getAmortization() {
        return amortization;
    }

    public void setAmortization(double[] amortization) {
        this.amortization = amortization;
    }


    //Calculate value of down payment over time
    public double[] calculateCompoundInterest(double principal, double interestRate, int years, int compoundPerYear) {
        double[] total = new double[years];
        for (int i = 0; i < years; i++) {
            total[i] = (principal * Math.pow(1 + ((interestRate/100) / compoundPerYear), compoundPerYear * (i+1)) -principal);
        }
        return total;
    }
    //Overloaded method for interest rate that only compound once per year -- house appreciation
    public double[] calculateCompoundInterest(double principal, double interestRate, int years) {
        double[] totals = new double[years];
        for (int i = 0; i < years; i++) {
            totals[i] = principal * Math.pow(1 + (interestRate/100), i+1);
        }
        return totals;

    }

    //Calculate monthly mortgage payment
    public double calculateMonthlyPayment(double loanAmount,  double interestRate, int loanTerm) {
        int months = loanTerm * 12; // Convert years to months
        double monthlyInterestRate = interestRate / 100 / 12; // Convert interest rate to monthly decimal rate

        return (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -months));
    }


    public double[] calculateHomeEquity(double housePrice, double loanAmount, double[] amortization, int loanTerm, double appreciation) {
        double[] equity = new double[loanTerm];

        double[] mortgageBalance = new double[loanTerm];
        double[] marketValue = calculateCompoundInterest(housePrice, appreciation, loanTerm); //homeValue

        for (int i = 0; i < loanTerm; i++) {
            mortgageBalance[i] = loanAmount - amortization[i];
            equity[i] = (marketValue[i]) - mortgageBalance[i];
        }
        return equity;
    }


    public double[] rentCost(double[] compoundInterest, int loanTerm, double downPayment, double rent){
        double rentGrowth = rent;
        double[] total = new double[loanTerm];
        for (int i = 0; i <loanTerm; i++) {
            if (i==0){
                rentGrowth+= rentGrowth*0.05;
                total[0] = (rentGrowth * 13);// - downPayment; //accounts for security deposit
            }else{
                rentGrowth+= rentGrowth*0.05;
                total[i] += (total[i-1] + (rentGrowth*12) );

            }
            System.out.println(i);
            System.out.println(total[i]);
            //total[i] = total[i] - compoundInterest[i];
        }
        System.out.println(Arrays.toString(compoundInterest));

        return total;
    }

    public double[] houseCost(double mortgage, double downPayment, double loanAmount, int loanTerm, double appreciation, double housePrice, double[] amortization ){
        double[] houseCost= new double[loanTerm];
        double[] equity = calculateHomeEquity(housePrice, loanAmount, amortization, loanTerm, appreciation);
        double [] cost = new double[loanTerm];
        for (int i = 0; i <loanTerm; i++) {
            if (i == 0){
                cost[i] =  (mortgage*12) + (housePrice * 0.05) +downPayment;
            }else{
                cost[i] +=cost[i-1] + (mortgage * (i+12)) + (housePrice * 0.05);
            }
            houseCost[i] = cost[i]- equity[i] ;

        }
        return houseCost;
    }

    //Calculate yearly home amortization
    public  double[] calculateAnnualAmortization(double loanAmount, double interestRate, int loanTerm, double housePrice) {
        int months = loanTerm * 12; // Convert years to months
        double originalLoan = loanAmount;

        double monthlyInterestRate = interestRate / 100 / 12; // Convert interest rate to monthly decimal rate
        double monthlyPayment = calculateMonthlyPayment(loanAmount, interestRate, loanTerm);
        double[] amortizationArray = new double[loanTerm+1];

        double annualPrincipal = 0.0;

        for (int i =1; i<=months; i++) {
            double monthlyInterest = loanAmount * monthlyInterestRate;
            double monthlyPrincipal = monthlyPayment - monthlyInterest;

            annualPrincipal += monthlyPrincipal;
            loanAmount -= monthlyPrincipal;

            if (i == 1){
                amortizationArray[0] = annualPrincipal;

                annualPrincipal = 0.0;

            } else if (i/12 == loanTerm) {
                amortizationArray[loanTerm] = originalLoan;

            }else {
                if (i % 12 == 0) {
                    amortizationArray[i/12] = annualPrincipal + amortizationArray[(i/12)-1];
                    annualPrincipal = 0.0;

                }
            }
        }
        return amortizationArray;
    }

    public static void main(String[] args) {
        double[] rentTotal;
        double[] buyTotal;
        RentvsBuy  RvB  = new RentvsBuy();
        rentTotal =RvB.rentCost(RvB.getCompoundInterestMoney(), RvB.getLoanTerm(), RvB.getDownPayment(),RvB.getRent());
        buyTotal = RvB.houseCost(RvB.calculateMonthlyPayment(RvB.loanAmount, RvB.apr, RvB.loanTerm), RvB.getDownPayment(), RvB.getLoanAmount(),
                RvB.getLoanTerm(), RvB.getApr(),RvB.gethousePrice(), RvB.getAmortization());

        System.out.println(Arrays.toString(rentTotal));
        System.out.println(Arrays.toString(buyTotal));
    }

}


