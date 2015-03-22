package com.example.malika.contactmanager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by Malika Pahva (mxp134930) on 3/19/2015.
 * Course: CS6301.001
 *
 * This class launches the app.
 */
public class LauncherActivity extends ActionBarActivity {

    /**
     * This method specifies the activity to show at startup
     * when app launches.
     *
     * Author: Malika Pahva(mxp134930)
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent();
        intent.setClassName("com.example.malika.contactmanager", "com.example.malika.contactmanager.activity.ContactInfo");
        startActivity(intent);
        finish();
    }
}
