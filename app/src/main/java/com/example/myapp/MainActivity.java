package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    EditText username, email, password, repassword;
    TextView textView;
    String gender;
    Spinner country;
    Button btnSignUp, btnSignIn;
    MyDHelper myDB;
    RadioButton radiomale,radiofemale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        country = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.country, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        country.setAdapter(adapter);
        country.setOnItemSelectedListener(this);



        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        textView = (TextView) findViewById(R.id.textView);

        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);

        radiomale = findViewById(R.id.radioButton4);
        radiofemale = findViewById(R.id.radioButton3);
        myDB = new MyDHelper(this);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String mail = email.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                String count = country.getSelectedItem().toString();
                if(radiomale.isChecked()){
                    gender=radiomale.getText().toString();
                }
                else if(radiofemale.isChecked()){
                    gender=radiofemale.getText().toString();
                }
                if (user.equals("") || mail.equals("") || pass.equals("") || repass.equals("")) {
                    Toast.makeText(MainActivity.this, "Fill all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    if (pass.equals(repass)) {
                        Boolean usercheckResult = myDB.checkusername(user);
                        if (usercheckResult == false) {
                            Boolean regResult = myDB.insertData(user, mail, gender, pass, count);
                            if (regResult == true) {
                                Toast.makeText(MainActivity.this, "Registration Successful.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);
                            } else {

                                Toast.makeText(MainActivity.this, "Registration F`ailed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "User already Exists.\n Please sign in", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "password not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {

        String text=parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();

    }



    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}