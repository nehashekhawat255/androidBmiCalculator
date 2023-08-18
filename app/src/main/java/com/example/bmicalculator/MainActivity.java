package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText e1_height,e1_weight;
    Button b1_bmi;
    TextView t1_out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1_height=(EditText) findViewById(R.id.editText_height);
        e1_weight=(EditText) findViewById(R.id.editText_weight);
        b1_bmi=(Button) findViewById(R.id.button_bmi);
        t1_out=(TextView) findViewById(R.id.textView_bmi);

        b1_bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bmi_calc();
            }
        }
        );
    }

    public void bmi_calc(){
        String ht=e1_height.getText().toString();
        double height=Double.parseDouble(ht);
        String wt=e1_weight.getText().toString();
        double weight=Double.parseDouble(wt);

        double bmi_1=(weight/(height*height))*10000;
        double bmi=Math.round(bmi_1*10.0)/10.0;

        String output;

        if(bmi<=18.5){
            output="Your BMI is: " + bmi + " and you are underweight.";
        }
        else if (bmi>18.5 && bmi<=24.9) {

            output="Your BMI is: " + bmi + " and you are normal weight.";
        }
        else if (bmi>24.9 && bmi<=29.9) {

            output="Your BMI is: " + bmi + " and you are overweight.";
        }
        else{
            output="Your BMI is: " + bmi + " and you are obesity.";
        }

        t1_out.setText(output);
    }
}