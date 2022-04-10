package com.kaminski.demoapi.model;


import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
@Table(name="ratesearch")
public class RateSearch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;


    private String rateDate;
    private String searchDate;
    private float usd =checkUSDvalue();




    @PrePersist
    protected void onCreate() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        searchDate = dateFormat.format(date);
    }

    public Float  checkUSDvalue() throws IOException {
//        String urlString = "https://api.frankfurter.app/"+rateDate+"?to=USD";
        String urlString = "https://api.frankfurter.app/1999-02-22?to=USD";

        URL url = new URL(urlString);
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        Base base = new Gson().fromJson(br.readLine(), Base.class);
        this.rateDate=rateDate+"test";
        return base.getRates().getUSD();
    }


    public RateSearch() throws IOException {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRateDate(String rateDate) {
        this.rateDate = rateDate;
    }

    public void setSearchDate(String searchDate) {
        this.searchDate = searchDate;
    }

    public void setUsd(float usd) {
        this.usd = usd;
    }

    public int getId() {
        return id;
    }

    public String getRateDate() {
        return rateDate;
    }

    public String getSearchDate() {
        return searchDate;
    }

    public float getUsd() {
        return usd;
    }



}
