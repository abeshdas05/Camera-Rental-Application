package com.camerarental;

public class CamDetails {
    private int camId = 1;
    private String brand;
    private String model;
    private double pricePerDay;
    private boolean status;

    public int getCamId() {
        return camId;
    }

    public void setCamId(int camId) {
        this.camId = camId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private static int nextId = 1;
    public CamDetails(String brand, String model, double pricePerDay) {
        super();
        this.camId = nextId;
        this.brand = brand;
        this.model = model;
        this.pricePerDay = pricePerDay;
        this.status = true;
        nextId++;
    }


}
