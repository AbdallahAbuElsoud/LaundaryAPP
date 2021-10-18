package com.example.double_click_m_project;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.BreakIterator;

public class signup_for_customer extends Activity {
   EditText uname=(EditText) findViewById(R.id.signupname2);
    EditText upass=(EditText) findViewById(R.id.signuppass);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_for_customer


        );
    }

    public void assigncustomertodatabase (View view){
        SQLiteDatabase mydb = openOrCreateDatabase("DoubleClick", MODE_PRIVATE, null);
        mydb.execSQL("CREATE TABLE IF NOT EXISTS Customer(username VARCHAR , email VARCHAR , number VARCHAR);");
        mydb.execSQL("CREATE TABLE IF NOT EXISTS users(username VARCHAR , password VARCHAR , role VARCHAR);");

        switch (view.getId()){
            case R.id.signupforcustomer:
                Toast.makeText(getApplicationContext(), "hi : "+uname.getText(), Toast.LENGTH_LONG).show();
                mydb.execSQL("INSERT INTO users VALUES ('"+uname.getText()+"'"+"'"+upass.getText()+"'"+"'C'"+");");

                Intent i=new Intent(this, homepage_for_customer.class);
                startActivity(i);
                break;
        }
    }

}
