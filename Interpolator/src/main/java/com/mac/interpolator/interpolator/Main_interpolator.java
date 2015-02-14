package com.mac.interpolator.interpolator;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;

public class Main_interpolator extends ActionBarActivity implements Main_fragment.OnPlotClickListener {

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0){
            getFragmentManager().popBackStackImmediate();
            getFragmentManager().beginTransaction().commit();
        } else {
            super.onBackPressed();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //ActionBar actionbar=getActionBar();
        //actionbar.show();
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        Main_fragment main_fragment = new Main_fragment();
        getFragmentManager().beginTransaction().add(R.id.fragment,main_fragment,"main_fragment")
                .commit();





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
    public void OnPlotClick(InterpolatorPoints interpolatorPoints) {
        try {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }catch (NullPointerException e){
            Log.d("Exception","Lite");
        }

        Graph_Fragment graph_fragment = new Graph_Fragment();
        Bundle bundle = new Bundle();
        bundle.putFloat("x",interpolatorPoints.x);
        bundle.putFloat("y",interpolatorPoints.y);
        bundle.putFloat("x1",interpolatorPoints.x1);
        bundle.putFloat("x2",interpolatorPoints.x2);
        bundle.putFloat("y1",interpolatorPoints.y1);
        bundle.putFloat("y2", interpolatorPoints.y2);
        graph_fragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment, graph_fragment, "graph_fragmet");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
}

