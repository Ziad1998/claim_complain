package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MakeClaim extends AppCompatActivity {
    LinearLayout ll1; LinearLayout ll2; LinearLayout ll3; LinearLayout ll4;
    TextView txt1;TextView txt2;TextView txt3;TextView txt4;TextView txt5;TextView txt6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Configuration config = getResources().getConfiguration();

        super.onCreate(savedInstanceState);
        if (config.smallestScreenWidthDp >= 600)
        {
            setContentView(R.layout.activity_make_claim);
        }
        else
        {
            setContentView(R.layout.activity_make_claim);
        }
        txt1 =(TextView) findViewById(R.id.firstv);
        txt2 =(TextView) findViewById(R.id.secondv);
        txt3 =(TextView) findViewById(R.id.thirdv);
        txt4 =(TextView) findViewById(R.id.forthv);
        txt5 =(TextView) findViewById(R.id.fifthv);
        txt6 =(TextView) findViewById(R.id.sixthv);


        ll1 = (LinearLayout) findViewById(R.id.l1);
        ll2= (LinearLayout) findViewById(R.id.l2);

        ll3 = (LinearLayout) findViewById(R.id.l3);
        ll4 = (LinearLayout) findViewById(R.id.l4);










        ll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(MakeClaim.this,
                        firstc.class);
                startActivity(mainIntent);
            }
        });
         ll2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(MakeClaim.this,
                        thirdc.class);
                startActivity(mainIntent);
            }
        }); ll3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(MakeClaim.this,
                        forthc.class);
                startActivity(mainIntent);
            }
        });  ll4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(MakeClaim.this,
                        secondc.class);
                startActivity(mainIntent);
            }
        });
    }
}
