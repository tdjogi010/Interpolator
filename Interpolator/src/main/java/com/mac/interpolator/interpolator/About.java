package com.mac.interpolator.interpolator;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

/**
 * Created by itboymd on 19/4/14.
 */
public class About extends ActionBarActivity {

    TextView abt,par1,par2,cred,md,tj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        Toolbar toolbar = (Toolbar)findViewById(R.id.my_toolbar_about);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        /*abt = (TextView) findViewById(R.id.about);
        abt.setTypeface(Main_interpolator.font, Typeface.BOLD);*/
        cred = (TextView) findViewById(R.id.credits);
        cred.setTypeface(Main_interpolator.font,Typeface.BOLD);
        par1 = (TextView) findViewById(R.id.para1);
        par1.setTypeface(Main_interpolator.font,Typeface.NORMAL);
        par2 = (TextView) findViewById(R.id.para2);
        par2.setTypeface(Main_interpolator.font,Typeface.NORMAL);
        md = (TextView) findViewById(R.id.MD);
        md.setTypeface(Main_interpolator.font,Typeface.BOLD);
        tj = (TextView) findViewById(R.id.TJ);
        tj.setTypeface(Main_interpolator.font,Typeface.BOLD);
    }

}
