package com.mac.interpolator.interpolator;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class Main_interpolator extends ActionBarActivity implements TextWatcher {

    EditText et_y2, et_y1, et_x2, et_x1, et_x;
    TextView y,x1,x2,y1,y2,x,result,dev,mac,bitsg;
    static Typeface fontthin,font,fontbold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //ActionBar actionbar=getActionBar();
        //actionbar.show();
        setContentView(R.layout.layout_main_interpolator);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);


        font= Typeface.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");
        fontthin= Typeface.createFromAsset(getAssets(), "fonts/Roboto-Thin.ttf");
        fontbold=Typeface.createFromAsset(getAssets(), "fonts/Roboto-Bold.ttf");

        et_y2 = (EditText) findViewById(R.id.et_y2);
        et_y2.setTypeface(font,Typeface.NORMAL);
        et_y1 = (EditText) findViewById(R.id.et_y1);
        et_y1.setTypeface(font,Typeface.NORMAL);
        et_x2 = (EditText) findViewById(R.id.et_x2);
        et_x2.setTypeface(font,Typeface.NORMAL);
        et_x1 = (EditText) findViewById(R.id.et_x1);
        et_x1.setTypeface(font, Typeface.NORMAL);
        et_x = (EditText) findViewById(R.id.et_x);
        et_x.setTypeface(font, Typeface.NORMAL);
        y = (TextView) findViewById(R.id.tv_res);
        y.setTypeface(font, Typeface.NORMAL);
        x = (TextView) findViewById(R.id.tv_x);
        x.setTypeface(font,Typeface.NORMAL);
        x1 = (TextView) findViewById(R.id.tv_x1);
        x1.setTypeface(font,Typeface.NORMAL);
        x2 = (TextView) findViewById(R.id.tv_x2);
        x2.setTypeface(font,Typeface.NORMAL);
        y1 = (TextView) findViewById(R.id.tv_y1);
        y1.setTypeface(font,Typeface.NORMAL);
        y2 = (TextView) findViewById(R.id.tv_y2);
        y2.setTypeface(font,Typeface.NORMAL);
        y2 = (TextView) findViewById(R.id.tv_y2);
        y2.setTypeface(font,Typeface.NORMAL);
        result = (TextView) findViewById(R.id.tv_res);
        result.setTypeface(font,Typeface.NORMAL);
        dev = (TextView) findViewById(R.id.dev);
        dev.setTypeface(font,Typeface.NORMAL);
        mac = (TextView) findViewById(R.id.MAC);
        mac.setTypeface(font,Typeface.BOLD);
        bitsg = (TextView) findViewById(R.id.bitsg);
        bitsg.setTypeface(font,Typeface.NORMAL);

        et_y2.addTextChangedListener(this) ;
        et_y1.addTextChangedListener(this) ;
        et_x2.addTextChangedListener(this) ;
        et_x1.addTextChangedListener(this) ;
        et_x.addTextChangedListener(this) ;

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_interpolator, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            case R.id.about:
                Intent about = new Intent(Main_interpolator.this,About.class);
                startActivity(about);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        try {
            float vy2 = Float.parseFloat(et_y2.getText().toString());
            float vy1 = Float.parseFloat(et_y1.getText().toString());
            float vx2 = Float.parseFloat(et_x2.getText().toString());
            float vx1 = Float.parseFloat(et_x1.getText().toString());
            float vx = Float.parseFloat(et_x.getText().toString());
            float vy = (vy2 - vy1) * (vx - vx1) / (vx2 - vx1) + vy1;
            y.setText("" + vy);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            y.setText("");
        }
    }

}

