package com.mac.interpolator.interpolator;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by tj on 2/14/15.
 */
public class Main_fragment extends Fragment implements TextWatcher {
    OnPlotClickListener onPlotClickListener;
    public interface OnPlotClickListener{
        public void OnPlotClick(InterpolatorPoints interpolatorPoints);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        onPlotClickListener = (OnPlotClickListener) activity;

    }

    EditText et_y2, et_y1, et_x2, et_x1, et_x;
    Button b_plot ;
    TextView y,x1,x2,y1,y2,x,result,dev,mac,bitsg;
    static Typeface fontthin,font,fontbold;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_main_interpolator,container,false);
        font= Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Regular.ttf");
        fontthin= Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Thin.ttf");
        fontbold=Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Bold.ttf");
        setRetainInstance(true);

        et_y2 = (EditText) view.findViewById(R.id.et_y2);
        et_y2.setTypeface(font,Typeface.NORMAL);
        et_y1 = (EditText) view.findViewById(R.id.et_y1);
        et_y1.setTypeface(font,Typeface.NORMAL);
        et_x2 = (EditText) view.findViewById(R.id.et_x2);
        et_x2.setTypeface(font,Typeface.NORMAL);
        et_x1 = (EditText) view.findViewById(R.id.et_x1);
        et_x1.setTypeface(font, Typeface.NORMAL);
        et_x = (EditText) view.findViewById(R.id.et_x);
        et_x.setTypeface(font, Typeface.NORMAL);
        y = (TextView) view.findViewById(R.id.tv_res); //TODO
        y.setTypeface(font, Typeface.NORMAL);
        x = (TextView) view.findViewById(R.id.tv_x);
        x.setTypeface(font,Typeface.NORMAL);
        x1 = (TextView) view.findViewById(R.id.tv_x1);
        x1.setTypeface(font,Typeface.NORMAL);
        x2 = (TextView) view.findViewById(R.id.tv_x2);
        x2.setTypeface(font,Typeface.NORMAL);
        y1 = (TextView) view.findViewById(R.id.tv_y1);
        y1.setTypeface(font,Typeface.NORMAL);
        y2 = (TextView) view.findViewById(R.id.tv_y2);
        y2.setTypeface(font,Typeface.NORMAL);
        y2 = (TextView) view.findViewById(R.id.tv_y2);
        y2.setTypeface(font,Typeface.NORMAL);
        result = (TextView) view.findViewById(R.id.tv_res); //TODO Both accessing same textviews?
        result.setTypeface(font,Typeface.NORMAL);
        dev = (TextView) view.findViewById(R.id.dev);
        dev.setTypeface(font,Typeface.NORMAL);
        mac = (TextView) view.findViewById(R.id.MAC);
        mac.setTypeface(font,Typeface.BOLD);
        bitsg = (TextView) view.findViewById(R.id.bitsg);
        bitsg.setTypeface(font,Typeface.NORMAL);
        b_plot= (Button) view.findViewById(R.id.b_plot);
        b_plot.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                float vx=0,vy=0,vx1=0,vx2=0,vy1=0,vy2=0;
                try {
                    vy2 = Float.parseFloat(et_y2.getText().toString());
                    vy1 = Float.parseFloat(et_y1.getText().toString());
                    vx2 = Float.parseFloat(et_x2.getText().toString());
                    vx1 = Float.parseFloat(et_x1.getText().toString());
                    vx = Float.parseFloat(et_x.getText().toString());
                    vy = Float.parseFloat(y.getText().toString());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    Toast.makeText(getActivity(),"Please enter all the values",Toast.LENGTH_SHORT).show();
                    return;

                }

                if(!y.getText().toString().equals("NaN") && !y.getText().toString().equals("Infinity")  && !y.getText().toString().equals("-Infinity")) {
                    InterpolatorPoints interpolatorPoints = new InterpolatorPoints(vx, vy, vx1, vx2, vy1, vy2);
                    onPlotClickListener.OnPlotClick(interpolatorPoints);
                }
                else{
                    Toast.makeText(getActivity(),"Cannot plot a graph",Toast.LENGTH_SHORT).show();
                }
            }
        });

        et_y2.addTextChangedListener(this);
        et_y1.addTextChangedListener(this);
        et_x2.addTextChangedListener(this);
        et_x1.addTextChangedListener(this);
        et_x.addTextChangedListener(this);

        return view;
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
