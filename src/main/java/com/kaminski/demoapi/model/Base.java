package com.kaminski.demoapi.model;

import java.util.ArrayList;

public class Base {
    private float amount;
    private String base;
    private String date;
    private Rates rates;




    // Getter Methods

    public float getAmount() {
        return amount;
    }

    public String getBase() {
        return base;
    }

    public String getDate() {
        return date;
    }

    public Rates getRates() {return rates;}

    // Setter Methods

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setRatesObject(Rates rates) { this.rates = rates;}
}

