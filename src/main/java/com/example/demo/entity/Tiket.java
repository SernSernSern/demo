package com.example.demo.entity;

public class Tiket {

    private int id;
    private int destinationId;
    private int baggageId;
    private double money;

    public Tiket(int id, int destinationId, int baggageId, double money) {
        this.id = id;
        this.destinationId = destinationId;
        this.baggageId = baggageId;
        this.money = money;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(int destinationId) {
        this.destinationId = destinationId;
    }

    public int getBaggageId() {
        return baggageId;
    }

    public void setBaggageId(int baggageId) {
        this.baggageId = baggageId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
