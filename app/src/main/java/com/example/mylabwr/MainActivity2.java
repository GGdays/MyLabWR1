package com.example.mylabwr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void onBtnNewClick(View view) {
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String rmsType = (String) spinner.getSelectedItem();

        String txtTypes = "";
        String txtPrices = "";
        for (Room r : Room.getRooms(rmsType)) {
            txtTypes += r.getKind() + "\n";
            txtPrices += r.getPrice() + "\n";
        }
        TextView textType = (TextView) findViewById(R.id.textType);
        textType.setText("Hotel room type");
        TextView textPrice = (TextView) findViewById(R.id.textPrice);
        textPrice.setText("Price");

        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText(txtTypes);

        TextView textViewS = (TextView) findViewById(R.id.textS);
        textViewS.setText(txtPrices);
    }

    public void onBtnBackClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}