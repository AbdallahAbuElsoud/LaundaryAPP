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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DB= openOrCreateDatabase("DoubleClick", MODE_PRIVATE, null);
        DB.execSQL("CREATE TABLE IF NOT EXISTS customer (name VARCHAR , email VARCHAR , phonenumber INT);");
        DB.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR , email VARCHAR , password VARCHAR , role VARCHAR );");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void loginPage (View view){
        EditText PersonName = findViewById(R.id.PersonName);
        EditText PersonPassword = findViewById(R.id.PersonPassword);
        int flag =0;
        String role="" ;
        switch (view.getId()) {
            case R.id.signupbtn:
                Toast.makeText(getApplicationContext(), "signup", Toast.LENGTH_LONG).show();
                Intent i=new Intent(this, signup_home_page.class);
                startActivity(i);
                break;
            case R.id.loginbtn :
                if (PersonName.getText().toString().equals("")||PersonPassword.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Please fill the Info", Toast.LENGTH_LONG).show();
                }
                Cursor myCursor = DB.rawQuery("select name,password,role from users", null);

                if (myCursor.moveToFirst()) {
                    do {


                        if (PersonName.getText().toString().equals(myCursor.getString(0))) {
                            if (PersonPassword.getText().toString().equals(myCursor.getString(1))) {
                                PersonName.setText("");
                                PersonPassword.setText("");
                                flag = 1;
                                role=myCursor.getString(2);
                            }
                        }

                    } while (myCursor.moveToNext());

                    if (flag == 1 ) {
                        if (role.equals("customer")) {
                            Intent z = new Intent(this, homepage_for_customer.class);
                            startActivity(z);
                        }else
                        {
                            Toast.makeText(getApplicationContext(), "another users will come Soon", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Wrong UserName or Password", Toast.LENGTH_LONG).show();
                    }
                }
                break;

        }
    }
}