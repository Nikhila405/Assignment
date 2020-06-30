package com.example.loginandregistration;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et;
    EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.username);
        et1= findViewById(R.id.password);
    }



    public void login(View view) {
        String data = et.getText().toString();
        if(data.isEmpty())
        {
            Toast.makeText(this,"please enter data",Toast.LENGTH_SHORT);
        }
        else
        {
            Intent i = new Intent(MainActivity.this,MainActivity2.class);
            i.putExtra("mydata",data);
            startActivity(i);
        }

        String data1 = et1.getText().toString();
        if(data.isEmpty())
        {
            Toast.makeText(this,"please enter data",Toast.LENGTH_SHORT);
        }
        else
        {
            Intent i = new Intent(MainActivity.this,MainActivity2.class);
            i.putExtra("mydata1",data1);
            startActivity(i);
        }
    }

    public void Register(View view) {
       Intent i = new Intent(MainActivity.this, MainActivity3.class);


    }
}