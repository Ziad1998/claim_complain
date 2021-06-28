package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Afterlogin extends AppCompatActivity {
    ImageView img1; ImageView img2; ImageView img3; ImageView img4; ImageView img5; ImageView img6;
    TextView txt1;TextView txt2;TextView txt3;TextView txt4;TextView txt5;TextView txt6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Configuration config = getResources().getConfiguration();
        super.onCreate(savedInstanceState);
        if (config.smallestScreenWidthDp >= 600)
        {
            setContentView(R.layout.activity_afterlogin);
        }
        else
        {
            setContentView(R.layout.activity_afterlogin);
        }
        txt1 =(TextView) findViewById(R.id.firstv);
        txt2 =(TextView) findViewById(R.id.secondv);
        txt3 =(TextView) findViewById(R.id.thirdv);
        txt4 =(TextView) findViewById(R.id.forthv);
        txt5 =(TextView) findViewById(R.id.fifthv);
        txt6 =(TextView) findViewById(R.id.sixthv);


        img1 = (ImageView) findViewById(R.id.first);
        img2 = (ImageView) findViewById(R.id.second);

        img3 = (ImageView) findViewById(R.id.third);
        img4 = (ImageView) findViewById(R.id.forth);
        img5 = (ImageView) findViewById(R.id.fifth);
        img6 = (ImageView) findViewById(R.id.sixth);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mainIntent = new Intent(Afterlogin.this,
                        first.class);
                startActivity(mainIntent);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(Afterlogin.this,
                        second.class);
                startActivity(mainIntent);
            }
        }); img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(Afterlogin.this,
                        third.class);
                startActivity(mainIntent);
            }
        }); img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(Afterlogin.this,
                        forth.class);
                startActivity(mainIntent);
            }
        }); img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(Afterlogin.this,
                        fifth.class);
                startActivity(mainIntent);
            }
        }); img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(Afterlogin.this,
                        sixth.class);
                startActivity(mainIntent);
            }
        });










        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(Afterlogin.this,
                        first.class);
                startActivity(mainIntent);
            }
        });
        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(Afterlogin.this,
                        second.class);
                startActivity(mainIntent);
            }
        }); txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(Afterlogin.this,
                        third.class);
                startActivity(mainIntent);
            }
        }); txt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(Afterlogin.this,
                        forth.class);
                startActivity(mainIntent);
            }
        }); txt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(Afterlogin.this,
                        fifth.class);
                startActivity(mainIntent);
            }
        }); txt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(Afterlogin.this,
                        sixth.class);
                startActivity(mainIntent);
            }
        });
    }
}
