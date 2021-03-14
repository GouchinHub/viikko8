package com.example.v8t3;

public class Bottle {
    private String name;
    private String manufacturer;
    private double total_energy;
    private double bottle_size;
    private double price;
    private int sizeIndex;
    private int nameIndex;
    public Bottle(int nI, int sI, String name1, String manuf, double totE, double size, double cost){
        nameIndex = nI;
        sizeIndex = sI;
        name = name1;
        manufacturer = manuf;
        total_energy = totE;
        bottle_size = size;
        price = cost;
    }
    public int getID(){
        return nameIndex;
    }

    public int getSizeID(){
        return sizeIndex;
    }

    public String getName(){
        return name;
    }

    public String getManufacturer(){ return manufacturer; }

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