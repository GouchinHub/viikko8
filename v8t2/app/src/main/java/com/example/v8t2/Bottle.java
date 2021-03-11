package com.example.v8t2;

public class Bottle {
    private String name;
    private String manufacturer;
    private double total_energy;
    private double bottle_size;
    private double price;
    public Bottle(String name1, String manuf, double totE, double size, double cost){
        name = name1;
        manufacturer = manuf;
        total_energy = totE;
        bottle_size = size;
        price = cost;
    }
    public String getName(){
        return name;
    }

    public String getManufacturer(){
        return manufacturer;

    }
    public Double getEnergy(){
        return total_energy;
    }

    public Double getSize(){
        return bottle_size;
    }

    public Double getPrice(){
        return price;
    }
}