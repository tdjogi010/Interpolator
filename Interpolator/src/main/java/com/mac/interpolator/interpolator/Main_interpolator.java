package com.mac.interpolator.interpolator;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Main_interpolator extends Activity implements TextWatcher {

    EditText y2,y1,x2,x1,x;
    TextView y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_main_interpolator);
        y2 = (EditText) findViewById(R.id.et_y2);
        y1 = (EditText) findViewById(R.id.et_y1);
        x2 = (EditText) findViewById(R.id.et_x2);
        x1 = (EditText) findViewById(R.id.et_x1);
        x = (EditText) findViewById(R.id.et_x);
        y = (TextView) findViewById(R.id.tv_y);

<<<<<<< HEAD
        y2.setText("0");
        y1.setText("0");
        x2.setText("0");
        x1.setText("0");
        x.setText("0");



        y2.addTextChangedListener(this) ;
        y1.addTextChangedListener(this) ;
        x2.addTextChangedListener(this) ;
        x1.addTextChangedListener(this) ;
        x.addTextChangedListener(this) ;
=======

        y2.setOnClickListener(this);
        y1.setOnClickListener(this);
        x2.setOnClickListener(this);
        x1.setOnClickListener(this);
        x.setOnClickListener(this);
>>>>>>> 108567d9e98162df2753d5eb954127bfdcdfaaf0

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_interpolator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
<<<<<<< HEAD
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        float vy2= Float.parseFloat(y2.getText().toString());
        float vy1= Float.parseFloat(y1.getText().toString());
        float vx2= Float.parseFloat(x2.getText().toString());
        float vx1= Float.parseFloat(x1.getText().toString());
        float vx= Float.parseFloat(x.getText().toString());

        float vy=(vy2-vy1)*(vx-vx1)/(vx2-vx1) + vy1;

        y.setText(""+vy);
=======
    public void onClick(View v) {
        //y.setText((y2.getText()-y1.getText())*(x.getText()-x1.getText())/(x2.getText()-x1.getText()));
>>>>>>> 108567d9e98162df2753d5eb954127bfdcdfaaf0
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

}

