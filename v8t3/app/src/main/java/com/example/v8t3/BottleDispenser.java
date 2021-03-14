package com.example.v8t3;

import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class BottleDispenser {

    private static BottleDispenser bd = new BottleDispenser();

    private BottleDispenser() {
        money = 0;
        Double totE = 0.3;
        for (int i = 0; i < 2; i++) {
            bottle_array.add(new Bottle(0,0,"Pepsi Max","Pepsi",totE,0.33,1.70));
            bottle_array.add(new Bottle(0,1,"Pepsi Max","Pepsi",totE,0.5,2.00));
            bottle_array.add(new Bottle(0,2,"Pepsi Max","Pepsi",totE,1.5,2.50));
            bottle_array.add(new Bottle(1,0,"Coca-Cola Zero","Coca-Cola",totE,0.33,1.70));
            bottle_array.add(new Bottle(1,1,"Coca-Cola Zero","Coca-Cola",totE,0.5,2.00));
            bottle_array.add(new Bottle(1,2,"Coca-Cola Zero","Coca-Cola",totE,1.5,2.50));
            bottle_array.add(new Bottle(2,0,"Fanta Zero","Fanta",totE,0.33,1.70));
            bottle_array.add(new Bottle(2,1,"Fanta Zero","Fanta",totE,0.5,2.00));
            bottle_array.add(new Bottle(2,2,"Fanta Zero","Fanta",totE,1.5,2.50));
        }
    }

    public static BottleDispenser getInstance() {
        return bd;
    }
    ArrayList<Bottle> bottle_array = new ArrayList<Bottle>();
    private double money;
    private String displayString = "";
    Bottle receiptItem = null;

    public String showMoney() {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(money);
    }

    public void addMoney(Double moneyAmount) {
        money += moneyAmount;
    }

    public String buyBottle(int nameIndex, int sizeIndex) {
        for (Bottle bottle : bottle_array ) {
            if ( bottle.getID() ==  nameIndex && bottle.getSizeID() == sizeIndex) {
                if(money < bottle.getPrice()){
                    return "Add money first!";
                } else {
                    money -= bottle.getPrice();
                    displayString = "KACHUNK! "+ bottle.getName() +" came out of the dispenser!";
                    receiptItem = bottle;
                    bottle_array.remove(bottle);
                    return displayString;
                }
            }
        }
        return "Out of order!";
    }

    public String returnMoney() {
        if(money == 0){
            return "Klink klink!! All money gone!";
        } else {
            DecimalFormat df = new DecimalFormat("0.00");
            displayString = "Klink klink. Money came out! You got "+ df.format(money) +"€ back";
            money = 0;
            return displayString;
        }
    }

    public Double fetchPrice(int sizeIndex, int nameIndex) {
        for (Bottle bottle : bottle_array ) {
            if ( bottle.getID() ==  nameIndex && bottle.getSizeID() == sizeIndex) {
                return bottle.getPrice();
            }
        }
        return 0.0;
    }
    public String fetchChoice(int sizeIndex, int nameIndex) {
        for (Bottle bottle : bottle_array ) {
            if ( bottle.getID() ==  nameIndex && bottle.getSizeID() == sizeIndex) {
                return bottle.getName()+" "+bottle.getSize()+"L";
            }
        }
        return "";
    }
    public String listBottles() {
        return "\n1. Pepsi Max\n\n2. Coca-Cola Zero\n\n3. Fanta\n";
    }

    public String getReceipt(){
        try {
            String receipt = ("\n~~~~~~~~~~~Receipt~~~~~~~~~~~"+
                    "\nOrder: "+receiptItem.getName()+
                    "\nManufacturer: "+receiptItem.getManufacturer()+
                    "\nSize: "+receiptItem.getSize()+
                    "\nTotal Energy: "+receiptItem.getEnergy()+
                    "\nPrice: "+receiptItem.getPrice()+
                    "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            return receipt;
        } catch (NullPointerException e){
            e.printStackTrace();
            return "";
        }
    }
}

