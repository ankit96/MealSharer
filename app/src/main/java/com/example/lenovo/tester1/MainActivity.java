package com.example.lenovo.tester1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
Button b;
    private TextView get_place;
    Firebase mRef;
    EditText t2;
    Button placebutton;
    int PLACE_PICKER_REQUEST=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void fun1(View v)
    {
        mRef = new Firebase("https://amber-heat-9780.firebaseio.com/meals");
        b=(Button)findViewById(R.id.button);
        EditText t=(EditText)findViewById(R.id.editText);
        EditText t1=(EditText)findViewById(R.id.editText2);
         t2=(EditText)findViewById(R.id.editText3);
        get_place=(TextView)findViewById(R.id.nameaddress);

        String name=t.getText().toString();
        String pin=t2.getText().toString();
        String contact=t1.getText().toString();

        /*RadioGroup rg1=(RadioGroup)findViewById(R.id.radioGroup);
        int selectedId = rg1.getCheckedRadioButtonId();
        RadioButton rb1 = (RadioButton) findViewById(selectedId);
        String time= rb1.getText().toString();

        RadioGroup rg2=(RadioGroup)findViewById(R.id.radioGroup2);
        int selectedId1 = rg2.getCheckedRadioButtonId();
        RadioButton rb2 = (RadioButton) findViewById(selectedId1);
        String pref= rb2.getText().toString();


        EditText t5=(EditText)findViewById(R.id.editText5);

        String date=t5.getText().toString();*/

        Map<String,Object> values = new HashMap<>();
        values.put("myname", name);
        values.put("mypin",pin);
        values.put("mycontact",contact);
        //values.put("time",time);
        //values.put("pref",pref);

        //values.put("date",date);
        mRef.push().setValue(values);


    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(this, data);
                String address=String.format("address: %s",place.getAddress());
                String name = String.format("name: %s", place.getName());
                Toast.makeText(this, name+address, Toast.LENGTH_LONG).show();
               // get_place.setText(name);
                //t2.append("400037");
            }
        }
    }

    public void fun2(View v)
    {
        Intent in=new Intent(this,ViewList.class);
        this.startActivity(in);
    }
    public void print(View v)
    {
        try {
            //Toast.makeText(this,"Hello", Toast.LENGTH_LONG).show();
            PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
            Intent i= builder.build(MainActivity.this);
            startActivityForResult(i, PLACE_PICKER_REQUEST);
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        }
    }


}
