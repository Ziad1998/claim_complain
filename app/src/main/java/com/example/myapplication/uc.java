package com.example.myapplication;

import android.content.Context;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;


import java.time.Year;
import java.util.ArrayList;

public class uc extends RecyclerView.Adapter<uc.MyViewHolder> {

    Context context;

    ArrayList<cu> cu;

    public uc(Context c , ArrayList<cu> p)
    {
        context = c;
        cu = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview2c,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if(cu.get(position).getReply()!=null)
        {
            holder.stat.setText("Accepted");
            holder.stat.setTextColor(Color.parseColor("#00FF00"));
        };
        if(cu.get(position).getReply()==null)

        {
            holder.stat.setText("Pending");
            holder.stat.setTextColor(Color.parseColor("#FFFF00"));
        }
        holder.casee.setText(cu.get(position).getCasenumber());


        final String s= cu.get(position).getUsrid();
        final String c= cu.get(position).getClkey();


        holder.z.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), Detailedc2.class);
                intent.putExtra("key",s);
                intent.putExtra("c",c);
                v.getContext().startActivity(intent);


            }
        });




    }

    @Override
    public int getItemCount() {
        return cu.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView Description,stat,casee;
        LinearLayout z;



        public MyViewHolder(View itemView) {

            super(itemView);
            stat=(TextView)itemView.findViewById(R.id.status);
            Description = (TextView) itemView.findViewById(R.id.describtion);
            casee= (TextView) itemView.findViewById(R.id.casenumber);

            z=(LinearLayout)itemView.findViewById(R.id.rr);
        }


    }

}
