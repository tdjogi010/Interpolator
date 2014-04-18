package com.mac.interpolator.interpolator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Main_interpolator extends Activity implements OnClickListener {

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
        y = (TextView) findViewById(R.id.et_y);


        y2.setOnClickListener(this);
        y1.setOnClickListener(this);
        x2.setOnClickListener(this);
        x1.setOnClickListener(this);
        x.setOnClickListener(this);

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
    public void onClick(View v) {

     //y.setText((y2.getText()-y1.getText())*(x.getText()-x1.getText())/(x2.getText()-x1.getText()));
    }
}
