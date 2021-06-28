package com.example.myapplication;

import android.content.Context;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;


import java.time.Year;
import java.util.ArrayList;

public class My extends RecyclerView.Adapter<My.MyViewHolder> {

    Context context;

    ArrayList<Complaint> Complaint;

    public My(Context c , ArrayList<Complaint> p)
    {
        context = c;
        Complaint = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.location.setText(Complaint.get(position).getLocation());

        holder.Description.setText(Complaint.get(position).getDescription());
       final String s= Complaint.get(position).getUsrid();
        final String t= Complaint.get(position).getType();
        final String c= Complaint.get(position).getCompkey();


        Picasso.get().load(Complaint.get(position).getImgurl()).into(holder.Imgurl);
        holder.Imgurl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), Detailed.class);
                intent.putExtra("key",s);
                intent.putExtra("t",t);
                intent.putExtra("c",c);


                v.getContext().startActivity(intent);


            }
        });


    }

    @Override
    public int getItemCount() {
        return Complaint.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView location,Description;
        ImageView Imgurl;


        public MyViewHolder(View itemView) {

            super(itemView);

            location = (TextView) itemView.findViewById(R.id.location);
            Description = (TextView) itemView.findViewById(R.id.describtion);
            Imgurl = (ImageView) itemView.findViewById(R.id.profileeee);

        }


    }

}
