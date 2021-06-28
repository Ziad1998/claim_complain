package com.example.myapplication;

import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
public class LoginC extends AppCompatActivity {
    EditText emailId, password;
    Button btn;
    TextView tvSignUp;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_c);
        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.email);

        password = findViewById(R.id.password);
        btn = findViewById(R.id.btnlogin);

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if( mFirebaseUser != null ){

                    Toast.makeText(LoginC.this,"Login Please",Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(LoginC.this,"Please Login",Toast.LENGTH_SHORT).show();
                }
            }
        };

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailId.getText().toString();
                String pwd = password.getText().toString();
                   if(email.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(LoginC.this,"Fields Are Empty!",Toast.LENGTH_SHORT).show();
                }
                   else  if(email.isEmpty()){
                    emailId.setError("Please enter email");
                    emailId.requestFocus();
                }

                else  if(pwd.isEmpty()){
                    password.setError("Please enter your password");
                    password.requestFocus();
                }

                else  if(!(email.isEmpty() && pwd.isEmpty())){
                    mFirebaseAuth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(LoginC.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(LoginC.this,"Invalid email or password",Toast.LENGTH_SHORT).show();
                            }
                            else{

                                Intent intToHome = new Intent(LoginC.this,CC.class);
                                startActivity(intToHome);
                            }

                        }
                    });
                }
                else{
                    Toast.makeText(LoginC.this,"Error Occurred!",Toast.LENGTH_SHORT).show();

                }
                if(email.matches("AdminC")&& pwd.matches("1234"))
                {


                    Intent intToAdmin= new Intent(LoginC.this,Admin_pagec.class);
                    startActivity(intToAdmin);
                }

                if(email.matches("")&& pwd.matches(""))
                {

                    Toast.makeText(LoginC.this,"FIELDS ARE REQUIRED",Toast.LENGTH_SHORT).show();

                }
                if(email.matches("AdminC")&& pwd.isEmpty())
                {

                    password.setError("Please enter your password");
                    password.requestFocus();

                }
                if(email.isEmpty()&& pwd.matches("1234"))
                {
                    emailId.setError("Please enter email ");
                    emailId.requestFocus();

                }

            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }



}
