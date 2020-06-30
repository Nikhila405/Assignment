package com.example.scoreboardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
     int TeamAscore=0;
     int TeamBscore=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void oneclickA(View view) {
        TeamAscore=TeamAscore+1;
        display(TeamAscore);
    }

    private void display(int teamAscore) {

        TextView TeamAValue= findViewById(R.id.Teamvalue1);
        TeamAValue.setText(""+teamAscore);
    }


    public void twoclickA(View view) {
        TeamAscore=TeamBscore+2;
        display(TeamAscore);
    }

    public void threeclickA(View view) {
        TeamAscore=TeamAscore+3;
        display(TeamAscore);
    }

    public void oneclickB(View view) {
        TeamBscore=TeamBscore+1;
        displayB(TeamBscore);
    }

    private void displayB(int teamBscore) {
        TextView TeamAValue= findViewById(R.id.Teamvalue1);
        TeamAValue.setText(""+teamBscore);

    }


    public void twoclickB(View view) {
        TeamBscore=TeamBscore+2;
        display(TeamBscore);
    }

    public void threeclickB(View view) {
        TeamBscore=TeamBscore+3;
        display(TeamBscore);
    }

    public void Reset(View view) {
        TeamAscore=0;
        TeamBscore=0;
        display(TeamAscore);
        display(TeamBscore);

    }
}