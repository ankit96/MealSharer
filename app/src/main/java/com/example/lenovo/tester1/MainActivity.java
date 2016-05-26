package com.example.lenovo.tester1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.firebase.client.Firebase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
Button b;
    Firebase mRef;
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
        EditText t2=(EditText)findViewById(R.id.editText3);

        String name=t.getText().toString();
        String pin=t1.getText().toString();
        String contact=t2.getText().toString();

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
    public void fun2(View v)
    {
        Intent in=new Intent(this,ViewList.class);
        this.startActivity(in);
    }


}
