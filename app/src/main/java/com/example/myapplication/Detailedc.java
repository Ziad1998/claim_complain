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
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;


public class Detailedc extends AppCompatActivity {
    TextView emailId,Describtion;
    TextView username;
    TextView mobile;
    TextView type,ii;
    EditText reply;
    ImageView imgg1,imgg2;
    Button sub;
    int count=1;
    Random r = new Random();
    private FirebaseAuth mFirebaseAuth;

    private DatabaseReference mDatabase,mdatabase2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailedc);
        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId=(TextView)findViewById(R.id.email);
        type=(TextView)findViewById(R.id.typee);
        Describtion=(TextView)findViewById(R.id.describtion);
        username=(TextView)findViewById(R.id.name);
        reply=(EditText)findViewById(R.id.replyu);
imgg1=(ImageView)findViewById(R.id.nat);
        imgg2=(ImageView)findViewById(R.id.nat2);
        ii=(TextView)findViewById(R.id.ipadd);

        final int randomNumber = r.nextInt(100);

        mobile=(TextView)findViewById(R.id.mobil);

        Bundle extras = getIntent().getExtras();

        sub=(Button) findViewById(R.id.buttonsave);

        final String v=getIntent().getStringExtra("key");
        final String c=getIntent().getStringExtra("c");


        mdatabase2 = FirebaseDatabase.getInstance().getReference().child("Claims").child(v).child(c);
        final String tt=getIntent().getStringExtra("t");
final String i1=getIntent().getStringExtra("i1");

        final String i2=getIntent().getStringExtra("i2");

        sub.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {

                mdatabase2.addValueEventListener(new ValueEventListener() {
                    ArrayList<cu> claims = new ArrayList<>();


                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
if(count==1) {
    cu claims = dataSnapshot.getValue(cu.class);
    String r = reply.getText().toString();
    claims.setReply(r);
    claims.setCasenumber(String.valueOf(randomNumber));
count+=1;

    mdatabase2.setValue(claims);
    Toast.makeText(Detailedc.this, "Feedback Sent", Toast.LENGTH_SHORT).show();
}
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(Detailedc.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });


        mDatabase= FirebaseDatabase.getInstance().getReference("Register").child(v);







        mdatabase2.addValueEventListener(new ValueEventListener() {
            ArrayList<cu> claims = new ArrayList<>();


            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                cu claims = dataSnapshot.getValue(cu.class);

                Describtion.setText(claims.getDescription());
ii.setText(claims.getIp());



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Detailedc.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();

            }
        });



        mDatabase.addValueEventListener(new ValueEventListener() {
            ArrayList<User> user = new ArrayList<>();


            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                User user = dataSnapshot.getValue(User.class);


                mobile.setText(user.getMobile());
                emailId.setText(user.getEmail());
                username.setText(user.getUsername());
                type.setText(tt);

                Picasso.get().load(i1).into(imgg1);
                Picasso.get().load(i2).into(imgg2);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Detailedc.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();

            }
        });






    }


}
