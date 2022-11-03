package com.example.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.graphics.Color;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.models.Address;
import com.example.myapp.models.Company;
import com.example.myapp.models.Geo;
import com.example.myapp.models.User;

import java.util.List;
import java.util.Random;

public class ParseAdapter extends RecyclerView.Adapter<ParseAdapter.MyViewHolder> {

    Context context;
    List<User> list;
    int selectedPosition=-1;


    public ParseAdapter(Context context, List<User> list) {

        this.context = context;
        this.list = list;

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_items, parent, false);
        return new ParseAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParseAdapter.MyViewHolder holder, int position) {

        User user = list.get(position);

        holder.itemView.setBackgroundColor(Color.parseColor("#534f58"));

        if(selectedPosition==position)
            holder.itemView.setBackgroundColor(Color.parseColor("#534f58"));
        else
            holder.itemView.setBackgroundColor(Color.parseColor("#ffffff"));



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, ""+user.getName(), Toast.LENGTH_SHORT).show();
                selectedPosition=position;
                notifyDataSetChanged();


            }
        });



        String userDetails = user.getId() + "\n" + user.getName() + "\n" + user.getUsername() + "\n" + user.getEmail();
        Address address=user.getAddress();
        if (address != null) {
            String street = address.getStreet();
            String suit = address.getSuite();
            String city = address.getCity();
            String zipcode = address.getZipcode();
            String address_details = address.getStreet() + "\n" + address.getSuite() + "\n" + address.getCity() + "\n" + address.getZipcode();
            holder.address.setText(address_details);
            Geo geo=address.getGeo();
            if (geo != null) {
                String lat = geo.getLat();
                String lng = geo.getLng();
                String geo_details = address.getGeo().getLat();
                holder.geo.setText(geo_details);
            }

        }
        Company company = user.getCompany();

        if (company != null) {
            String name = company.getName();
            String catchPhrase = company.getCatchPhrase();
            String bs = company.getBs();
            String Company_details = company.getName() + "\n" + company.getCatchPhrase() + "\n" + company.getBs();
            holder.company.setText(Company_details);
        }

        holder.user.setText(userDetails);

    }

        @Override
        public int getItemCount () {
            return list.size();
        }



    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView user, address, company, geo;

        public MyViewHolder(@NonNull View itemview) {
            super(itemview);
            user = itemview.findViewById(R.id.user);
            address = itemview.findViewById(R.id.address);
            geo = itemview.findViewById(R.id.geo);
            company = itemview.findViewById(R.id.company);

        }
    }
}
