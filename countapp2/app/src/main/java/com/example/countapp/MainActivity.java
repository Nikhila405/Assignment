package com.example.countapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   int c=0;
   TextView obj;
   Button zero, toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        obj= findViewById(R.id.textView);
        zero=findViewById(R.id.zero);
        toast=findViewById(R.id.Toast);
        if(savedInstanceState!=null){
              String s = savedInstanceState.getString(("xyz"));
              obj.setText(s);
              c=Integer.parseInt(s);
        }
    }



    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String s=obj.getText().toString();
        outState.putString("xyz",s);
    }

    public void add(View view) {
        c++;
        obj.setText(""+c);

    }

    public void sub(View view) {
        c--;
        obj.setText(""+c);
    }

    public void zero(View view) {
        c=0;

        obj.setText(""+c);
    }

    public void Toast(View view) {
        String s=obj.getText().toString() ;
        Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT);
    }
}