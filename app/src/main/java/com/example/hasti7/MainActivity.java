package com.example.hasti7;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText amount,rate,numberofmonths;
    Button calculate;

    TextView txtemi,TotalAmt,txtRateAmt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amount.findViewById(R.id.amount);
        rate.findViewById(R.id.rate);
        numberofmonths.findViewById(R.id.numberofmonths);
        calculate.findViewById(R.id.calculate);
        txtemi.findViewById(R.id.txtemi);
        TotalAmt.findViewById(R.id.TotalAmt);
        txtRateAmt.findViewById(R.id.txtRateAmt);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int amt = Integer.parseInt(amount.getText().toString());
                double inrate = Double.parseDouble(rate.getText().toString());
                int months = Integer.parseInt(numberofmonths.getText().toString());

                double r = inrate/(12*100);
                double cal1 = 1;
                for (int i = 0; i < months; i++) {
                    cal1 *= (1+r);
                }

                double ans = amt * r * (cal1/(cal1-1));
                txtemi.setText("EMI : "+ans);
                double total = ans*months;
                TotalAmt.setText("Total Amount : "+total);
                double iAmt = total-amt;
                txtRateAmt.setText("Interest Amount  : "+iAmt);
            }
        });



    }
}