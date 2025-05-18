package com.pluralsight;

public class SalesContract extends Contract {
    private double salesTax;
    private double recordingFee;
    private double processingFee;
    private boolean finance;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, double salesTax,
                         double recordingFee, double processingFee, boolean finance) {

        super(date, customerName, customerEmail, vehicleSold);
        this.salesTax = salesTax;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.finance = finance;
    }
    //Getters
    public double getSalesTax() { return salesTax; }
    public double getRecordingFee() { return recordingFee; }
    public double getProcessingFee() { return processingFee; }
    public boolean isFinance() { return finance; }

    @Override
    public double getTotalPrice() {
        recordingFee = 100.00;
        double totalPrice;
        double price = getVehicleSold().getPrice();
        salesTax = price * 0.05;
        if (price <= 10000.00) {
            processingFee = 295.00;
            totalPrice = price + processingFee + recordingFee + salesTax;
            return totalPrice;
        } else {
            processingFee = 495.00;
            totalPrice = price + processingFee + recordingFee + salesTax;
            return totalPrice;
        }
    }

    @Override
    public double getMonthlyPayment() {
        int numberOfMonths;
        double interestRate;
        double total = getTotalPrice();

        double price = getVehicleSold().getPrice();
        if (finance) {
            if (price >= 10000) {
                numberOfMonths = 48;
                interestRate = 0.0425;
                 return (total + (total * interestRate)) / numberOfMonths;

            } else {
                numberOfMonths = 24;
                interestRate = 0.0525;
                return (total + (total * interestRate)) / numberOfMonths;
            }
        } else if (finance == false) {
            return 0.0;

        }
        return 0.0;
    }
}
