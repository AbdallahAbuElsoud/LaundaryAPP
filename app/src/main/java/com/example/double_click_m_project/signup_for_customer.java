package com.example.double_click_m_project;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class signup_for_customer extends AppCompatActivity {
    SQLiteDatabase DB ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DB= openOrCreateDatabase("DoubleClick", MODE_PRIVATE, null);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_for_customer);

        }

    public void signupcustomer (View view){
        EditText cname =findViewById(R.id.namecustomer);
        EditText cemail = findViewById(R.id.emailcustomer);
        EditText cphone = findViewById(R.id.cusstomerPhone);
        EditText cpassword = findViewById(R.id.signuppass);


        switch (view.getId()){
            case R.id.signupforcustomer:
                Toast.makeText(getApplicationContext(),cname.getText(),Toast.LENGTH_LONG).show();
               if (cname.getText().toString().equals("") || cemail.getText().toString().equals("") || cpassword.getText().toString().equals("") || cphone.getText().toString().equals("")){
                   Toast.makeText(getApplicationContext(),"fill the info",Toast.LENGTH_LONG).show();
               }else {
                   DB.execSQL("INSERT INTO customer VALUES ('"+cname.getText()+"'"+",'"+cemail.getText()+"'"+",'"+cphone.getText()+"'"+");");
                   DB.execSQL("INSERT INTO users VALUES ('"+cname.getText()+"'"+",'"+cemail.getText()+"'"+",'"+cpassword.getText()+"'"+",'customer'"+");");
                   Toast.makeText(getApplicationContext(),"saved",Toast.LENGTH_LONG).show();
                   Intent i=new Intent(this, MainActivity.class);
                   startActivity(i);
               }
                break;
        }
    }
}
