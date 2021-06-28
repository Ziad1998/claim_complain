package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class Detailed2 extends AppCompatActivity {
    TextView reply,stat;


    private FirebaseAuth mFirebaseAuth;

    private DatabaseReference mDatabase,mdatabase2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed2);
        mFirebaseAuth = FirebaseAuth.getInstance();
        stat=(TextView)findViewById(R.id.status);
        reply=(TextView) findViewById(R.id.rer);


        Bundle extras = getIntent().getExtras();




        final String v=getIntent().getStringExtra("key");
        final String c=getIntent().getStringExtra("c");



        mDatabase= FirebaseDatabase.getInstance().getReference("Complaints").child(v).child(c);

        mDatabase.addValueEventListener(new ValueEventListener() {
            ArrayList<Complaint> complaints = new ArrayList<>();


            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                Complaint complaints = dataSnapshot.getValue(Complaint.class);


                reply.setText(complaints.getReply());
                if(complaints.getReply()==null)
                {
                    stat.setText("pending");
                    stat.setTextColor(Color.parseColor("#FFFFFF"));
                }
                else
                {
                    stat.setText("acepted");
                    stat.setTextColor(Color.parseColor("#000000"));

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Detailed2.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();

            }
        });






    }


}
