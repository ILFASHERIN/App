package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    CheckBox remember;
    Button btnlogin, btnregister;
    MyDHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.usernamelogib);
        password = (EditText) findViewById(R.id.passwordlogin);
        btnlogin = (Button) findViewById(R.id.btnlogin);
        btnregister = (Button) findViewById(R.id.btnregister);
        remember = findViewById(R.id.rememberMe);
        myDB = new MyDHelper(this);

        SharedPreferences preferences=getSharedPreferences("checkbox",MODE_PRIVATE);
        String checkbox=preferences.getString("remember","");
        if(checkbox.equals("true")){
            Intent intent=new Intent(LoginActivity.this,NavigationActivity.class);
            startActivity(intent);
        }else if(checkbox.equals("false")){
            Toast.makeText(this, "Please sign in", Toast.LENGTH_SHORT).show();
        }

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals("")){
                    Toast.makeText(LoginActivity.this, "Please enter the credentials.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean result = myDB.checkusernamePassword(user,pass);
                    if(result==true){
                        Toast.makeText(LoginActivity.this, "Login succesfull", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),NavigationActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "Invalid Credentials.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        remember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()) {
                    SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "true");
                    editor.apply();
                    Toast.makeText(LoginActivity.this, "Ceckbox", Toast.LENGTH_SHORT).show();
                } else if (!compoundButton.isChecked()) {
                    SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "false");
                    editor.apply();
                    Toast.makeText(LoginActivity.this, "Uncheckbox", Toast.LENGTH_SHORT).show();


                }
            }
        });


        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });



    }


}