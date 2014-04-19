package com.mac.interpolator.interpolator;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by itboymd on 19/4/14.
 */
public class About extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.about);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        super.onCreate(savedInstanceState);
    }

}
