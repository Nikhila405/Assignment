package com.example.inputcontrolstest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_name, et_mobileno, et_emailid, et_password;
    RadioButton r_male,r_female;
    String gender;
    CheckBox ch_java, ch_python,ch_android;
    Spinner sp_district, sp_mandal;
    TextView tv_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name= findViewById(R.id.name);
        et_mobileno= findViewById(R.id.mobileno);
        et_emailid= findViewById(R.id.emailid);
        et_password= findViewById(R.id.password);
        r_male= findViewById(R.id.male);
        r_female= findViewById(R.id.female);
        ch_android= findViewById(R.id.android);
        ch_java= findViewById(R.id.java);
        ch_python= findViewById(R.id.python);

        sp_district= findViewById(R.id.district);
        sp_mandal=findViewById(R.id.mandal);

        ArrayAdapter<CharSequence> districts_adapter= ArrayAdapter.createFromResource(this,R.array.districts, android.R.layout.simple_spinner_item);
        sp_district.setAdapter(districts_adapter);

        sp_district.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Toast.makeText(MainActivity.this, "Please select District", Toast.LENGTH_SHORT).show();
                    case 1:
                        ArrayAdapter<CharSequence> atp_mandals=
                                ArrayAdapter.createFromResource(MainActivity.this,R.array.Anatapur_mandals, android.R.layout.simple_spinner_item);
                        sp_mandal.setAdapter(atp_mandals);
                        break;
                    case 2:
                        ArrayAdapter<CharSequence> knl_mandals=
                                ArrayAdapter.createFromResource(MainActivity.this,R.array.Anatapur_mandals, android.R.layout.simple_spinner_item);
                        sp_mandal.setAdapter(knl_mandals);
                        break;




                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void submit(View view) {
        String name = et_name.getText().toString();
        String email = et_emailid.getText().toString();
        String phone = et_mobileno.getText().toString();
        String pass = et_password.getText().toString();
        if (r_male.isChecked()) {
            gender = r_male.getText().toString();
        } else if (r_female.isChecked()) {
            gender = r_female.getText().toString();
        }
        StringBuilder builder = new StringBuilder();
        if (ch_java.isChecked()) {
            builder.append(ch_java.getText().toString() + ",");
        }

        if (ch_android.isChecked()) {
            builder.append(ch_android.getText().toString());
        }

        String district = sp_district.getSelectedItem().toString();


        tv_data.setText(name + "\n" + email + "\n" + phone + "\n" + pass + "\n" +
                gender + "\n" + builder.toString() + "\n" + district);


        String mandal = sp_district.getSelectedItem().toString();


        tv_data.setText(name + "\n" + email + "\n" + phone + "\n" + pass + "\n" +
                gender + "\n" + builder.toString() + "\n" + mandal);
    }
    }
