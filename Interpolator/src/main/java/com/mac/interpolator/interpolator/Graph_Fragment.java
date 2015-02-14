package com.mac.interpolator.interpolator;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;

/**
 * Created by tj on 2/14/15.
 */
public class Graph_Fragment extends Fragment {

    InterpolatorPoints interpolatorPoints;

    //LineGraphSeries lineGraphSeries = new LineGraphSeries(new  )


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.graph_fragment,container,false);
        Float x=getArguments().getFloat("x");
        Float y=getArguments().getFloat("y");
        Float x1=getArguments().getFloat("x1");
        Float x2=getArguments().getFloat("x2");
        Float y1=getArguments().getFloat("y1");
        Float y2=getArguments().getFloat("y2");
        interpolatorPoints = new InterpolatorPoints(x,y,x1,x2,y1,y2);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_graph);
        LineGraphView lineGraphView = new LineGraphView(getActivity(),"Mygraph");
        GraphView.GraphViewData graphViewData[] = new GraphView.GraphViewData[3];
        if (x>x1 && x>x2){
            graphViewData[2]= new GraphView.GraphViewData(x,y);
            if (x2>x1) {
                graphViewData[1] =new GraphView.GraphViewData(x2,y2);
                graphViewData[0] =new GraphView.GraphViewData(x1,y1);
            }
            else{
                graphViewData[0] =new GraphView.GraphViewData(x2,y2);
                graphViewData[1] =new GraphView.GraphViewData(x1,y1);
            }
        }else if (x1>x && x1>x2){
            graphViewData[2]= new GraphView.GraphViewData(x1,y1);
            if (x2>x) {
                graphViewData[1] =new GraphView.GraphViewData(x2,y2);
                graphViewData[0] =new GraphView.GraphViewData(x,y);
            }
            else{
                graphViewData[0] =new GraphView.GraphViewData(x2,y2);
                graphViewData[1] =new GraphView.GraphViewData(x,y);
            }
        }else {
            graphViewData[2]= new GraphView.GraphViewData(x2,y2);
            if (x>x1) {
                graphViewData[1] =new GraphView.GraphViewData(x,y);
                graphViewData[0] =new GraphView.GraphViewData(x1,y1);
            }
            else{
                graphViewData[0] =new GraphView.GraphViewData(x,y);
                graphViewData[1] =new GraphView.GraphViewData(x1,y1);
            }
        }
        GraphViewSeries graphViewSeries = new GraphViewSeries("Graph",
                new GraphViewSeries.GraphViewSeriesStyle(Color.rgb(200,0,0),3),graphViewData);
        lineGraphView.addSeries(graphViewSeries);

        //lineGraphView.setShowLegend(true);
        lineGraphView.setLegendAlign(GraphView.LegendAlign.BOTTOM);
        lineGraphView.getGraphViewStyle().setLegendBorder(20);
        lineGraphView.getGraphViewStyle().setLegendSpacing(30);
        lineGraphView.getGraphViewStyle().setLegendWidth(300);

        lineGraphView.setViewPort(2, 10);
        lineGraphView.setScalable(true);

        linearLayout.addView(lineGraphView);


        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
