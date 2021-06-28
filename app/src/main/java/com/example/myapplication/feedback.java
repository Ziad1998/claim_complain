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

public class feedback extends AppCompatActivity {

    int coi=0;

    private DatabaseReference mDatabase;
   private RecyclerView recyclerView;
    My adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);




        recyclerView = (RecyclerView)findViewById(R.id.re);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("ploc");        mDatabase.addValueEventListener(new ValueEventListener() {
            ArrayList<Complaint> complains = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    for (DataSnapshot secondLevel : child.getChildren()) {
                        Complaint c = secondLevel.getValue(Complaint.class);
                        complains.add(c);

                    }

                }
                adapter = new My(feedback.this,complains);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(feedback.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();

            }
        });




    }

}
