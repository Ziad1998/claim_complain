package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
ImageButton imgb1,imgb2;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    Configuration config = getResources().getConfiguration();

    super.onCreate(savedInstanceState);

    if (config.smallestScreenWidthDp >= 700)
    {
      setContentView(R.layout.activity_main);
    }
    else
    {
      setContentView(R.layout.activity_main);
    }
    imgb1 =(ImageButton) findViewById(R.id.imgbutton1);
    imgb2=(ImageButton)findViewById(R.id.imgbutton2);
    imgb1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(getBaseContext(),c.class);
        startActivity(intent);


      }
    });
    imgb2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(getBaseContext(),Claimhome.class);
        startActivity(intent);


      }
    });

  }
}
