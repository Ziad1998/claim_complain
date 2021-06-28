package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
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


public class Detailed extends AppCompatActivity {
    TextView emailId;
    TextView username;
    TextView mobile;
    TextView type,ii;
    EditText reply;
    Button sub;

    private FirebaseAuth mFirebaseAuth;

    private DatabaseReference mDatabase,mdatabase2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId=(TextView)findViewById(R.id.email);
        type=(TextView)findViewById(R.id.typee);
        username=(TextView)findViewById(R.id.name);
        ii=(TextView)findViewById(R.id.ipadd);

        reply=(EditText)findViewById(R.id.replyu);

        mobile=(TextView)findViewById(R.id.mobil);

        Bundle extras = getIntent().getExtras();

        sub=(Button) findViewById(R.id.buttonsave);
        FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();

        final String v=getIntent().getStringExtra("key");
        final String c=getIntent().getStringExtra("c");

        mdatabase2 = FirebaseDatabase.getInstance().getReference().child("Complaints").child(String.valueOf(mFirebaseUser));

        final String tt=getIntent().getStringExtra("t");



        sub.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {

                mdatabase2.addValueEventListener(new ValueEventListener() {
                    ArrayList<Complaint> complaints = new ArrayList<>();


                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                        Complaint complaints = dataSnapshot.getValue(Complaint.class);
String r=reply.getText().toString();
                        complaints.setReply(r);


mdatabase2.setValue(complaints);
                        Toast.makeText(Detailed.this, "Feedback Sent", Toast.LENGTH_SHORT).show();




                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(Detailed.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });

        mdatabase2.addValueEventListener(new ValueEventListener() {
            ArrayList<Complaint> complaints = new ArrayList<>();


            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Complaint complaints = dataSnapshot.getValue(Complaint.class);

               ii.setText(complaints.getIp());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Detailed.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();

            }
        });

    mDatabase= FirebaseDatabase.getInstance().getReference("Register").child(v);

        mDatabase.addValueEventListener(new ValueEventListener() {
            ArrayList<User> user = new ArrayList<>();


            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                User user = dataSnapshot.getValue(User.class);


                mobile.setText(user.getMobile());
                emailId.setText(user.getEmail());
                username.setText(user.getUsername());
                type.setText(tt);

            }



            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Detailed.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();

            }
        });


        mDatabase= FirebaseDatabase.getInstance().getReference("Complaints").child(v).child(c);

        mDatabase.addValueEventListener(new ValueEventListener() {
            ArrayList<Complaint> complaints = new ArrayList<>();


            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                Complaint complaint = dataSnapshot.getValue(Complaint.class);



                ii.setText(complaint.getIp());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Detailed.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();

            }
        });




    }


}
