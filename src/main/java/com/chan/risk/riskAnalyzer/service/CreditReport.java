package com.chan.risk.riskAnalyzer.service;

public class CreditReport {
    private String sector;
    private double totalExposure;
    private int numberOfFacilities;
    private int numberOfCustomers;

    public CreditReport(String sector, double totalExposure, int numberOfFacilities, int numberOfCustomers) {
        this.sector = sector;
        this.totalExposure = totalExposure;
        this.numberOfFacilities = numberOfFacilities;
        this.numberOfCustomers = numberOfCustomers;
    }

    public String getSector() {
        return sector;
    }

    public double getTotalExposure() {
        return totalExposure;
    }

    public int getNumberOfFacilities() {
        return numberOfFacilities;
    }

    public int getNumberOfCustomers() {
        return numberOfCustomers;
    }

    @Override
    public String toString() {
        return "CreditReport{" +
                "sector='" + sector + '\'' +
                ", totalExposure=" + totalExposure +
                ", numberOfFacilities=" + numberOfFacilities +
                ", numberOfCustomers=" + numberOfCustomers +
                '}';
    }
}
