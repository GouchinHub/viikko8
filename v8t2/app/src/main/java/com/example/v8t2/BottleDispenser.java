package com.example.v8t2;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class BottleDispenser {

    private static BottleDispenser bd = new BottleDispenser();

    private BottleDispenser() {
        money = 0;
        String name = "Pepsi Max";
        String manuf = "Pepsi";
        Double totE = 0.3;
        Double size = 0.5;
        Double cost = 1.80;
        Bottle newBottle = new Bottle(name,manuf,totE,size,cost);
        bottle_array.add(newBottle);
        newBottle = new Bottle(name,manuf,totE,1.5,2.2);
        bottle_array.add(newBottle);
        newBottle = new Bottle("Coca-Cola Zero","Coca-Cola",totE,size,2.0);
        bottle_array.add(newBottle);
        newBottle = new Bottle("Coca-Cola Zero","Coca-Cola",totE,1.5,2.5);
        bottle_array.add(newBottle);
        newBottle = new Bottle("Fanta Zero","Fanta",totE,size,1.95);
        bottle_array.add(newBottle);
    }

    public static BottleDispenser getInstance() {
        return bd;
    }
    ArrayList<Bottle> bottle_array = new ArrayList<Bottle>();
    private double money;
    private String wholeString = "";

    public String showMoney() {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(money);
    }

    public void addMoney() {
        money += 1;
    }

    public String buyBottle(int choice) {
        try {
            bottle_array.get(choice-1);
        } catch (IndexOutOfBoundsException exception) {
            wholeString = ("Out of order!");
            return wholeString;
        }
        if(money < bottle_array.get(choice-1).getPrice()){
            wholeString = ("Add money first!");
        } else {
            money -= bottle_array.get(choice-1).getPrice();
            wholeString = ("KACHUNK! "+ bottle_array.get(choice-1).getName() +" came out of the dispenser!");
            bottle_array.remove(choice-1);
        }
        return wholeString;
    }

    public String returnMoney() {
        if(money == 0){
            wholeString = "Klink klink!! All money gone!";
        } else {
            DecimalFormat df = new DecimalFormat("0.00");
            wholeString = "Klink klink. Money came out! You got "+ df.format(money) +"€ back";
            money = 0;
        }
        return wholeString;
    }

    public String listBottles() {
        int i = 0;
        wholeString = "";
        for (Bottle bottle : bottle_array) {
            i++;
            wholeString = wholeString + (i+". Name: " +bottle.getName()+"\n");
            wholeString = wholeString + ("\tSize: " +bottle.getSize() +"\tPrice: "+bottle.getPrice()+"\n\n");
        }
        return wholeString;
    }
}

