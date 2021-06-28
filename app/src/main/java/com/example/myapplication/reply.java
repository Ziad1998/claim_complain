package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class reply extends AppCompatActivity {
TextView type,stat;    private FirebaseAuth mFirebaseAuth;

    private DatabaseReference mDatabase;
    private RecyclerView recyclerView;
    u adapter;
    private DatabaseReference mdatabase2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply);
        recyclerView = (RecyclerView)findViewById(R.id.re);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        mFirebaseAuth = FirebaseAuth.getInstance();
        type=(TextView)findViewById(R.id.reply);stat=(TextView)findViewById(R.id.status);
        Bundle extras = getIntent().getExtras();




        final String v=getIntent().getStringExtra("key");
        final String c=getIntent().getStringExtra("c");
        String user_id = mFirebaseAuth.getCurrentUser().getUid();
        mdatabase2 = FirebaseDatabase.getInstance().getReference().child("Complaints").child(user_id);








        mdatabase2.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                ArrayList<Complaint> complaints = new ArrayList<>();




                for (DataSnapshot child : dataSnapshot.getChildren()) {

                    Complaint c = child.getValue(Complaint.class);
                    complaints.add(c);



                }
                adapter = new u(reply.this,complaints);
                recyclerView.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(reply.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();

            }
        });


    }
    @Override
    protected void onStart() {
        super.onStart();
    }
}
