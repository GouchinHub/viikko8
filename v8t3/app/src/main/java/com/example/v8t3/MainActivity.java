package com.example.v8t3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {
    int buyState = 1;
    private BottleDispenser bd = BottleDispenser.getInstance();
    private TextView display, moneyView, priceView, bottle;
    private Toast toast;
    private SeekBar seekBar;
    private Button button;
    private Double amount = 0.00, price = 0.00;
    private int sizeID = 0, choice = 0;
    private Spinner sizes;
    private String receiptFile = "receipts.txt";
    Context context;
    DecimalFormat df = new DecimalFormat("0.00");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        //initialize all views
        moneyView = findViewById(R.id.moneyView);
        display = findViewById(R.id.listBottles);
        seekBar = findViewById(R.id.seekBar) ;
        button = findViewById(R.id.addButtom);
        sizes = findViewById(R.id.spinner);
        priceView = findViewById(R.id.moneyView2);
        bottle = findViewById(R.id.chosenBottle);
        display.setText(bd.listBottles());
        //Toast to send action reports to user
        toast = Toast.makeText(MainActivity.this," ",Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0,320);
        //spinner arraylist
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.sizes));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sizes.setAdapter(myAdapter);
        //SeekBar for different sizes
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                amount = new Double(progress / 10);
                button.setText(""+amount+"€");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    public void addMoney(View v) {
        bd.addMoney(amount);
        seekBar.setProgress(0);
        button.setText("Add coins");
        moneyView.setText(bd.showMoney());
    }

    public void buyBottle(View v) {
        toast.setText(bd.buyBottle(choice,sizeID));
        toast.show();
        moneyView.setText(bd.showMoney());
    }

    public void buyOption1(View v) {
        sizeID = (int) sizes.getSelectedItemId();
        choice = 0;
        if((price = bd.fetchPrice( sizeID,choice)) != 0.0){
            priceView.setText(df.format(price) + "€");
            bottle.setText(bd.fetchChoice(sizeID,choice));
        }
        else {
            toast.setText("Out of order!");
            toast.show();
        }

    }

    public void buyOption2(View v) {
        sizeID = (int) sizes.getSelectedItemId();
        choice = 1;
        if((price = bd.fetchPrice( sizeID,choice)) != 0.0){
            priceView.setText(df.format(price) + "€");
            bottle.setText(bd.fetchChoice(sizeID,choice));
        }
        else {
            toast.setText("Out of order!");
            toast.show();
        }
    }

    public void buyOption3(View v) {
        sizeID = (int) sizes.getSelectedItemId();
        choice = 2;
        if((price = bd.fetchPrice( sizeID,choice)) != 0.0){
            priceView.setText(df.format(price) + "€");
            bottle.setText(bd.fetchChoice(sizeID,choice));
        }
        else {
            toast.setText("Out of order!");
            toast.show();
        }
    }

    public void returnMoney(View v) {
        toast.setText(bd.returnMoney());
        toast.show();
        moneyView.setText(bd.showMoney());
    }
    //Files are found in /view/tool windows/device file manager
    //under /data/user/0/com.example.v8t3/files
    public void writeReciept(View v){
        try {
            OutputStreamWriter outPutter = new OutputStreamWriter(context.openFileOutput(receiptFile, Context.MODE_APPEND));
            outPutter.append(bd.getReceipt());
            outPutter.close();
            toast.setText("Receipt was written");
            toast.show();
        } catch (IOException e) {
            Log.e("IOExpection", "Error occurred writing file ");
        }

    }

}

