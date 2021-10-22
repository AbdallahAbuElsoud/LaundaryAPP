package com.example.double_click_m_project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase DB;
    int flag = 0;
    String role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DB = openOrCreateDatabase("DoubleClick", MODE_PRIVATE, null);
        DB.execSQL("CREATE TABLE IF NOT EXISTS customer (name VARCHAR , email VARCHAR , phonenumber INT);");
        DB.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR , email VARCHAR , password VARCHAR , role VARCHAR );");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loginPage(View view) {
        EditText username = findViewById(R.id.username);
        EditText Password = findViewById(R.id.Password);
        switch (view.getId()) {
            case R.id.signupbtn:
                Toast.makeText(getApplicationContext(), "signup", Toast.LENGTH_LONG).show();
                Intent i = new Intent(this, signup_home_page.class);
                startActivity(i);
                break;
            case R.id.loginbtn:
                if (username.getText().toString().equals("") || Password.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "fill the info", Toast.LENGTH_LONG).show();
                } else {
                    Cursor c = DB.rawQuery("select name,password,role from users", null);

                    if (c.moveToFirst()) {
                        do {
                            if (username.getText().toString().equals(c.getString(0))) {
                                if (Password.getText().toString().equals(c.getString(1))) {
                                    username.setText("");
                                    Password.setText("");
                                    flag = 1;
                                    role=c.getString(2);
                                }
                            }
                        } while (c.moveToNext());
                        if (flag == 1) {
                            if (role.equals("customer")) {
                                Intent z = new Intent(this, homepage_for_customer.class);
                                startActivity(z);
                            }else {
                                Toast.makeText(getApplicationContext(), "coming soon", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Wrong UserName or Password", Toast.LENGTH_LONG).show();
                        }
                    }
                }
                    break;

                }
        }
    }
