package com.example.myapp;

import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Myholder> {

    String data[];
    ContentInfo context;

    public RecyclerAdapter(String[] data){
        this.data=data;
        this.context=context;
    }
    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater LayoutInflater= android.view.LayoutInflater.from(parent.getContext());
        View view=LayoutInflater.inflate(R.layout.item_design,parent,false);
        Myholder myholder=new Myholder(view);
        return myholder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.Myholder holder, int position) {
        holder.textView.setText(data[position]);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, "Clicked on", Toast.LENGTH_SHORT).show();;
            }
        });

    }

    @Override
    public int getItemCount() {return data.length;}
    public class Myholder extends RecyclerView.ViewHolder{
        TextView textView;


        public Myholder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.fruits);
        }

    }
}
