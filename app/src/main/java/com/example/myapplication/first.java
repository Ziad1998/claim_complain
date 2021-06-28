package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.format.Formatter;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.content.pm.PackageManager;
import android.location.Location;
import android.provider.Settings;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;


public class first extends AppCompatActivity  {
    ImageView imagevieww;
    private StorageReference mStorageRef;
    private StorageTask mUploadTask;
    private EditText mEditTextFileName;


    private static final int RESULT_LOAD_IMAGE=1;
    private static final int REQUEST_LOCATION = 1;
    private static int flag1;
    private static int flag2;
    private static int flag3;

    private Uri mImageUri;
    private ProgressBar mProgressBar;

    private FirebaseAuth mFirebaseAuth;
    DatabaseReference mDatabase;
    Button uploadimage;
    EditText editpic;
    TextView textView;
    LocationManager locationManager;
    String lattitude,longitude;
    Button loct,save;
    String type="Product specify Problem";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        imagevieww=(ImageView)findViewById(R.id.imagevieww);
        save=(Button) findViewById(R.id.buttonsave);
        textView=(TextView)findViewById(R.id.textlocationn); mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Complaints");
        final String key = mDatabase.child("Complaints").push().getKey();
        mStorageRef = FirebaseStorage.getInstance().getReference("uploads");

        WifiManager wm = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        final String ip = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());
        loct=(Button) findViewById(R.id.locationbutton);
        ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);

        uploadimage=(Button) findViewById(R.id.uploadimage);
        editpic=(EditText)findViewById(R.id.editpic);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                final String describe = editpic.getText().toString();
                final String location = textView.getText().toString();

                if(describe.matches("")){
                    editpic.setError("Please enter description of complain");
                    editpic.requestFocus();
                    flag1=0;
                }
                if(mImageUri==null){
                    uploadimage.setError("Please enter description of complain");
                    uploadimage.requestFocus();
                }

                if(location.matches("")){
                    textView.setError("Location is required");
                    textView.requestFocus();
                    flag2=0;
                }
                if(location.length()>0){

                    flag2=1;
                }
                if(describe.length()>0){

                    flag1=1;
                }
                if((describe.matches("")&&location.matches("") && mImageUri==null))
                {
                    Toast.makeText(first.this,"Fields are required ",Toast.LENGTH_SHORT).show();
                    flag1=0;
                    flag2=0;

                }

                if(flag1==1 && flag2==1 ){


                    if (mUploadTask != null && mUploadTask.isInProgress()) {
                        Toast.makeText(first.this, "Upload in progress", Toast.LENGTH_SHORT).show();
                    } else {
                        if (mImageUri != null) {
                            final StorageReference fileReference = mStorageRef.child(System.currentTimeMillis()
                                    + "." + getFileExtension(mImageUri));

                            mUploadTask = fileReference.putFile(mImageUri);
                            Task<Uri> mUploadTask=fileReference.putFile(mImageUri).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                                @Override
                                public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                                    if (!task.isSuccessful()) {
                                        throw task.getException();
                                    }

                                    // Continue with the task to get the download URL
                                    return fileReference.getDownloadUrl();
                                }
                            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {
                                    if (task.isSuccessful()) {

                                        Toast.makeText(first.this, "Upload successful", Toast.LENGTH_LONG).show();
                                        Uri downloadUrl = task.getResult();
                                        String d=downloadUrl.toString();
                                        Toast.makeText(first.this, "Complain sent ", Toast.LENGTH_SHORT).show();

                                        String user_id = mFirebaseAuth.getCurrentUser().getUid();
                                        DatabaseReference current_user_db = mDatabase.child(user_id);
                                        current_user_db.child(key).child("location").setValue(location);
                                        current_user_db.child(key).child("Usrid").setValue(user_id);
                                        current_user_db.child(key).child("Description").setValue(describe);
                                        current_user_db.child(key).child("Imgurl").setValue(d);
                                        current_user_db.child(key).child("type").setValue(type);
                                        current_user_db.child(key).child("ip").setValue(ip);



                                        current_user_db.child(key).child("compkey").setValue(key);




                                        Intent i = new Intent(first.this, cl.class);
                                        startActivity(i);






                                    } else {
                                        // Handle failures
                                        // ...
                                    }

                                }
                            });



                        }
                        else
                        {
                            Toast.makeText(first.this, "no image selected", Toast.LENGTH_LONG).show();

                        }
                    }







                }









            }









        });
        uploadimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                openFileChooser();


            }




        });
        loct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);




                if (!locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                    buildAlertMessageNoGps();

                } else if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                    if (ActivityCompat.checkSelfPermission(first.this, Manifest.permission.ACCESS_FINE_LOCATION)
                            != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission
                            (first.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                        ActivityCompat.requestPermissions(first.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);

                    } else {
                        Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);



                        if (location != null) {
                            double latti = location.getLatitude();
                            double longi = location.getLongitude();
                            lattitude = String.valueOf(latti);
                            longitude = String.valueOf(longi);

                            textView.setText("Your current location is"  + "Lattitude = " + lattitude
                                    + "Longitude = " + longitude);

                        }

                    }
                }
            }

        });


    }
    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, RESULT_LOAD_IMAGE);
    }
    @Override
    protected void  onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
            mImageUri = data.getData();

            imagevieww.setImageURI(mImageUri);
        }


    }
    private String getFileExtension(Uri uri) {
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }



    protected void buildAlertMessageNoGps() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Please Turn ON your  Connection")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }


}
