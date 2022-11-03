package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapp.models.Address;
import com.example.myapp.models.Company;
import com.example.myapp.models.Geo;
import com.example.myapp.models.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ParseDataActivity extends AppCompatActivity {
    private static final String TAG = "ParseData";
    RecyclerView recyclerView;
    ParseAdapter parseAdapter;

    List<User> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parse_data);




        RecyclerView recyclerView=findViewById(R.id.recycler_parse);
        recyclerView.setLayoutManager(new LinearLayoutManager(ParseDataActivity.this));
        parseAdapter = new ParseAdapter(ParseDataActivity.this,list);
        recyclerView.setAdapter(parseAdapter);

        Button button=findViewById(R.id.button_parse);

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url ="https://jsonplaceholder.typicode.com/users";
                JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Gson gson = new Gson();
                        Type type = new TypeToken<List<User>>() {
                        }.getType();
                        List<User> userList = gson.fromJson(response.toString(), type);
                        parseAdapter = new ParseAdapter(ParseDataActivity.this, userList);
                        recyclerView.setAdapter(parseAdapter);
                        parseAdapter.notifyDataSetChanged();
                        for (int i = 0; i < userList.size(); i++) {
                            User user = userList.get(i);
                            Address address = user.getAddress();
                            Company company = user.getCompany();
                            Geo geo = address.getGeo();

                        }
                        Log.d(TAG, "onResponse:" + userList.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ParseDataActivity.this,error.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
                requestQueue.add(jsonArrayRequest);
            }
        });

    }
}
