package com.example.v8t2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    int i = 4;
    private BottleDispenser bd = BottleDispenser.getInstance();
    private TextView display;
    private TextView moneyView;
    private Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        moneyView = findViewById(R.id.moneyView);
        display = findViewById(R.id.listBottles);
        display.setText(bd.listBottles());
        toast = Toast.makeText(MainActivity.this," ",Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM, 0,320);
    }
    public void addMoney(View v) {
        bd.addMoney();
        moneyView.setText(bd.showMoney());
    }
    public void buyOption1(View v) {
        toast.setText(bd.buyBottle(1));
        toast.show();
        display.setText(bd.listBottles());
        moneyView.setText(bd.showMoney());
    }
    public void buyOption2(View v) {
        toast.setText(bd.buyBottle(2));
        toast.show();
        display.setText(bd.listBottles());
        moneyView.setText(bd.showMoney());
    }
    public void buyOption3(View v) {
        toast.setText(bd.buyBottle(3));
        toast.show();
        display.setText(bd.listBottles());
        moneyView.setText(bd.showMoney());
    }
    public void buyOption4(View v) {
        toast.setText(bd.buyBottle(4));
        toast.show();
        display.setText(bd.listBottles());
        moneyView.setText(bd.showMoney());
    }
    public void buyOption5(View v) {
        toast.setText(bd.buyBottle(5));
        toast.show();
        display.setText(bd.listBottles());
        moneyView.setText(bd.showMoney());
    }

    public void returnMoney(View v) {
        toast.setText(bd.returnMoney());
        toast.show();
        moneyView.setText(bd.showMoney());
    }
}

