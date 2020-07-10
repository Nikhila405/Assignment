package com.example.recyclerviewtask;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {


    RecyclerView rv;

    int images[] = { R.drawable.beta, R.drawable.cupcake, R.drawable.donut,
            R.drawable.froyo, R.drawable.gingerbread, R.drawable.honeycomb,
            R.drawable.jellybean, R.drawable.kitkat,  R.drawable.marshmallow,
            R.drawable.nougat,  R.drawable.pie};

    String codeName[] = { "Beta", "Cupcake", "Donut",  "Froyo", "GingerBread",
            "HoneyComb", "Jellybean", "KitKat",  "Marshmallow",
            "Nougat", "Pie", };

    String versionNumber[] = { "1.1", "1.5", "1.6",  "2.2", "2.3", "3.0",
            "4.1", "4.4", "6.0", "7.0",  "9.0"};

    String ApiLevel[] = { "2", "3", "4",  "8", "9-10", "11-13", "14-15", "16-18",
             "21-22", "23", "24-25", "26-27", "28""};

    String ReleaseDate[] = { "February 9, 2009", "April 27, 2009",
            "September 15, 2009",  "May 20, 2010", "December 6, 2010",
            "October 18, 2011", "July 9, 2012", "October 31, 2013",  "October 5, 2015",
            "August 21, 2019"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.recycle);

        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        MyAdapter adapter = new MyAdapter(MainActivity.this, images, codeName, versionNumber, ApiLevel, ReleaseDate);
        rv.setAdapter(adapter);

    }
}
