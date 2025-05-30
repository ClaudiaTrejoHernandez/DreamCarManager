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
    //Setters
    public void setSalesTax(double salesTax) { this.salesTax = salesTax; }
    public void setRecordingFee(double recordingFee) { this.recordingFee = recordingFee; }
    public void setProcessingFee(double processingFee) { this.processingFee = processingFee; }
    public void setFinance(boolean finance) { this.finance = finance; }

    @Override
    public double getTotalPrice() {
        salesTax = 0.05;
        recordingFee = 100.00;
        Contract contract = new SalesContract(getDate(), getCustomerName(), getCustomerEmail(), getVehicleSold(),
                getSalesTax(), getRecordingFee(), getProcessingFee(), isFinance()); // ← make an instance
        double price = contract.getVehicleSold().getPrice();
        if (price <= 10000.00)

        return 0;
    }

    @Override
    public double getMonthlyPayment() {
        return 0;
    }
}
