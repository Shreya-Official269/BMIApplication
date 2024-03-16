package com.example.bmiapplication;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtresult;
        EditText edtweight, edtHeightft, edtHeightIn;
        Button btncalc;

        edtweight = findViewById(R.id.edtweight);
        edtHeightft = findViewById(R.id.edtHeightft);
        edtHeightIn = findViewById(R.id.edtHeightIn);
        btncalc = findViewById(R.id.CalculateBMI);
        txtresult = findViewById(R.id.tvresult);
        LinearLayout llmain = findViewById(R.id.llmain);

        btncalc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(edtweight.getText().toString());
                int htf = Integer.parseInt(edtHeightft.getText().toString());
                int htI = Integer.parseInt(edtHeightIn.getText().toString());

                int totalinches = htf * 12 + htI;
                double totalcms = totalinches * 2.53;
                double totalmts = totalcms / 100;
                double bmi = wt / (totalmts * totalmts);

                if (bmi < 18) {
                    txtresult.setText("You are underweight");
                    llmain.setBackgroundColor(getResources().getColor(R.color.Orange));


                } else if (bmi > 25) {
                    txtresult.setText("You are Overweight");
                    llmain.setBackgroundColor(getResources().getColor(R.color.Skyblue));

                } else {
                    txtresult.setText("You are Healthy");
                    llmain.setBackgroundColor(getResources().getColor(R.color.Green));

                }


            }
        });
    }
}
