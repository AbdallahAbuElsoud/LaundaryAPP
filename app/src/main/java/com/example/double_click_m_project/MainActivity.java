package com.example.double_click_m_project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DB= openOrCreateDatabase("DoubleClick", MODE_PRIVATE, null);
        DB.execSQL("CREATE TABLE IF NOT EXISTS customer (name VARCHAR , email VARCHAR , phonenumber INT);");
        DB.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR , email VARCHAR , password VARCHAR , role VARCHAR );");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void loginPage (View view){
        switch (view.getId()) {
            case R.id.signupbtn:
                Toast.makeText(getApplicationContext(), "signup", Toast.LENGTH_LONG).show();
                Intent i=new Intent(this, signup_home_page.class);
                startActivity(i);
                break;
            case R.id.loginbtn :

                Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_LONG).show();
                break;

        }
    }
}