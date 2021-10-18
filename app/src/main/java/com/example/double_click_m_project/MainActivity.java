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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void signuppage (View view){
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


//        @SuppressLint("WrongConstant") SQLiteDatabase  mydb= openOrCreateDatabase ("DoubleClickProject.db" , SQLiteDatabase.CREATE_IF_NECESSARY , null);
//        mydb.execSQL("CREATE TABLE IF NOT EXISTS useres(id VARCHAR , name VARCHAR , password VARCHAR , role VARCHAR);");
    }
}