package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class c extends AppCompatActivity {

     Button buttonProfile,buttonabout,buttonLogin,buttonReg,buttonView,buttonMake,buttonexit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        buttonabout =(Button)findViewById(R.id.buttonabout);

        buttonLogin =(Button)findViewById(R.id.buttonLogin);
        buttonabout =(Button)findViewById(R.id.buttonabout);
        buttonReg =(Button)findViewById(R.id.buttonReg);
        buttonexit=(Button)findViewById(R.id.buttonexit);

        buttonexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
                System.exit(0);
            }
        });



       buttonReg.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getBaseContext(),register.class);
               startActivity(intent);

           }
       });
        buttonabout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),about.class);
                startActivity(intent);


            }
        });
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),login.class);
                startActivity(intent);

            }
        });


    }
}
