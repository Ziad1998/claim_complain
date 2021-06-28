package com.example.myapplication;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
import java.util.List;


public class Admin_page extends AppCompatActivity {
    Button buttonfeed,buttonclaim,buttonlogout;
    TextView welcome;
    private FirebaseAuth mFirebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);
        mFirebaseAuth = FirebaseAuth.getInstance();
        welcome=(TextView)findViewById(R.id.usrlogin);
        buttonclaim =(Button)findViewById(R.id.buttonmake);
        buttonlogout=(Button)findViewById(R.id.logout);


        buttonfeed =(Button)findViewById(R.id.buttonview);
        buttonfeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),feedback.class);
                startActivity(intent);
            }
        });


        buttonlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent i= new Intent(Admin_page.this,login.class);
                startActivity(i);

            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();
    }

}
