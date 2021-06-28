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

public class Myc extends RecyclerView.Adapter<Myc.MycViewHolder> {

    Context context;

    ArrayList<cu> cu;

    public Myc(Context c , ArrayList<cu> p)
    {
        context = c;
        cu = p;
    }

    @NonNull
    @Override
    public MycViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MycViewHolder(LayoutInflater.from(context).inflate(R.layout.cardviewc,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MycViewHolder holder, int position) {

        holder.location.setText(cu.get(position).getLocation());

        holder.Type.setText(cu.get(position).getType());
        final String s= cu.get(position).getUsrid();
        final String t= cu.get(position).getType();
        final String c= cu.get(position).getClkey();
        final String i1=cu.get(position).getImgurl();
        final String i2=cu.get(position).getImgurl1();


        holder.Type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), Detailedc.class);
                intent.putExtra("key",s);
                intent.putExtra("t",t);
                intent.putExtra("c",c);
intent.putExtra("i1",i1);
                intent.putExtra("i2",i2);

                v.getContext().startActivity(intent);


            }
        });


    }

    @Override
    public int getItemCount() {
        return cu.size();
    }

    class MycViewHolder extends RecyclerView.ViewHolder
    {
        TextView location,Type;


        public MycViewHolder(View itemView) {

            super(itemView);

            location = (TextView) itemView.findViewById(R.id.location);
            Type = (TextView) itemView.findViewById(R.id.typee);


        }


    }

}
