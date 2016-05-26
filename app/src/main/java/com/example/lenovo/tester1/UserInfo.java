package com.example.lenovo.tester1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.ui.FirebaseListAdapter;

public class UserInfo extends AppCompatActivity {
    String key;
    String ph;

    public void fun1(View v) {

        Toast.makeText(this, "HELLO", Toast.LENGTH_SHORT);
        Intent in = new Intent(Intent.ACTION_CALL);
        in.setData(Uri.parse("tel:" + ph));


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(in);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        Intent in = getIntent();
        key = in.getStringExtra("name");
        Log.d("rishi", key);
        Firebase mRef = new Firebase("https://amber-heat-9780.firebaseio.com/meals");
        ListView listView = (ListView) findViewById(R.id.List1);

        FirebaseListAdapter mListAdapter = new FirebaseListAdapter<Meal>(this, Meal.class, android.R.layout.two_line_list_item, mRef) {
            @Override
            protected void populateView(View view, Meal meal) {
                boolean b = (key == meal.getMyname());
                Log.d("k1", meal.getMyname());
                Log.d("meal", String.valueOf(b));
                if (meal.getMyname().equals(key)) {
                    Log.d("HELLO", key);
                    Toast.makeText(getApplicationContext(), "SU", Toast.LENGTH_SHORT).show();
                    ((TextView) view.findViewById(android.R.id.text1)).setText("NAME OF USER -> " + meal.getMyname());
                    ((TextView) view.findViewById(android.R.id.text2)).setText("CONTACT NUMBER -> " + meal.getMycontact() + "\n\n" + "PINCODE OF USER -> " + meal.getMypin());
                    ph = meal.getMycontact();
                }


            }
        };
        listView.setAdapter(mListAdapter);
    }


}
