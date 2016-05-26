package com.example.lenovo.tester1;
import com.firebase.client.Firebase;
/**
 * Created by LENOVO on 4/9/2016.
 */
public class Tester1  extends android.app.Application  {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
