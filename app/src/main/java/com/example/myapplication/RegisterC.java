package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class RegisterC extends AppCompatActivity {
    EditText emailId, password,usernam,mobilee;
    EditText Editphone,Editcode;
    String codesent;
    Button btnSignUp,verify;
    TextView tvSignIn;
    private  FirebaseAuth mFirebaseAuth;
    private static int flag1;
    private static int flag2;
    private static int flag3;
    private static int flag4;
    DatabaseReference mDatabase;
    String register="claims";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration config = getResources().getConfiguration();

        if (config.smallestScreenWidthDp >= 600)
        {
            setContentView(R.layout.activity_register_c);
        }
        else
        {
            setContentView(R.layout.activity_register_c);
        }
        mFirebaseAuth = FirebaseAuth.getInstance();

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Register");

        emailId = findViewById(R.id.email);
        password = findViewById(R.id.password);
        usernam=findViewById(R.id.username);

        Editphone=findViewById(R.id.mobilen);

        btnSignUp = findViewById(R.id.btn);




        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String email = emailId.getText().toString();
                final String pwd = password.getText().toString();
                final String mobile = Editphone.getText().toString();
                final String name = usernam.getText().toString();

                if (email.length() < 8){
                    Toast.makeText(RegisterC.this,"email must be at least  8 charachters",Toast.LENGTH_SHORT).show();
                }else if (email.isEmpty()){
                    Toast.makeText(RegisterC.this,"Please enter email",Toast.LENGTH_SHORT).show();

                }

                if (pwd.length() < 8){
                    Toast.makeText(RegisterC.this,"password must be at least  8 charachters",Toast.LENGTH_SHORT).show();

                } else if (pwd.isEmpty()){
                    Toast.makeText(RegisterC.this,"Please password name",Toast.LENGTH_SHORT).show();

                }

                if (mobile.length() < 11){
                    Toast.makeText(RegisterC.this,"mobile must be at least  8 charachters",Toast.LENGTH_SHORT).show();

                }else if (mobile.isEmpty()){
                    Toast.makeText(RegisterC.this,"Please enter mobile",Toast.LENGTH_SHORT).show();

                }
                if (name.length() < 3){
                    Toast.makeText(RegisterC.this,"name must be at least  8 charachters",Toast.LENGTH_SHORT).show();

                }else if (name.isEmpty()){
                    Toast.makeText(RegisterC.this,"Please enter name",Toast.LENGTH_SHORT).show();
                }


                else{


                    //connect with firebase Auth
                    mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(RegisterC.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(RegisterC.this,"error ",Toast.LENGTH_SHORT).show();
                            }
                            else {

                                String user_id=mFirebaseAuth.getCurrentUser().getUid();
                                DatabaseReference current_user_db =mDatabase.child(user_id);
                                current_user_db.child("email").setValue(email);
                                current_user_db.child("password").setValue(pwd);
                                current_user_db.child("Mobile").setValue(mobile);

                                current_user_db.child("username").setValue(name);

                                current_user_db.child("Claim Or Complain").setValue(register);


                                FirebaseUser user = mFirebaseAuth.getCurrentUser();

                                Intent i = new Intent(RegisterC.this, LoginC.class);
                                startActivity(i);
                            }

                        }

                    });
                }


            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mFirebaseAuth.getCurrentUser();
    }


}
