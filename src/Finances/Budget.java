package Finances;

import java.util.HashMap;

public class Budget {

    private double income = 0;
    private double otherIncome = 0;

    //Needs
    private double mortgage = 0;
    private double rent = 0;
    private double homeInsurance = 0;
    private double autoInsurance = 0;
    private double healthInsurance = 0;
    private double utilites = 0;
    private double groceries = 0;
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
    private double financeOther = 0; //needs setter

    private double totalNeeds = 0;
    private double totalWants = 0;

    public void setIncome(double income) {
        this.income = income;

    }

    public void setOtherIncome(double otherIncome) {
        this.otherIncome = otherIncome;
    }

    //Needs setters and puts for hashmap
    public void setMortgage(double mortgage) {
        this.mortgage = mortgage;
        needs.put("Mortgage", mortgage);
    }

    public void setRent(double rent) {
        this.rent = rent;
        needs.put("Rent", rent);
    }

    public void setHomeInsurance(double homeInsurance) {
        this.homeInsurance = homeInsurance;
        needs.put("Home Insurance", rent);
    }

    public void setAutoInsurance(double autoInsurance) {
        this.autoInsurance = autoInsurance;
    }

    public void setHealthInsurance(double healthInsurance) {
        this.healthInsurance = healthInsurance;
    }

    public void setUtilites(double utilites) {
        this.utilites = utilites;
    }

    public void setGroceries(double groceries) {
        this.groceries = groceries;
    }

    public void setNeedsOther(double needsOther) {
        this.needsOther = needsOther;
    }

    //Wants setter and puts for hashmap
    public void setClothing(double clothing) {
        this.clothing = clothing;
    }

    public void setDining(double dining) {
        this.dining = dining;
    }

    public void setMemberships(double memberships) {
        this.memberships = memberships;
    }

    public void setTravel(double travel) {
        this.travel = travel;
    }

    public void setStreamingServices(double streamingServices) {
        this.streamingServices = streamingServices;
    }

    public void setWantsOther(double wantsOther) {
        this.wantsOther = wantsOther;
    }

    public void setSavings(double savings) {
        this.savings = savings;
    }

    public void setRetirement(double retirement) {
        this.retirement = retirement;
    }

    public void setCcPayments(double ccPayments) {
        this.ccPayments = ccPayments;
    }

    public void setLoanPayments(double loanPayments) {
        this.loanPayments = loanPayments;
    }

    public void setOtherFinances(double otherFinances) {
        this.otherFinances = otherFinances;
    }

    private double otherFinances = 0;


    //Hashmap to store all values
    private HashMap<String, Double> needs = new HashMap<>();

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
    //Calculate net speeding
    public double getNetSpend(){
        return (income + otherIncome) - (getTotalNeeds() + getTotalWants());
    }

}