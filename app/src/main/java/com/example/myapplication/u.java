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

public class u extends RecyclerView.Adapter<u.MyViewHolder> {

    Context context;

    ArrayList<Complaint> Complaint;

    public u(Context c , ArrayList<Complaint> p)
    {
        context = c;
        Complaint = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview2,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
if(Complaint.get(position).getReply()!=null)
{
    holder.stat.setText("Accepted");
    holder.stat.setTextColor(Color.parseColor("#00FF00"));
};
if(Complaint.get(position).getReply()==null)

{
            holder.stat.setText("Pending");
            holder.stat.setTextColor(Color.parseColor("#FFFF00"));
}
        holder.Description.setText(Complaint.get(position).getDescription());

        final String s= Complaint.get(position).getUsrid();
        final String c= Complaint.get(position).getCompkey();


        holder.z.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), Detailed2.class);
                intent.putExtra("key",s);
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
        TextView Description,stat;
        LinearLayout z;



        public MyViewHolder(View itemView) {

            super(itemView);
stat=(TextView)itemView.findViewById(R.id.status);
            Description = (TextView) itemView.findViewById(R.id.describtion);
z=(LinearLayout)itemView.findViewById(R.id.rr);
        }


    }

}
