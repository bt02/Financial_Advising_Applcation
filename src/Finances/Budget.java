package Finances;

import java.util.HashMap;

public class Budget {

    private double income = 0;
    private double otherIncome = 0;

    //Needs
    private double rentMortgage = 0;
    private double homeInsurance = 0;
    private double autoInsurance = 0;
    private double healthInsurance = 0;
    private double utilities = 0;
    private double groceries = 0;
    private double gasoline = 0;
    private double phoneBill =0;
    private double needsOther = 0;

    //Wants
    private double clothing = 0;
    private double dining = 0;
    private double memberships = 0;
    private double travel = 0;
    private double streamingServices = 0;
    private double wantsOther = 0;

    //Finances
    private double savings = 0;
    private double retirement = 0;
    private double ccPayments = 0;
    private double loanPayments = 0;
    private double savingsOther = 0;
    private double debtsOther = 0;

    private double totalNeeds = 0;
    private double totalWants = 0;

    public void setIncome(double income) {
        this.income = income;

    }

    public void setOtherIncome(double otherIncome) {
        this.otherIncome = otherIncome;
    }

    //Needs setters and puts for hashmap
    public void setRentMortgage(double rentMortgage) {
        this.rentMortgage = rentMortgage;
        needs.put("Rent/Mortgage", rentMortgage);
    }


    public void setHomeInsurance(double homeInsurance) {
        this.homeInsurance = homeInsurance;
        needs.put("Home Insurance", homeInsurance);
    }

    public void setAutoInsurance(double autoInsurance) {
        this.autoInsurance = autoInsurance;
        needs.put("Auto Insurance" , autoInsurance);
    }

    public void setHealthInsurance(double healthInsurance) {
        this.healthInsurance = healthInsurance;
        needs.put("Health Insurance", healthInsurance);
    }

    public void setUtilities(double utilities) {
        this.utilities = utilities;
        needs.put("utilities", utilities);
    }

    public void setGroceries(double groceries) {
        this.groceries = groceries;
        needs.put("Groceries", groceries);
    }

    public void setGasoline(double gasoline) {
       this.gasoline = gasoline;
       needs.put("Gasoline", gasoline);
    }

    public void setPhoneBill(double phoneBill){
        this.phoneBill = phoneBill;
        needs.put("Phone Bill", phoneBill);
    }

    public void setNeedsOther(double needsOther) {
        this.needsOther = needsOther;
        needs.put("Other Needs", needsOther);
    }

    //Wants setter and puts for hashmap
    public void setClothing(double clothing) {
        this.clothing = clothing;
        wants.put("Clothing", clothing);
    }

    public void setDining(double dining) {
        this.dining = dining;
        wants.put("Dining", dining);

    }

    public void setMemberships(double memberships) {
        this.memberships = memberships;
        wants.put("Memberships", memberships);
    }

    public void setTravel(double travel) {
        this.travel = travel;
        wants.put("Travel", travel);
    }

    public void setStreamingServices(double streamingServices) {
        this.streamingServices = streamingServices;
        wants.put("Streaming Services", streamingServices);
    }

    public void setWantsOther(double wantsOther) {
        this.wantsOther = wantsOther;
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

    public double getTotalFinance(){
        return (savings + retirement +savingsOther) - (ccPayments + loanPayments +debtsOther);
    }
    //Calculate net speeding
    public double getIncome(){
        return income + otherIncome;
    }

}