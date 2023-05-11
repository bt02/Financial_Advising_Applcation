//Budget methods to hold information paired to BudgetGUI
package Finances;

import java.util.HashMap;

public class Budget {

    private double income = 0;
    private double otherIncome = 0;

    private double savings = 0;
    private double retirement = 0;
    private double ccPayments = 0;
    private double loanPayments = 0;
    private double savingsOther = 0;
    private double debtsOther = 0;

    private double totalNeeds = 0;
    private double totalWants = 0;


    public void setIncome(double income) {this.income = income;}
    public void setOtherIncome(double otherIncome) {
        this.otherIncome = otherIncome;
    }


    //Needs setters and puts for hashmap
    public void setRentMortgage(double rentMortgage) {needs.put("Rent/Mortgage", rentMortgage);}

    public void setHomeInsurance(double homeInsurance) {
        needs.put("Home Insurance", homeInsurance);
    }

    public void setAutoInsurance(double autoInsurance) {
        needs.put("Auto Insurance" , autoInsurance);
    }

    public void setHealthInsurance(double healthInsurance) {
        needs.put("Health Insurance", healthInsurance);
    }

    public void setUtilities(double utilities) {
        needs.put("utilities", utilities);
    }

    public void setGroceries(double groceries) {
        needs.put("Groceries", groceries);
    }

    public void setGasoline(double gasoline) {
        needs.put("Gasoline", gasoline);
    }

    public void setPhoneBill(double phoneBill){
        needs.put("Phone Bill", phoneBill);
    }

    public void setNeedsOther(double needsOther) {
        needs.put("Other Needs", needsOther);
    }


    //Wants setter and puts for hashmap
    public void setClothing(double clothing) {wants.put("Clothing", clothing); }
    public void setDining(double dining) {wants.put("Dining", dining);}
    public void setMemberships(double memberships) {
        wants.put("Memberships", memberships);
    }

    public void setTravel(double travel) {
        wants.put("Travel", travel);
    }

    public void setStreamingServices(double streamingServices) {
        wants.put("Streaming Services", streamingServices);
    }

    public void setWantsOther(double wantsOther) {
        wants.put("Other Wants", wantsOther);
    }


    //Finance setter and puts for hashmap
    public void setSavings(double savings) {this.savings = savings;}

    public void setRetirement(double retirement) {
        this.retirement = retirement;
    }

    public void setCcPayments(double ccPayments) {
        this.ccPayments = ccPayments;
    }

    public void setLoanPayments(double loanPayments) {
        this.loanPayments = loanPayments;
    }

    public void setSavingsOther(double savingsOther) {this.savingsOther = savingsOther;}
    public void setDebtsOther(double debtsOther) {this.debtsOther = debtsOther;}


    //Hashmap to store all values
    public HashMap<String, Double> needs = new HashMap<>();

    private HashMap<String,Double> wants = new HashMap<>();




    //Calculate sum needs values in hashmap
    public double getTotalNeeds(){
        double needsTotal = 0;

        for (double value : needs.values()){
            needsTotal+=value;
        }
       return needsTotal;
    }
    //Calculate sum wants values in hashmap
    public double getTotalWants(){
        double wantsTotal = 0;

        for (double value : wants.values()){
            wantsTotal+=value;
        }
        return wantsTotal;
    }
    //Return totals
    public double getTotalFinance(){
        return (savings + retirement +savingsOther) - (ccPayments + loanPayments +debtsOther);
    }
    //Calculate net speeding
    public double getIncome(){
        return income + otherIncome;
    }

}