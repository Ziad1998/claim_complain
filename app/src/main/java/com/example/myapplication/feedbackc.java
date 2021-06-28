package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class feedbackc extends AppCompatActivity {


    private DatabaseReference mDatabase;
    private RecyclerView recyclerView;
    Myc adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedbackc);




        recyclerView = (RecyclerView)findViewById(R.id.re);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));

        mDatabase= FirebaseDatabase.getInstance().getReference("Claims");
        mDatabase.addValueEventListener(new ValueEventListener() {
            ArrayList<cu> claims = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    for (DataSnapshot secondLevel : child.getChildren()) {
                        cu c = secondLevel.getValue(cu.class);
                        claims.add(c);

                    }

                }
                adapter = new Myc(feedbackc.this,claims);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(feedbackc.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();

            }
        });




    }

}
