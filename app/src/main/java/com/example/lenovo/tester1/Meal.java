package com.example.lenovo.tester1;

/**
 * Created by LENOVO on 4/9/2016.
 */
public class Meal {

    String myname;
    String mypin;
    String mycontact;

    public Meal() {
    }

    public Meal(String myname, String mypin, String mycontact) {
        this.myname = myname;
        this.mypin = mypin;
        this.mycontact = mycontact;
    }

    public String getMyname() {
        return myname;
    }

    public String getMypin() {
        return mypin;
    }

    public String getMycontact() {
        return mycontact;
    }
}

