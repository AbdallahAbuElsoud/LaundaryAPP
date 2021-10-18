package com.example.double_click_m_project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class signup_home_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_home_page);
    }
    public void signuphom (View view){

        switch (view.getId()){
            case R.id.signupascust:
                Toast.makeText(getApplicationContext(), "go to signupfotcustomer", Toast.LENGTH_LONG).show();
                Intent i=new Intent(this, signup_for_customer.class);
                startActivity(i);
                break;
        }
    }


}
