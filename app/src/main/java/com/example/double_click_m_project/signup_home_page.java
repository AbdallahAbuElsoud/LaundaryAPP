package com.example.double_click_m_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.database.Cursor;
import androidx.appcompat.app.AppCompatActivity;

public class signup_home_page extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_home_page);
    }

    public void signuphome (View view){
        switch (view.getId()){
            case R.id.signupascust:
                Toast.makeText(getApplicationContext(), "welcome customer", Toast.LENGTH_LONG).show();
                Intent i=new Intent(this, signup_for_customer.class);
                startActivity(i);
                break;
            case R.id.signupasLundry:
                Toast.makeText(getApplicationContext(), "welcome laundry", Toast.LENGTH_LONG).show();
                Intent j=new Intent(this, signup_for_customer.class);
                startActivity(j);
                break;

            case R.id.signupAsDriv:
                Toast.makeText(getApplicationContext(), "welcome Driver", Toast.LENGTH_LONG).show();
                Intent z=new Intent(this, signup_for_customer.class);
                startActivity(z);
                break;
        }
    }
}
