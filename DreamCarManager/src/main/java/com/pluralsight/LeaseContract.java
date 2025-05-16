package com.pluralsight;

public class LeaseContract extends Contract {
    private double expectedEndValue;
    private double leaseFee;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, double expectedEndValue, double leaseFee) {

        super(date, customerName, customerEmail, vehicleSold);
        this.expectedEndValue = expectedEndValue;
        this.leaseFee = leaseFee;
    }
    //Getters
    public double getExpectedEndValue() { return expectedEndValue; }
    public double getLeaseFee() { return leaseFee; }
    //Setters
    public void setExpectedEndValue(double expectedEndValue) { this.expectedEndValue = expectedEndValue; }
    public void setLeaseFee(double leaseFee) { this.leaseFee = leaseFee; }

    @Override
    public double getTotalPrice() {
        return 0;
    }

    @Override
    public double getMonthlyPayment() {
        return 0;
    }
}
