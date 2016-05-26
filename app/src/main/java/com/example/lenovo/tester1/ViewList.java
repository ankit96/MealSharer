package com.example.lenovo.tester1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


import com.firebase.client.Firebase;
import com.firebase.ui.FirebaseListAdapter;

public class ViewList extends AppCompatActivity {
    Firebase mRef;
    ListView listView;

    FirebaseListAdapter<Meal> mListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list);


        mRef = new Firebase("https://amber-heat-9780.firebaseio.com/meals");
        listView = (ListView) this.findViewById(R.id.List);
        mListAdapter = new FirebaseListAdapter<Meal>(this, Meal.class, android.R.layout.two_line_list_item, mRef) {
            @Override
            protected void populateView(View view, Meal meal) {
                ((TextView) view.findViewById(android.R.id.text1)).setText(meal.getMyname());
                ((TextView) view.findViewById(android.R.id.text2)).setText(meal.getMypin());
            }
        };
        listView.setAdapter(mListAdapter);


    }
    public void fun(View v)
    {
        EditText t=(EditText)findViewById(R.id.editText4);
        String uname=t.getText().toString();
        Intent in=new Intent(this,UserInfo.class);
        in.putExtra("name",uname);
        this.startActivity(in);

    }
}