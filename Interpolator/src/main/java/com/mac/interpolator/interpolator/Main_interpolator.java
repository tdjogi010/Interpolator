package com.mac.interpolator.interpolator;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class Main_interpolator extends Activity implements TextWatcher {

    EditText y2,y1,x2,x1,x;
    TextView y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        ActionBar actionbar=getActionBar();
        actionbar.show();
        setContentView(R.layout.layout_main_interpolator);
        y2 = (EditText) findViewById(R.id.et_y2);
        y1 = (EditText) findViewById(R.id.et_y1);
        x2 = (EditText) findViewById(R.id.et_x2);
        x1 = (EditText) findViewById(R.id.et_x1);
        x = (EditText) findViewById(R.id.et_x);
        y = (TextView) findViewById(R.id.tv_y);

        y2.setHint("0");
        y1.setHint("0");
        x2.setHint("0");
        x1.setHint("0");
        x.setHint("0");



        y2.addTextChangedListener(this) ;
        y1.addTextChangedListener(this) ;
        x2.addTextChangedListener(this) ;
        x1.addTextChangedListener(this) ;
        x.addTextChangedListener(this) ;

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
            case R.id.about1:
                Intent main = new Intent(Main_interpolator.this,About.class);
                startActivity(main);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        try {
            float vy2 = Float.parseFloat(y2.getText().toString());
            float vy1 = Float.parseFloat(y1.getText().toString());
            float vx2 = Float.parseFloat(x2.getText().toString());
            float vx1 = Float.parseFloat(x1.getText().toString());
            float vx = Float.parseFloat(x.getText().toString());

            float vy = (vy2 - vy1) * (vx - vx1) / (vx2 - vx1) + vy1;
            y.setText("" + vy);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            y.setText("");
        }
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }

}

